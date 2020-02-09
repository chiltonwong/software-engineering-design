package cn.ChaosWong.flash.utils;

import java.util.HashMap;
import java.util.Map;


public enum BasicType {
	BYTE, SHORT, INT, INTEGER, LONG, DOUBLE, FLOAT, BOOLEAN, CHAR, CHARACTER, STRING;
	

	public static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP = new HashMap<Class<?>, Class<?>>(8);

	public static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP = new HashMap<Class<?>, Class<?>>(8);
	
	static {
		WRAPPER_PRIMITIVE_MAP.put(Boolean.class, boolean.class);
		WRAPPER_PRIMITIVE_MAP.put(Byte.class, byte.class);
		WRAPPER_PRIMITIVE_MAP.put(Character.class, char.class);
		WRAPPER_PRIMITIVE_MAP.put(Double.class, double.class);
		WRAPPER_PRIMITIVE_MAP.put(Float.class, float.class);
		WRAPPER_PRIMITIVE_MAP.put(Integer.class, int.class);
		WRAPPER_PRIMITIVE_MAP.put(Long.class, long.class);
		WRAPPER_PRIMITIVE_MAP.put(Short.class, short.class);

		for (Map.Entry<Class<?>, Class<?>> entry : WRAPPER_PRIMITIVE_MAP.entrySet()) {
			PRIMITIVE_WRAPPER_MAP.put(entry.getValue(), entry.getKey());
		}
	}
}
