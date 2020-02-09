package cn.ChaosWong.flash.service.system;


import cn.ChaosWong.flash.bean.entity.system.*;
import cn.ChaosWong.flash.bean.vo.DictVo;

import java.util.List;


public interface IConstantFactory {


    String getUserNameById(Long userId);


    String getUserAccountById(Long userId);


    String getRoleName(String roleIds);


    String getSingleRoleName(Long roleId);


    String getSingleRoleTip(Long roleId);


    String getDeptName(Long deptId);


    String getMenuNames(String menuIds);


    String getMenuName(Long menuId);


    String getMenuNameByCode(String code);


    List<DictVo> findByDictName(String dictName);

    String getDictName(Long dictId);


    String getNoticeTitle(Long dictId);


    String getDictsByName(String name, String val);


    String getSexName(Integer sex);

    String getCardTypeName(String cardType);


    String getIdCardTypeName(String cardType);


    String getRelationName(String relation);

    String getStatusName(Integer status);


    String getMenuStatusName(Integer status);


    List<Dict> findInDict(Long id);


    String getCacheObject(String para);


    List<Long> getSubDeptId(Long deptid);


    List<Integer> getParentDeptIds(Long deptid);



    List<Dict> getDicts(String pname);

    String getCfg(String cfgName);


    Role getRole(Long id) ;
    Dept getDept(Long id);
    Menu getMenu(Long id) ;

    Notice getNotice(Long id);
}
