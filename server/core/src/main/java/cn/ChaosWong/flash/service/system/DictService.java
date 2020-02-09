package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.entity.system.Dict;
import cn.ChaosWong.flash.cache.DictCache;
import cn.ChaosWong.flash.dao.system.DictRepository;
import cn.ChaosWong.flash.service.BaseService;
import cn.ChaosWong.flash.utils.factory.MutiStrFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class DictService extends BaseService<Dict,Long,DictRepository> {
    private Logger logger = LoggerFactory.getLogger(DictService.class);
    @Resource
    DictRepository dictRepository;
    @Autowired
    private DictCache dictCache;

    public void addDict(String dictName, String dictValues) {

        List<Dict> dicts = dictRepository.findByNameAndPid(dictName,0L);
        if(dicts != null && dicts.size() > 0){
            return ;
        }


        List<Map<String, String>> items = MutiStrFactory.parseKeyValue(dictValues);


        Dict dict = new Dict();
        dict.setName(dictName);
        dict.setNum("0");
        dict.setPid(0L);
        this.dictRepository.save(dict);


        for (Map<String, String> item : items) {
            String num = item.get(MutiStrFactory.MUTI_STR_KEY);
            String name = item.get(MutiStrFactory.MUTI_STR_VALUE);
            Dict itemDict = new Dict();
            itemDict.setPid(dict.getId());
            itemDict.setName(name);
            try {
                itemDict.setNum(num);
            }catch (NumberFormatException e){
                logger.error(e.getMessage(),e);
            }
            this.dictRepository.save(itemDict);
        }
        dictCache.cache();
    }

    public void editDict(Long dictId, String dictName, String dicts) {

        this.delteDict(dictId);


        this.addDict(dictName,dicts);

        dictCache.cache();
    }

    public void delteDict(Long dictId) {

        List<Dict> subList = dictRepository.findByPid(dictId);
        dictRepository.deleteAll(subList);

        dictRepository.deleteById(dictId);

        dictCache.cache();
    }
    @Override
    public Dict get(Long id) {
        Optional<Dict> optional = dictRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Dict> findByNameLike(String name) {
        return dictRepository.findByNameLike(name);
    }

    public List<Dict> findByPid(Long pid) {
        return dictRepository.findByPid(pid);
    }
}
