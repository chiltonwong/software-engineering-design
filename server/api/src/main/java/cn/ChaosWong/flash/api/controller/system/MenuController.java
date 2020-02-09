package cn.ChaosWong.flash.api.controller.system;

import cn.ChaosWong.flash.api.controller.BaseController;
import cn.ChaosWong.flash.bean.constant.state.MenuStatus;
import cn.ChaosWong.flash.bean.core.BussinessLog;
import cn.ChaosWong.flash.bean.core.ShiroUser;
import cn.ChaosWong.flash.bean.dictmap.MenuDict;
import cn.ChaosWong.flash.bean.entity.system.Menu;
import cn.ChaosWong.flash.bean.enumeration.BizExceptionEnum;
import cn.ChaosWong.flash.bean.enumeration.Permission;
import cn.ChaosWong.flash.bean.exception.ApplicationException;
import cn.ChaosWong.flash.bean.vo.front.Rets;
import cn.ChaosWong.flash.bean.vo.node.MenuNode;
import cn.ChaosWong.flash.bean.vo.node.Node;
import cn.ChaosWong.flash.bean.vo.node.RouterMenu;
import cn.ChaosWong.flash.bean.vo.node.ZTreeNode;
import cn.ChaosWong.flash.cache.TokenCache;
import cn.ChaosWong.flash.service.system.LogObjectHolder;
import cn.ChaosWong.flash.service.system.MenuService;
import cn.ChaosWong.flash.service.system.impl.ConstantFactory;
import cn.ChaosWong.flash.utils.HttpUtil;
import cn.ChaosWong.flash.utils.Maps;
import cn.ChaosWong.flash.utils.StringUtil;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private TokenCache tokenCache;

    @RequestMapping(value = "/listForRouter", method = RequestMethod.GET)
    public Object listForRouter() {
        ShiroUser shiroUser = tokenCache.getUser(HttpUtil.getToken());

        List<RouterMenu> list = menuService.getSideBarMenus(shiroUser.getRoleList());
        return Rets.success(list);
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        List<MenuNode> list = menuService.getMenus();
        return Rets.success(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    @BussinessLog(value = "编辑菜单", key = "name", dict = MenuDict.class)
    @RequiresPermissions(value = {Permission.MENU_EDIT})
    public Object save(@ModelAttribute @Valid Menu menu) {

        if(menu.getId()==null) {
            String existedMenuName = ConstantFactory.me().getMenuNameByCode(menu.getCode());
            if (StringUtil.isNotEmpty(existedMenuName)) {
                throw new ApplicationException(BizExceptionEnum.EXISTED_THE_MENU);
            }
            menu.setStatus(MenuStatus.ENABLE.getCode());
        }


        menuService.menuSetPcode(menu);
        if(menu.getId()==null){
            menuService.insert(menu);
        }else {
            menuService.update(menu);
        }
        return Rets.success();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "删除菜单", key = "id", dict = MenuDict.class)
    @RequiresPermissions(value = {Permission.MENU_DEL})
    public Object remove(@RequestParam Long id) {
        logger.info("id:{}", id);
        if (id == null) {
            throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
        }

        if(id.intValue()<70){
            return Rets.failure("演示环境不允许删除初始菜单");
        }

        LogObjectHolder.me().set(ConstantFactory.me().getMenuName(id));
        menuService.delMenuContainSubMenus(id);
        return Rets.success();
    }


    @RequestMapping(value = "/menuTreeListByRoleId", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.MENU})
    public Object menuTreeListByRoleId(Integer roleId) {
        List<Long> menuIds = menuService.getMenuIdsByRoleId(roleId);
        List<ZTreeNode> roleTreeList = null;
        if (menuIds==null||menuIds.isEmpty()) {
            roleTreeList = menuService.menuTreeList(null);
        } else {
            roleTreeList = menuService.menuTreeList(menuIds);

        }
        List<Node> list = menuService.generateMenuTreeForRole(roleTreeList);


        Map<Long,ZTreeNode> map = cn.ChaosWong.flash.utils.Lists.toMap(roleTreeList,"id");
        Map<Long,List<ZTreeNode>> group = cn.ChaosWong.flash.utils.Lists.group(roleTreeList,"pId");
        for(Map.Entry<Long,List<ZTreeNode>> entry:group.entrySet()){
            if(entry.getValue().size()>1){
                roleTreeList.remove(map.get(entry.getKey()));
            }
        }

        List<Long> checkedIds = Lists.newArrayList();
        for (ZTreeNode zTreeNode : roleTreeList) {
            if (zTreeNode.getChecked() != null && zTreeNode.getChecked()
            &&zTreeNode.getpId().intValue()!=0) {
                checkedIds.add(zTreeNode.getId());
            }
        }
        return Rets.success(Maps.newHashMap("treeData", list, "checkedIds", checkedIds));
    }
}
