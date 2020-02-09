package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.bean.entity.system.User;
import cn.ChaosWong.flash.cache.impl.EhcacheDao;
import cn.ChaosWong.flash.dao.system.UserRepository;
import cn.ChaosWong.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService  extends BaseService<User,Long,UserRepository> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EhcacheDao ehcacheDao;

    public User findByAccount(String account) {



        User user =  ehcacheDao.hget(EhcacheDao.SESSION,account,User.class);
        if(user!=null){
            return user;
        }
        user = userRepository.findByAccount(account);
        ehcacheDao.hset(EhcacheDao.SESSION,account,user);
        return user;
    }

}
