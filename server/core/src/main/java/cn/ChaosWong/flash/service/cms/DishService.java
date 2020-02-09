package cn.ChaosWong.flash.service.cms;

import cn.ChaosWong.flash.bean.entity.cms.Dish;
import cn.ChaosWong.flash.bean.enumeration.cms.ChannelEnum;
import cn.ChaosWong.flash.bean.vo.query.SearchFilter;
import cn.ChaosWong.flash.dao.cms.DishRepository;
import cn.ChaosWong.flash.service.BaseService;
import cn.ChaosWong.flash.utils.factory.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService extends BaseService<Dish, Long, DishRepository> {
    @Autowired
    private DishRepository dishRepository;


    public List<Dish> queryIndexNews() {
        Page<Dish> page = query(1, 5, ChannelEnum.NEWS.getId());
        return page.getRecords();
    }

    public Page<Dish> query(int currentPage, int size, Long idChannel) {
        Page page = new Page(currentPage, size, "id");
        page.addFilter(SearchFilter.build("idChannel", SearchFilter.Operator.EQ, idChannel));
        return queryPage(page);

    }
}
