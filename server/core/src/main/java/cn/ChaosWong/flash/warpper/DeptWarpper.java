package cn.ChaosWong.flash.warpper;

import cn.ChaosWong.flash.service.system.impl.ConstantFactory;

import java.util.Map;


public class DeptWarpper extends BaseControllerWarpper {

    public DeptWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Long pid = (Long) map.get("pid");

        if (pid ==null ||pid.intValue() == 0) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }

}
