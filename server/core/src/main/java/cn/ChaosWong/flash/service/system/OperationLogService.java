package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.entity.system.OperationLog;
import cn.ChaosWong.flash.dao.system.OperationLogRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.stereotype.Service;


@Service
public class OperationLogService extends BaseService<OperationLog,Long,OperationLogRepository> {

}
