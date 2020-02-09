package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.entity.system.Notice;
import cn.ChaosWong.flash.dao.system.NoticeRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeService extends BaseService<Notice,Long, NoticeRepository> {
    @Autowired
    private NoticeRepository noticeRepository;
    public List<Notice> findByTitleLike(String title) {
        return noticeRepository.findByTitleLike("%"+title+"%");
    }
}
