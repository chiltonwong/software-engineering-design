package cn.ChaosWong.flash.utils;


import cn.ChaosWong.flash.utils.cache.exception.ToolBoxException;

import java.math.BigDecimal;



public class Convert {
	

	private Convert() {

	}




	public static String toStr(Object value, String defaultValue) {
		if (null == value) {
			return defaultValue;
		}
		if (value instanceof String) {
			return (String) value;
		} else if (CollectionKit.isArray(value)) {
			return CollectionKit.toString(value);
		}
		return value.toString();
	}



	public static Integer toInt(Object value, Integer defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		if (value instanceof Integer) {
			return (Integer) value;
		}
		if (value instanceof Number) {
			return ((Number) value).intValue();
		}
		final String valueStr = toStr(value, null);
		if (StringUtil.isEmpty(valueStr)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(valueStr.trim());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	

	public static Integer[] toIntArray(String str) {
		return toIntArray(",", str);
	}
	

	public static Integer[] toIntArray(String split, String str) {
		if (StringUtil.isEmpty(str)) {
			return new Integer[] {};
		}
		String[] arr = str.split(split);
		final Integer[] ints = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			final Integer v = toInt(arr[i], 0);
			ints[i] = v;
		}
		return ints;
	}
	public static Long[] toLongArray(String split, String str) {
		if (StringUtil.isEmpty(str)) {
			return new Long[] {};
		}
		String[] arr = str.split(split);
		final Long[] ints = new Long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			final Long v = StringUtil.isNotEmpty(arr[i])?Long.valueOf(arr[i]):0L;
			ints[i] = v;
		}
		return ints;
	}

	

	public static String[] toStrArray(String split, String str) {
		return str.split(split);
	}


	public static Long toLong(Object value, Long defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		if (value instanceof Long) {
			return (Long) value;
		}
		if (value instanceof Number) {
			return ((Number) value).longValue();
		}
		final String valueStr = toStr(value, null);
		if (StringUtil.isEmpty(valueStr)) {
			return defaultValue;
		}
		try {

			return new BigDecimal(valueStr.trim()).longValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}



	public static Long[] toLongArray(boolean isIgnoreConvertError, Object... values) {
		if (CollectionKit.isEmpty(values)) {
			return new Long[] {};
		}
		final Long[] longs = new Long[values.length];
		for (int i = 0; i < values.length; i++) {
			final Long v = toLong(values[i], null);
			if (null == v && isIgnoreConvertError == false) {
				throw new ToolBoxException(StringUtil.format("Convert [{}] to Long error!", values[i]));
			}
			longs[i] = v;
		}
		return longs;
	}


	
}
