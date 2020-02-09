package cn.ChaosWong.flash.service.task;


import cn.ChaosWong.flash.bean.entity.system.TaskLog;
import cn.ChaosWong.flash.dao.system.TaskLogRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.stereotype.Service;


@Service
public class TaskLogService extends BaseService<TaskLog,Long,TaskLogRepository> {
}
