package cn.ChaosWong.flash.api.controller.cms;

import cn.ChaosWong.flash.api.controller.BaseController;
import cn.ChaosWong.flash.bean.constant.factory.PageFactory;
import cn.ChaosWong.flash.bean.entity.cms.Order;
import cn.ChaosWong.flash.bean.enumeration.Permission;
import cn.ChaosWong.flash.bean.vo.front.Rets;
import cn.ChaosWong.flash.service.cms.OrderService;
import cn.ChaosWong.flash.utils.DateUtil;
import cn.ChaosWong.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.ORDER})
    public Object list(@RequestParam(required = false) String userID,
                       @RequestParam(required = false) String mobile,
                       @RequestParam(required = false) String startDate,
                       @RequestParam(required = false) String endDate,
                       @RequestParam(required = false) Integer status

    ) {
        Page<Order> page = new PageFactory<Order>().defaultPage();
        page.addFilter("createTime", cn.ChaosWong.flash.bean.vo.query.SearchFilter.Operator.GTE, DateUtil.parse(startDate,"yyyyMMddHHmmss"));
        page.addFilter("createTime", cn.ChaosWong.flash.bean.vo.query.SearchFilter.Operator.LTE, DateUtil.parse(endDate,"yyyyMMddHHmmss"));
        page.addFilter("userID", cn.ChaosWong.flash.bean.vo.query.SearchFilter.Operator.EQ,userID);
        page.addFilter("mobile", cn.ChaosWong.flash.bean.vo.query.SearchFilter.Operator.EQ,mobile);
        page.addFilter("status", cn.ChaosWong.flash.bean.vo.query.SearchFilter.Operator.EQ,status);

        page = orderService.queryPage(page);
        return Rets.success(page);
    }
}
