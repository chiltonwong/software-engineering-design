package cn.ChaosWong.flash.api.controller.cms;

import cn.ChaosWong.flash.api.controller.BaseController;
import cn.ChaosWong.flash.bean.constant.factory.PageFactory;
import cn.ChaosWong.flash.bean.core.BussinessLog;
import cn.ChaosWong.flash.bean.dictmap.CommonDict;
import cn.ChaosWong.flash.bean.entity.cms.Dish;
import cn.ChaosWong.flash.bean.enumeration.Permission;
import cn.ChaosWong.flash.bean.vo.front.Rets;
import cn.ChaosWong.flash.bean.vo.query.SearchFilter;
import cn.ChaosWong.flash.service.cms.DishService;
import cn.ChaosWong.flash.utils.DateUtil;
import cn.ChaosWong.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dish")
public class DishMgrController extends BaseController {

    @Autowired
    private DishService dishService;
    @RequestMapping(method = RequestMethod.POST)
    @BussinessLog(value = "编辑菜品",key="name",dict = CommonDict.class)
    @RequiresPermissions(value = {Permission.DISH_EDIT})
    public Object save(){
        Dish dish = getFromJson(Dish.class);
        if(dish.getId()!=null){
            Dish old = dishService.get(dish.getId());
            old.setPrice(dish.getPrice());
            old.setInventory(dish.getInventory());
            old.setContent(dish.getContent());
            old.setIdChannel(dish.getIdChannel());
            old.setImg(dish.getImg());
            old.setTitle(dish.getTitle());
           dishService.update(old);
        }else {
            dishService.insert(dish);
        }
        return Rets.success();
    }
    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "删除菜品",key="id",dict = CommonDict.class)
    @RequiresPermissions(value = {Permission.DISH_DEL})
    public Object remove(Long id){
        dishService.delete(id);
        return Rets.success();
    }
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.DISH})
    public Object get(@Param("id") Long id) {
        Dish dish = dishService.get(id);
        return Rets.success(dish);
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.DISH})
    public Object list(@RequestParam(required = false) String title,
                       @RequestParam(required = false) String startDate,
                       @RequestParam(required = false) String endDate
                       ) {
        Page<Dish> page = new PageFactory<Dish>().defaultPage();
        page.addFilter("title", SearchFilter.Operator.LIKE,title);
        page.addFilter("createTime", SearchFilter.Operator.GTE, DateUtil.parse(startDate,"yyyyMMddHHmmss"));
        page.addFilter("createTime", SearchFilter.Operator.LTE, DateUtil.parse(endDate,"yyyyMMddHHmmss"));
        page = dishService.queryPage(page);
        return Rets.success(page);
    }
}
