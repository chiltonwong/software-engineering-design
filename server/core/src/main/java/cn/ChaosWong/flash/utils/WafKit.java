
package cn.ChaosWong.flash.utils;

import java.util.regex.Pattern;


public class WafKit {


	public static String stripXSS(String value) {
		String rlt = null;

		if (null != value) {





			rlt = value.replaceAll("", "");


			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
			rlt = scriptPattern.matcher(rlt).replaceAll("");



			scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
			rlt = scriptPattern.matcher(rlt).replaceAll("");


			scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL);
			rlt = scriptPattern.matcher(rlt).replaceAll("");
		}
		
		return rlt;
	}


	public static String stripSqlInjection(String value) {
		return (null == value) ? null : value.replaceAll("('.+--)|(--)|(%7C)", ""); //value.replaceAll("('.+--)|(--)|(\\|)|(%7C)", "");
	}


	public static String stripSqlXSS(String value) {
		return stripXSS(stripSqlInjection(value));
	}

}
