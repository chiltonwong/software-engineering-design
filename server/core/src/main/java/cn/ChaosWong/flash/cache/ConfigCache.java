package cn.ChaosWong.flash.cache;


public interface ConfigCache extends Cache {



	String get(String key, boolean local);


	String get(String key, String def);


	void del(String key, String val);
}
