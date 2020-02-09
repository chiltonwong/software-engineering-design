package cn.ChaosWong.flash.cache;

import cn.ChaosWong.flash.bean.core.ShiroUser;
import cn.ChaosWong.flash.cache.impl.EhcacheDao;
import cn.ChaosWong.flash.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public   class TokenCache {

    @Autowired
    private EhcacheDao ehcacheDao;

    public   void put(String token, Long idUser) {
        ehcacheDao.hset(EhcacheDao.SESSION,token, idUser);
    }

    public   Long get(String token) {
        return ehcacheDao.hget(EhcacheDao.SESSION,token,Long.class);
    }
    public Long getIdUser(){
        return ehcacheDao.hget(EhcacheDao.SESSION, HttpUtil.getToken(),Long.class );
    }

    public   void remove(String token) {
        ehcacheDao.hdel(EhcacheDao.SESSION,token+"user");
    }

    public void setUser(String token, ShiroUser shiroUser){
        ehcacheDao.hset(EhcacheDao.SESSION,token+"user",shiroUser);
    }
    public ShiroUser getUser(String token){
        return ehcacheDao.hget(EhcacheDao.SESSION,token+"user",ShiroUser.class);
    }
}
