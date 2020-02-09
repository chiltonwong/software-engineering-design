package cn.ChaosWong.flash.bean.dictmap;

import cn.ChaosWong.flash.bean.dictmap.base.AbstractDictMap;


public class LogDict extends AbstractDictMap {

    @Override
    public void init() {
        put("tips","备注");
    }

    @Override
    protected void initBeWrapped() {

    }
}
