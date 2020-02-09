package cn.ChaosWong.flash.service.system;


import cn.ChaosWong.flash.bean.entity.system.LoginLog;
import cn.ChaosWong.flash.dao.system.LoginLogRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.stereotype.Service;


@Service
public class LoginLogService extends BaseService<LoginLog,Long,LoginLogRepository> {

}
