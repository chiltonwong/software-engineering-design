package cn.ChaosWong.flash.code;

import org.nutz.lang.Strings;


public class Utils {

    public static String lowerCamel(String src){
        src = src.toLowerCase();
        StringBuilder result = new StringBuilder();
        for(String sitem:src.split("_")){
            if(result.toString().length()==0){
                result.append(sitem);
            }else{
                result.append(Strings.upperFirst(sitem));
            }
        }
        return result.toString();
    }


    public static String upperCamel(String src){
        if(!src.contains("_")){
            return src;
        }
        src = src.toLowerCase();
        StringBuilder result = new StringBuilder();
        for(String sitem:src.split("_")){
            if(result.toString().length()==0){
                result.append(Strings.upperFirst(sitem));
            }else{
                result.append(Strings.upperFirst(sitem));
            }
        }
        return result.toString();
    }
    public static  void main(String[] args){
        System.out.println(upperCamel("AAAA_BBBB"));
    }
}
