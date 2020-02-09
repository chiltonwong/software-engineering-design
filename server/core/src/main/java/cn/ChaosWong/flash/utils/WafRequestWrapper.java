
package cn.ChaosWong.flash.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;


public class WafRequestWrapper extends HttpServletRequestWrapper {

	private boolean filterXSS = true;

	private boolean filterSQL = true;


	public WafRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
		super(request);
		this.filterXSS = filterXSS;
		this.filterSQL = filterSQL;
	}


	public WafRequestWrapper(HttpServletRequest request) {
		this(request, true, true);
	}



	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if ( values == null ) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for ( int i = 0 ; i < count ; i++ ) {
			encodedValues[i] = filterParamString(values[i]);
		}

		return encodedValues;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getParameterMap() {
		Map<String, String[]> primary = super.getParameterMap();
		Map<String, String[]> result = new HashMap<String, String[]>(primary.size());
		for ( Map.Entry<String, String[]> entry : primary.entrySet() ) {
			result.put(entry.getKey(), filterEntryString(entry.getValue()));
		}
		return result;

	}
	
	protected String[] filterEntryString(String[] rawValue) {
		for ( int i = 0 ; i < rawValue.length ; i++ ) {
			rawValue[i] = filterParamString(rawValue[i]);
		}
		return rawValue;
	}


	@Override
	public String getParameter(String parameter) {
		return filterParamString(super.getParameter(parameter));
	}



	@Override
	public String getHeader(String name) {
		return filterParamString(super.getHeader(name));
	}



	@Override
	public Cookie[] getCookies() {
		Cookie[] existingCookies = super.getCookies();
		if (existingCookies != null) {
			for (int i = 0 ; i < existingCookies.length ; ++i) {
				Cookie cookie = existingCookies[i];
				cookie.setValue(filterParamString(cookie.getValue()));
			}
		}
		return existingCookies;
	}


	protected String filterParamString(String rawValue) {
		if (null == rawValue) {
			return null;
		}
		String tmpStr = rawValue;
		if (this.filterXSS) {
			tmpStr = WafKit.stripXSS(rawValue);
		}
		if (this.filterSQL) {
			tmpStr = WafKit.stripSqlInjection(tmpStr);
		}
		return tmpStr;
	}
}
