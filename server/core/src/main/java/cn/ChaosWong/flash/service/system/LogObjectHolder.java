package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.vo.SpringContextHolder;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;


@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable{

    private Object object = null;

    public void set(Object obj) {
        try {

            Object cloneObj = BeanUtils.cloneBean(obj);
            this.object = cloneObj;
        }   catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object get() {
        return object;
    }

    public static LogObjectHolder me(){
        LogObjectHolder bean = SpringContextHolder.getBean(LogObjectHolder.class);
        return bean;
    }
}
