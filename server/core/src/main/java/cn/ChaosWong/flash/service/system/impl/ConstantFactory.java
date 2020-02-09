package cn.ChaosWong.flash.service.system.impl;

import cn.ChaosWong.flash.bean.constant.cache.CacheKey;
import cn.ChaosWong.flash.bean.constant.state.ManagerStatus;
import cn.ChaosWong.flash.bean.constant.state.MenuStatus;
import cn.ChaosWong.flash.bean.entity.system.*;
import cn.ChaosWong.flash.bean.vo.DictVo;
import cn.ChaosWong.flash.bean.vo.SpringContextHolder;
import cn.ChaosWong.flash.cache.ConfigCache;
import cn.ChaosWong.flash.cache.DictCache;
import cn.ChaosWong.flash.dao.system.*;
import cn.ChaosWong.flash.service.system.IConstantFactory;
import cn.ChaosWong.flash.service.system.LogObjectHolder;
import cn.ChaosWong.flash.utils.Convert;
import cn.ChaosWong.flash.utils.StringUtil;
import cn.ChaosWong.flash.utils.cache.TimeCacheMap;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Component
@DependsOn("springContextHolder")
@CacheConfig
public class ConstantFactory implements IConstantFactory {
    public static TimeCacheMap<String, String> cache = new TimeCacheMap<String, String>(3600, 2);
    private RoleRepository roleRepository = SpringContextHolder.getBean(RoleRepository.class);
    private DeptRepository deptRepository = SpringContextHolder.getBean(DeptRepository.class);
    private DictCache dictCache = SpringContextHolder.getBean(DictCache.class);
    private DictRepository dictRepository = SpringContextHolder.getBean(DictRepository.class);
    private UserRepository userRepository = SpringContextHolder.getBean(UserRepository.class);
    private MenuRepository menuRepository = SpringContextHolder.getBean(MenuRepository.class);
    private NoticeRepository sysNoticeRepository = SpringContextHolder.getBean(NoticeRepository.class);
    private ConfigCache configCache = SpringContextHolder.getBean(ConfigCache.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void set(String key, String val) {
        cache.put(key, val);

    }


    @Override
    public String getUserNameById(Long userId) {
        String val = get(CacheKey.SYS_USER_NAME + userId);
        if (StringUtil.isNotEmpty(val)) {
            return val;
        }

        User user = getUser(userId);
        if (user != null) {
            val = user.getName();
            set(CacheKey.SYS_USER_NAME + userId, val);
            return val;
        }


        return "--";
    }

    private User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user;
        }
        return null;
    }


    @Override
    public String getUserAccountById(Long userId) {
        User user = getUser(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }


    @Override
    public String getRoleName(String roleIds) {
        String val = get(CacheKey.ROLES_NAME + roleIds);
        if (StringUtil.isNotEmpty(val)) {
            return val;
        }
        Integer[] roles = Convert.toIntArray(roleIds);
        StringBuilder sb = new StringBuilder();
        for (Integer role : roles) {
            Role roleObj = getRole(Long.valueOf(role));
            if (StringUtil.isNotNullOrEmpty(roleObj) && StringUtil.isNotEmpty(roleObj.getName())) {
                sb.append(roleObj.getName()).append(",");
            }
        }
        val = StringUtil.removeSuffix(sb.toString(), ",");
        set(CacheKey.ROLES_NAME + roleIds, val);
        return val;
    }


    @Override
    public String getSingleRoleName(Long roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = getRole(roleId);
        if (StringUtil.isNotNullOrEmpty(roleObj) && StringUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }


    @Override
    public String getSingleRoleTip(Long roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = getRole(roleId);
        if (StringUtil.isNotNullOrEmpty(roleObj) && StringUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getTips();
        }
        return "";
    }


    @Override
    public String getDeptName(Long deptId) {
        if (deptId == null) {
            return null;
        }
        String val = get(CacheKey.DEPT_NAME + deptId);
        if (StringUtil.isNotEmpty(val)) {
            return val;
        }
        Dept dept = getDept(deptId);
        if (StringUtil.isNotNullOrEmpty(dept) && StringUtil.isNotEmpty(dept.getFullname())) {
            val = dept.getFullname();
            set(CacheKey.DEPT_NAME + deptId, val);
            return val;
        }
        return "";
    }


    @Override
    public String getMenuNames(String menuIds) {
        Integer[] menuArray = Convert.toIntArray(menuIds);
        StringBuilder sb = new StringBuilder();
        for (int menuId : menuArray) {
            Menu menuObj = getMenu(Long.valueOf(menuId));
            if (StringUtil.isNotNullOrEmpty(menuObj) && StringUtil.isNotEmpty(menuObj.getName())) {
                sb.append(menuObj.getName()).append(",");
            }
        }
        return StringUtil.removeSuffix(sb.toString(), ",");
    }


    @Override
    public String getMenuName(Long menuId) {

        Menu menu = getMenu(menuId);
        if (menu == null) {
            return "";
        } else {
            return menu.getName();
        }
    }


    @Override
    public String getMenuNameByCode(String code) {

        Menu menu = menuRepository.findByCode(code);
        if (menu == null) {
            return "";
        } else {
            return menu.getName();
        }
    }

    @Override
    public List<DictVo> findByDictName(String dictName) {

        List<DictVo> list = new ArrayList<DictVo>();

        List<Dict> dicts = dictCache.getDictsByPname(dictName);
        if (dicts != null) {
            for (int i = 0; i < dicts.size(); i++) {
                Dict dict = dicts.get(i);
                DictVo dictVo = new DictVo(dict.getNum(), dict.getName());
                list.add(dictVo);
            }
        }
        return list;
    }


    @Override
    public String getDictName(Long dictId) {

        String val = get(CacheKey.DICT_NAME + dictId);
        if (StringUtil.isNotEmpty(val)) {
            return val;
        }
        val = dictCache.getDict(dictId);
        set(CacheKey.DICT_NAME + dictId, val);
        return val;

    }


    @Override
    public String getNoticeTitle(Long id) {

        Notice notice = getNotice(id);
        if (notice == null) {
            return "";
        } else {
            return notice.getTitle();
        }

    }


    @Override
    public String getDictsByName(String name, String val) {
        String result = get(CacheKey.DICT_NAME + name + val);
        if (StringUtil.isNotEmpty(result)) {
            return result;
        }
        List<Dict> dicts = dictCache.getDictsByPname(name);
        for (Dict item : dicts) {
            if (item.getNum() != null && item.getNum().equals(val)) {
                result = item.getName();
                set(CacheKey.DICT_NAME + name + val, result);
                return result;
            }
        }
        return "";

    }


    @Override
    public String getSexName(Integer sex) {
        return getDictsByName("性别", String.valueOf(sex));
    }

    @Override
    public String getCardTypeName(String cardType) {
        return getDictsByName("银行卡类型", cardType);
    }

    @Override
    public String getIdCardTypeName(String cardType) {
        return getDictsByName("证件类型", cardType);
    }

    @Override
    public String getRelationName(String relation) {
        return getDictsByName("联系人关系", relation);
    }


    @Override
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }


    @Override
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }


    @Override
    public List<Dict> findInDict(Long id) {
        return dictRepository.findByPid(id);

    }


    @Override
    public String getCacheObject(String para) {
        return LogObjectHolder.me().get().toString();
    }


    @Override
    public List<Long> getSubDeptId(Long deptid) {

        List<Dept> depts = this.deptRepository.findByPidsLike("%[" + deptid + "]%");

        ArrayList<Long> deptids = new ArrayList<>();

        if (depts != null && depts.size() > 0) {
            for (Dept dept : depts) {
                deptids.add(dept.getId());
            }
        }

        return deptids;
    }


    @Override
    public List<Integer> getParentDeptIds(Long deptid) {
        Dept dept = getDept(deptid);
        String pids = dept.getPids();
        String[] split = pids.split(",");
        ArrayList<Integer> parentDeptIds = new ArrayList<>();
        for (String s : split) {
            parentDeptIds.add(Integer.valueOf(StringUtil.removeSuffix(StringUtil.removePrefix(s, "["), "]")));
        }
        return parentDeptIds;
    }


    @Override
    public List<Dict> getDicts(String pname) {
        return dictCache.getDictsByPname(pname);
    }

    @Override
    public String getCfg(String cfgName) {
        String val = get(CacheKey.CFG + cfgName);
        if (StringUtil.isNotEmpty(val)) {
            return val;
        }
        val = (String) configCache.get(cfgName);
        set(CacheKey.CFG + cfgName, val);
        return val;
    }
    @Override
    public Role getRole(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    @Override
    public Dept getDept(Long id) {
        Optional<Dept> optional = deptRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    @Override
    public Menu getMenu(Long id) {
        Optional<Menu> optiona = menuRepository.findById(id);
        if (optiona.isPresent()) {
            return optiona.get();
        }
        return null;
    }
    @Override
    public Notice getNotice(Long id) {
        Optional<Notice> optional = sysNoticeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

}
