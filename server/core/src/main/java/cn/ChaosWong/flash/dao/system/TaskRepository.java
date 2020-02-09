
package cn.ChaosWong.flash.dao.system;


import cn.ChaosWong.flash.bean.entity.system.Task;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.List;

public interface TaskRepository extends BaseRepository<Task,Long> {

    long countByNameLike(String name);

    List<Task> findByNameLike(String name);
    List<Task> findAllByDisabled(boolean disable);
}
