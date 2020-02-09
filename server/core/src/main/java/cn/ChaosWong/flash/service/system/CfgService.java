package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.entity.system.Cfg;
import cn.ChaosWong.flash.cache.ConfigCache;
import cn.ChaosWong.flash.dao.system.CfgRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CfgService  extends BaseService<Cfg,Long,CfgRepository> {
    @Autowired
    private ConfigCache configCache;

    public Cfg saveOrUpdate(Cfg cfg) {
        if(cfg.getId()==null){
            insert(cfg);
        }else{
            update(cfg);
        }
        configCache.cache();
        return cfg;
    }
    @Override
    public void delete(Long id) {
        super.delete(id);
        configCache.cache();
    }

}
