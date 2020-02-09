package cn.ChaosWong.flash.bean.vo.query;

import cn.ChaosWong.flash.utils.Maps;
import cn.ChaosWong.flash.utils.StringUtil;

import java.util.Map;


public class SearchFilter {
    public enum Operator {
        EQ, LIKE, GT, LT, GTE, LTE,IN,ISNULL,ISNOTNULL
    }

    public String fieldName;
    public Object value;
    public Operator operator;
    public  static SearchFilter build(String fieldName, Operator operator, Object value){
        return  new SearchFilter(fieldName,operator,value);
    }
    public  static SearchFilter build(String fieldName, Operator operator){
        return  new SearchFilter(fieldName,operator);
    }
    public SearchFilter(String fieldName, Operator operator) {
        this.fieldName = fieldName;
        this.operator = operator;
    }
    public SearchFilter(String fieldName, Operator operator, Object value) {
        if(!StringUtil.isNullOrEmpty(value)) {
            this.fieldName = fieldName;
            this.value = value;
            this.operator = operator;
        }
    }


    public static Map<String, SearchFilter> parse(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = Maps.newHashMap();

        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {

            String key = entry.getKey();
            Object value = entry.getValue();



            String[] names = StringUtil.split(key, "_");
            if (names.length != 2) {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            String filedName = names[1];
            Operator operator = Operator.valueOf(names[0]);


            SearchFilter filter = new SearchFilter(filedName, operator, value);
            filters.put(key, filter);
        }

        return filters;
    }
}
