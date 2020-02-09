package cn.ChaosWong.flash.warpper;

import cn.ChaosWong.flash.bean.entity.system.Dict;
import cn.ChaosWong.flash.service.system.impl.ConstantFactory;
import cn.ChaosWong.flash.utils.ToolUtil;

import java.util.List;
import java.util.Map;


public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        Long id = (Long) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if(dicts != null){
            for (Dict dict : dicts) {
                detail.append(dict.getNum() + ":" +dict.getName() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }

}
