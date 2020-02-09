package cn.ChaosWong.flash.utils.factory;


import cn.ChaosWong.flash.utils.StringUtil;
import cn.ChaosWong.flash.utils.ToolUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MutiStrFactory {


    public static final String ITEM_SPLIT = ";";


    public static final String ATTR_SPLIT = ":";


    public static final String MUTI_STR_ID = "ID";


    public static final String MUTI_STR_KEY = "KEY";


    public static final String MUTI_STR_VALUE = "VALUE";


    public static List<Map<String,String>> parseKeyValue(String mutiString){
        if(StringUtil.isEmpty(mutiString)){
            return new ArrayList<>();
        }else{
            ArrayList<Map<String,String>> results = new ArrayList<>();
            String[] items = StringUtil.split(StringUtil.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(ATTR_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>(100);
                itemMap.put(MUTI_STR_KEY,attrs[0]);
                itemMap.put(MUTI_STR_VALUE,attrs[1]);
                results.add(itemMap);
            }
            return results;
        }
    }
    

    public static List<Map<String,String>> parseIdKeyValue(String mutiString){
        if(StringUtil.isEmpty(mutiString)){
            return new ArrayList<>();
        }else{
            ArrayList<Map<String,String>> results = new ArrayList<>();
            String[] items = StringUtil.split(StringUtil.removeSuffix(mutiString, ITEM_SPLIT), ITEM_SPLIT);
            for (String item : items) {
                String[] attrs = item.split(ATTR_SPLIT);
                HashMap<String, String> itemMap = new HashMap<>(100);
                itemMap.put(MUTI_STR_ID,attrs[0]);
                itemMap.put(MUTI_STR_KEY,attrs[1]);
                itemMap.put(MUTI_STR_VALUE,attrs[2]);
                results.add(itemMap);
            }
            return results;
        }
    }
}
