package cn.ChaosWong.flash.core.listener;

import cn.ChaosWong.flash.cache.ConfigCache;
import cn.ChaosWong.flash.cache.DictCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CacheListener implements CommandLineRunner {

    @Autowired
    private ConfigCache configCache;
    @Autowired
    private DictCache dictCache;
    private Logger logger = LoggerFactory.getLogger(CacheListener.class);

    public void loadCache() {
        configCache.cache();
        dictCache.cache();
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(".....................load cache........................");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadCache();
            }
        });
        thread.start();
    }
}
