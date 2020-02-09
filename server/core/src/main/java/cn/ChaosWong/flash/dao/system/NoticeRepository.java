package cn.ChaosWong.flash.dao.system;


import cn.ChaosWong.flash.bean.entity.system.Notice;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.List;


public interface NoticeRepository extends BaseRepository<Notice,Long> {
    List<Notice> findByTitleLike(String name);
}
