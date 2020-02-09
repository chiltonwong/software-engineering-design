package cn.ChaosWong.flash.cache.impl;

import cn.ChaosWong.flash.bean.entity.system.Cfg;
import cn.ChaosWong.flash.cache.CacheDao;
import cn.ChaosWong.flash.cache.ConfigCache;
import cn.ChaosWong.flash.dao.system.CfgRepository;
import cn.ChaosWong.flash.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConfigCacheImpl implements ConfigCache {
    private static  final Logger logger = LoggerFactory.getLogger(ConfigCacheImpl.class);
    @Autowired
    private CfgRepository cfgRepository;
    @Autowired
    private CacheDao cacheDao;

    @Override
    public Object get(String key) {
        return (String) cacheDao.hget(EhcacheDao.CONSTANT,key);
    }

    @Override
    public String get(String key, boolean local) {
        String ret = null;
        if(local) {
             ret = (String) get(key);
        }else{
            ret = cfgRepository.findByCfgName(key).getCfgValue();
            set(key,ret);
        }
        return ret;
    }

    @Override
    public String get(String key, String def) {
        String ret = (String) get(key);
        if(StringUtil.isEmpty(ret)){
            return ret;
        }
        return ret;
    }


    @Override
    public void set(String key, Object val) {
        cacheDao.hset(EhcacheDao.CONSTANT,key,val);
    }

    @Override
    public void del(String key, String val) {
        cacheDao.hdel(EhcacheDao.CONSTANT,val);
    }

    @Override
    public void cache() {
        logger.info("reset config cache");
        List<Cfg> list = cfgRepository.findAll();
        if (list != null && !list.isEmpty()) {
            for (Cfg cfg : list) {
                if (StringUtil.isNotEmpty(cfg.getCfgName()) && StringUtil.isNotEmpty(cfg.getCfgValue())) {
                    set(cfg.getCfgName(),cfg.getCfgValue());
                }
            }
        }
    }
}
