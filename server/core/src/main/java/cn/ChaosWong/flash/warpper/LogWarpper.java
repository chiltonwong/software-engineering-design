package cn.ChaosWong.flash.warpper;

import cn.ChaosWong.flash.service.system.impl.ConstantFactory;
import cn.ChaosWong.flash.utils.Constants;
import cn.ChaosWong.flash.utils.DateUtil;
import cn.ChaosWong.flash.utils.StringUtil;

import java.util.Date;
import java.util.Map;


public class LogWarpper extends BaseControllerWarpper {

    public LogWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        String message = (String) map.get("message");

        Long userid = Long.valueOf(map.get("userid").toString());
        map.put("userName", ConstantFactory.me().getUserNameById(userid));


        if (StringUtil.isNotEmpty(message) && message.length() >= 100) {
            String subMessage = message.substring(0, 100) + "...";
            map.put("message", subMessage);
        }
        map.put("createtime",DateUtil.format((Date) map.get("createTime"),"yyyy-MM-dd hh:MM:ss"));

        if (StringUtil.isNotEmpty(message) && message.indexOf(Constants.SEPARATOR) != -1) {
            String[] msgs = message.split(Constants.SEPARATOR);
            map.put("regularMessage",msgs);
        }else{
            map.put("regularMessage",message);
        }
    }

}
