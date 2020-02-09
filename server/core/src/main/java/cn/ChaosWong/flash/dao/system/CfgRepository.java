
package cn.ChaosWong.flash.dao.system;

import cn.ChaosWong.flash.bean.entity.system.Cfg;
import cn.ChaosWong.flash.dao.BaseRepository;

public interface CfgRepository extends BaseRepository<Cfg,Long> {

    Cfg findByCfgName(String cfgName);
}
