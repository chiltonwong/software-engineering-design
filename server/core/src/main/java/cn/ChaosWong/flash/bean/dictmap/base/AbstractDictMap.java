package cn.ChaosWong.flash.bean.dictmap.base;

import java.util.HashMap;


public abstract class AbstractDictMap {

    protected HashMap<String, String> dictory = new HashMap<>();
    protected HashMap<String, String> fieldWarpperDictory = new HashMap<>();

    public AbstractDictMap(){
        put("id","主键id");
        init();
        initBeWrapped();
    }


    public abstract void init();


    protected abstract void initBeWrapped();

    public String get(String key) {
        return this.dictory.get(key);
    }

    public void put(String key, String value) {
        this.dictory.put(key, value);
    }

    public String getFieldWarpperMethodName(String key){
        return this.fieldWarpperDictory.get(key);
    }

    public void putFieldWrapperMethodName(String key,String methodName){
        this.fieldWarpperDictory.put(key,methodName);
    }
}
