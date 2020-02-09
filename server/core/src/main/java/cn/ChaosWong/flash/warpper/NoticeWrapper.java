package cn.ChaosWong.flash.warpper;

import cn.ChaosWong.flash.service.system.impl.ConstantFactory;

import java.util.Map;


public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Long creater = (Long) map.get("createBy");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
