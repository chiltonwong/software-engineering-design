package cn.ChaosWong.flash.bean.core;

import cn.ChaosWong.flash.bean.dictmap.base.AbstractDictMap;
import cn.ChaosWong.flash.bean.dictmap.SystemDict;

import java.lang.annotation.*;


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {


    String value() default "";


    String key() default "id";


    Class<? extends AbstractDictMap> dict() default SystemDict.class;
}
