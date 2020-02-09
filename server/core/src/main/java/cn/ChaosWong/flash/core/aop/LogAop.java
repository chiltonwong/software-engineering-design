package cn.ChaosWong.flash.core.aop;

import cn.ChaosWong.flash.bean.core.BussinessLog;
import cn.ChaosWong.flash.bean.dictmap.base.AbstractDictMap;
import cn.ChaosWong.flash.core.log.LogManager;
import cn.ChaosWong.flash.core.log.LogTaskFactory;
import cn.ChaosWong.flash.security.JwtUtil;
import cn.ChaosWong.flash.service.system.LogObjectHolder;
import cn.ChaosWong.flash.utils.BeanUtil;
import cn.ChaosWong.flash.utils.HttpUtil;
import cn.ChaosWong.flash.utils.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;


@Aspect
@Component
public class LogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "@annotation(cn.ChaosWong.flash.bean.core.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {


        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {


        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();


        Long idUser = null;
        HttpServletRequest request = HttpUtil.getRequest();
        String token = request.getHeader("Authorization");
        if(StringUtil.isNotEmpty(token)) {
            idUser = JwtUtil.getUserId(token);
        }
        if(idUser==null) {
            return ;
        }


        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();


        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();
        Class dictClass = annotation.dict();

        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(" & ");
        }


        String msg="";
        if (bussinessName.indexOf("修改") != -1 || bussinessName.indexOf("编辑") != -1) {
            Object obj1 = LogObjectHolder.me().get();
            Map<String, String> obj2 = HttpUtil.getRequestParameters();
            try {
                msg = BeanUtil.contrastObj(dictClass, key, obj1, obj2);
            }catch (Exception e){

            }
        } else {
            Map<String, String> parameters = HttpUtil.getRequestParameters();
            AbstractDictMap dictMap = (AbstractDictMap) dictClass.newInstance();
            msg = BeanUtil.parseMutiKey(dictMap,key,parameters);
        }

        LogManager.me().executeLog(LogTaskFactory.bussinessLog(idUser, bussinessName, className, methodName, msg));
    }
}