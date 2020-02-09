package cn.ChaosWong.flash.cache;


public interface Cache {

	void cache();



	Object get(String key);



	void set(String key, Object val);


}
