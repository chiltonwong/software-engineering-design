package cn.ChaosWong.flash.dao.message;


import cn.ChaosWong.flash.bean.entity.message.Message;
import cn.ChaosWong.flash.dao.BaseRepository;

import java.util.ArrayList;


public interface MessageRepository extends BaseRepository<Message,Long> {
    void deleteAllByIdIn(ArrayList<String> list);
}

