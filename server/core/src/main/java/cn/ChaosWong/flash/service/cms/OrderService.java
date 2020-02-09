package cn.ChaosWong.flash.service.cms;

import cn.ChaosWong.flash.bean.entity.cms.Order;
import cn.ChaosWong.flash.dao.cms.OrderRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order,Long,OrderRepository> {
}
