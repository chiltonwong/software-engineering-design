package cn.ChaosWong.flash.dao.message;


import cn.ChaosWong.flash.bean.entity.message.MessageTemplate;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.List;


public interface MessagetemplateRepository extends BaseRepository<MessageTemplate,Long> {
    MessageTemplate findByCode(String code);

    List<MessageTemplate> findByIdMessageSender(Long idMessageSender);
}

