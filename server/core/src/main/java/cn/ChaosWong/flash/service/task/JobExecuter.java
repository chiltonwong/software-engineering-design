package cn.ChaosWong.flash.service.task;

import cn.ChaosWong.flash.bean.entity.system.Task;
import cn.ChaosWong.flash.bean.entity.system.TaskLog;
import cn.ChaosWong.flash.bean.vo.QuartzJob;
import cn.ChaosWong.flash.dao.system.TaskLogRepository;
import cn.ChaosWong.flash.dao.system.TaskRepository;
import cn.ChaosWong.flash.utils.StringUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public abstract class JobExecuter {

    protected static final Logger log = LoggerFactory.getLogger(JobExecuter.class);

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskLogRepository taskLogRepository;
    @Autowired
    private TaskRepository taskRepository;

    private QuartzJob job;

    public void setJob(QuartzJob job) {
        this.job = job;
    }

    public void execute() {
        Map dataMap = job.getDataMap();
        String taskId = job.getJobName();
        Task task = taskService.get(Long.valueOf(taskId));
        final String taskName = task.getName();
        log.info(">>>>>>>>>>>>>>>>>开始执行定时任务[" + taskName + "]...<<<<<<<<<<<<<<<<<<<");

        String exeResult = "执行成功";
        final TaskLog taskLog = new TaskLog();
        taskLog.setName(taskName);
        final Date exeAt = new Date();
        taskLog.setExecAt(exeAt);
        taskLog.setIdTask(task.getId());

        taskLog.setExecSuccess(TaskLog.EXE_SUCCESS_RESULT);
        try {
            execute(dataMap);
        } catch (Exception e) {
            log.error("exeucte " + getClass().getName() + " error : ", e);
            exeResult = "执行失败\n";
            exeResult += ExceptionUtils.getStackTrace(e);
            taskLog.setExecSuccess(TaskLog.EXE_FAILURE_RESULT);
            taskLog.setJobException(e.getClass().getName());
        }
        task.setExecResult(exeResult);
        task.setExecAt(exeAt);
        taskLogRepository.save(taskLog);
        taskRepository.save(task);
        log.info(">>>>>>>>>>>>>>>>>执行定时任务[" + taskName + "]结束<<<<<<<<<<<<<<<<<<<");
    }


    public abstract void execute(Map<String, Object> dataMap) throws Exception;

    public String getEmail() {
        return getEmail("snowalert@xuezhongdai.cn");
    }

    public String getEmail(String defaultEmail) {
        Map<String, Object> dataMap = job.getDataMap();
        String toEmail = null;
        if (dataMap != null && dataMap.containsKey("email")) {
            toEmail = StringUtil.sNull(dataMap.get("email"));
        }
        if (StringUtil.isEmpty(toEmail)) {
            toEmail = defaultEmail;
        }
        return toEmail;
    }

}
