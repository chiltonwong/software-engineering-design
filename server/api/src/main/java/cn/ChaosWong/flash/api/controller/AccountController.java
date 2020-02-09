package cn.ChaosWong.flash.api.controller;

import cn.ChaosWong.flash.api.utils.ApiConstants;
import cn.ChaosWong.flash.bean.core.ShiroUser;
import cn.ChaosWong.flash.bean.entity.system.User;
import cn.ChaosWong.flash.bean.vo.front.Rets;
import cn.ChaosWong.flash.core.log.LogManager;
import cn.ChaosWong.flash.core.log.LogTaskFactory;
import cn.ChaosWong.flash.security.JwtUtil;
import cn.ChaosWong.flash.security.ShiroFactroy;
import cn.ChaosWong.flash.service.system.AccountService;
import cn.ChaosWong.flash.service.system.UserService;
import cn.ChaosWong.flash.utils.HttpUtil;
import cn.ChaosWong.flash.utils.MD5;
import cn.ChaosWong.flash.utils.Maps;
import cn.ChaosWong.flash.utils.StringUtil;
import org.nutz.mapl.Mapl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{
     private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam("username") String userName,
                        @RequestParam("password") String password){
        try {
            logger.info("用户登录:" + userName + ",密码:" + password);

            User user = userService.findByAccount(userName);
            if (user == null) {
                return Rets.failure("该用户不存在");
            }
            String passwdMd5 = MD5.md5(password, user.getSalt());

            if (!user.getPassword().equals(passwdMd5)) {
                return Rets.failure("输入的密码错误");
            }

            String token = JwtUtil.sign(user);
            Map<String, String> result = new HashMap<>(1);
            logger.info("token:{}",token);
            result.put("token", token);
            LogManager.me().executeLog(LogTaskFactory.loginLog(user.getId(), HttpUtil.getIp()));
            return Rets.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Rets.failure("登录时失败");
    }


    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Object logout(){
        HttpServletRequest request = HttpUtil.getRequest();
        String token = this.getToken(HttpUtil.getRequest());
        accountService.logout(token);
        Long idUser = getIdUser(request);
        LogManager.me().executeLog(LogTaskFactory.exitLog(idUser, HttpUtil.getIp()));
        return Rets.success();
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object info( ){
        HttpServletRequest request = HttpUtil.getRequest();
        Long idUser = null;
        try {
             idUser = getIdUser(request);
        }catch (Exception e){
            return Rets.expire();
        }
        if(idUser!=null){
            User user =  userService.get(idUser);
            if(StringUtil.isEmpty(user.getRoleid())){
                return Rets.failure("该用户未配置权限");
            }
            ShiroUser shiroUser = ShiroFactroy.me().shiroUser(user);
            Map map = Maps.newHashMap("name",user.getName(),"role","admin","roles", shiroUser.getRoleCodes());
            map.put("permissions",shiroUser.getUrls());
            Map profile = (Map) Mapl.toMaplist(user);
            profile.put("dept",shiroUser.getDeptName());
            profile.put("roles",shiroUser.getRoleNames());
            map.put("profile",profile);

            return Rets.success(map);
        }
        return Rets.failure("获取用户信息失败");
    }
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public Object updatePwd( String oldPassword,String password, String rePassword){
        try {
            User user = userService.get(getIdUser(HttpUtil.getRequest()));
            if( ApiConstants.ADMIN_ACCOUNT.equals(user.getAccount())){
                return Rets.failure("不能修改超级管理员密码");
            }
            logger.info("oldPassword:{},password:{},rePassword:{}",MD5.md5(oldPassword, user.getSalt()),password,rePassword);

            if(!MD5.md5(oldPassword, user.getSalt()).equals(user.getPassword())){
                return Rets.failure("旧密码输入错误");
            }
            if(!password.equals(rePassword)){
                return Rets.failure("新密码前后不一致");
            }
            user.setPassword(MD5.md5(password, user.getSalt()));
            userService.update(user);
            return Rets.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return Rets.failure("更改密码失败");
    }

}
