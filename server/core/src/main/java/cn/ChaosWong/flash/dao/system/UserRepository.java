package cn.ChaosWong.flash.dao.system;


import cn.ChaosWong.flash.bean.entity.system.User;
import cn.ChaosWong.flash.dao.BaseRepository;


public interface UserRepository extends BaseRepository<User,Long> {
    User findByAccount(String account);

    User findByAccountAndStatusNot(String account, Integer status);
}
