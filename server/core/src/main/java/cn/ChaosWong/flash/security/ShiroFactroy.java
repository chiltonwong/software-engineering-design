package cn.ChaosWong.flash.security;

import cn.ChaosWong.flash.bean.constant.state.ManagerStatus;
import cn.ChaosWong.flash.bean.core.ShiroUser;
import cn.ChaosWong.flash.bean.entity.system.Role;
import cn.ChaosWong.flash.bean.entity.system.User;
import cn.ChaosWong.flash.bean.vo.SpringContextHolder;
import cn.ChaosWong.flash.cache.TokenCache;
import cn.ChaosWong.flash.dao.system.MenuRepository;
import cn.ChaosWong.flash.dao.system.RoleRepository;
import cn.ChaosWong.flash.dao.system.UserRepository;
import cn.ChaosWong.flash.service.system.impl.ConstantFactory;
import cn.ChaosWong.flash.utils.Convert;
import cn.ChaosWong.flash.utils.HttpUtil;
import cn.ChaosWong.flash.utils.StringUtil;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy     {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TokenCache tokenCache;

    public static ShiroFactroy me() {
        return SpringContextHolder.getBean(ShiroFactroy.class);
    }


    public User user(String account) {

        User user = userRepository.findByAccount(account);


        if (null == user) {
            throw new CredentialsException();
        }

        if (user.getStatus() != ManagerStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }


    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = tokenCache.getUser(HttpUtil.getToken());
        if(shiroUser!=null){
            return shiroUser;
        }
        shiroUser = new ShiroUser();
        shiroUser.setId(Long.valueOf(user.getId()));
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptid());
        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));
        shiroUser.setName(user.getName());
        shiroUser.setPassword(user.getPassword());
        Long[] roleArray = Convert.toLongArray(",", user.getRoleid());
        List<Long> roleList = new ArrayList<Long>();
        List<String> roleNameList = new ArrayList<String>();
        List<String> roleCodeList = new ArrayList<String>();
        Set<String> permissions = new HashSet<String>();
        Set<String> resUrls = new HashSet<>();
        for (Long roleId : roleArray) {
            roleList.add(roleId);
            Role role = roleRepository.getOne(roleId);
            roleNameList.add(role.getName());
            roleCodeList.add(role.getTips());
            permissions.addAll(menuRepository.getResCodesByRoleId(roleId));
            List<String> list = menuRepository.getResUrlsByRoleId(roleId);
             for(String resUrl:list) {
                if(StringUtil.isNotEmpty(resUrl)) {
                 resUrls.add(resUrl);
                }
             }


        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        shiroUser.setRoleCodes(roleCodeList);
        shiroUser.setPermissions(permissions);

        shiroUser.setUrls(resUrls);
        tokenCache.setUser(HttpUtil.getToken(),shiroUser);
        return shiroUser;
    }

    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();

        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
