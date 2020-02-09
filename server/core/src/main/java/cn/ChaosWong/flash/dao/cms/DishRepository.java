
package cn.ChaosWong.flash.dao.cms;

import cn.ChaosWong.flash.bean.entity.cms.Dish;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.List;

public interface DishRepository extends BaseRepository<Dish,Long> {

    List<Dish> findAllByIdChannel(Long idChannel);
}
