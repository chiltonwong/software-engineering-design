package cn.ChaosWong.flash.utils;


import java.util.Base64;


public class CryptUtil {

	public static String encodeBASE64(byte[] bytes) {

		String encode = Base64.getEncoder().encodeToString(bytes);
		encode = encode.replaceAll("\n", "");
		return encode;
	}


}
