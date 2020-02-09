package cn.ChaosWong.flash.bean.dictmap;

import cn.ChaosWong.flash.bean.dictmap.base.AbstractDictMap;


public class DeleteDict extends AbstractDictMap {

    @Override
    public void init() {
        put("roleId","角色名称");
        put("deptId", "部门名称");
        put("menuId", "菜单名称");
        put("dictId", "字典名称");
        put("noticeId", "标题");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("roleId","getCacheObject");
        putFieldWrapperMethodName("deptId","getCacheObject");
        putFieldWrapperMethodName("menuId","getCacheObject");
        putFieldWrapperMethodName("dictId","getCacheObject");
        putFieldWrapperMethodName("noticeId","getCacheObject");

    }
}
