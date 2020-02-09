package cn.ChaosWong.flash.cache;

import java.io.Serializable;


public interface CacheDao {



    void hset(Serializable key, Serializable k, Object val);


    Serializable hget(Serializable key, Serializable k);


    <T>T hget(Serializable key, Serializable k,Class<T> klass);


    void set(Serializable key, Object val);




      <T>T get(Serializable key,Class<T> klass);
      String get(Serializable key);


      void del(Serializable key);
      void hdel(Serializable key, Serializable k);
}
