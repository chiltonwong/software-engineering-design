package cn.ChaosWong.flash.service.task.job;

import cn.ChaosWong.flash.bean.entity.system.Cfg;
import cn.ChaosWong.flash.service.system.CfgService;
import cn.ChaosWong.flash.service.task.JobExecuter;
import cn.ChaosWong.flash.utils.DateUtil;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class HelloJob extends JobExecuter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CfgService cfgService;
    @Override
    public void execute(Map<String, Object> dataMap) throws Exception {
        Cfg cfg = cfgService.get(1L);
        cfg.setCfgDesc("update by "+ DateUtil.getTime());
        cfgService.update(cfg);
        logger.info("hello :"+ Json.toJson(dataMap));
    }
}
