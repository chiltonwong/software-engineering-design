package cn.ChaosWong.flash.utils;


import cn.ChaosWong.flash.utils.cache.exception.ToolBoxException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CollectionKit {

	private CollectionKit() {

	}



	public static <T, K> HashMap<T, K> newHashMap() {
		return new HashMap<T, K>(100);
	}


	public static <T, K> HashMap<T, K> newHashMap(int size) {
		return new HashMap<T, K>((int)(size / 0.75));
	}


	public static <T> T[] append(T[] buffer, T newElement) {
		T[] t = resize(buffer, buffer.length + 1, newElement.getClass());
		t[buffer.length] = newElement;
		return t;
	}


	public static <T> T[] resize(T[] buffer, int newSize, Class<?> componentType) {
		T[] newArray = newArray(componentType, newSize);
		System.arraycopy(buffer, 0, newArray, 0, buffer.length >= newSize ? newSize : buffer.length);
		return newArray;
	}


	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<?> componentType, int newSize) {
		return (T[]) Array.newInstance(componentType, newSize);
	}




	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}


	public static <T> boolean isNotEmpty(T[] array) {
		return false == isEmpty(array);
	}


	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}


	public static boolean isNotEmpty(Collection<?> collection) {
		return false == isEmpty(collection);
	}


	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}


	public static <T> boolean isNotEmpty(Map<?, ?> map) {
		return false == isEmpty(map);
	}



	public static boolean isArray(Object obj){
		return obj.getClass().isArray();
	}


	public static String toString(Object obj) {
		if (null == obj) {
			return null;
		}
		if (isArray(obj)) {
			try {
				return Arrays.deepToString((Object[]) obj);
			} catch (Exception e) {
				final String className = obj.getClass().getComponentType().getName();
				switch (className) {
					case "long":
						return Arrays.toString((long[]) obj);
					case "int":
						return Arrays.toString((int[]) obj);
					case "short":
						return Arrays.toString((short[]) obj);
					case "char":
						return Arrays.toString((char[]) obj);
					case "byte":
						return Arrays.toString((byte[]) obj);
					case "boolean":
						return Arrays.toString((boolean[]) obj);
					case "float":
						return Arrays.toString((float[]) obj);
					case "double":
						return Arrays.toString((double[]) obj);
					default:
						throw new ToolBoxException(e);
				}
			}
		}
		return obj.toString();
	}
}
