package cn.ChaosWong.flash.bean.dictmap;

import cn.ChaosWong.flash.bean.dictmap.base.AbstractDictMap;


public class CfgDict extends AbstractDictMap {

    @Override
    public void init() {
        put("id","参数id");
        put("cfgName","参数名称");
        put("cfgDesc","备注");
    }

    @Override
    protected void initBeWrapped() {

    }
}
