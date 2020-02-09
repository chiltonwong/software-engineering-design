package cn.ChaosWong.flash.cache;

import cn.ChaosWong.flash.bean.entity.system.Dict;

import java.util.List;


public interface DictCache  extends Cache{

    List<Dict> getDictsByPname(String dictName);
    String getDict(Long dictId);
}
