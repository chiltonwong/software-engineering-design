
package cn.ChaosWong.flash.utils;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {


	private static final Object LOCK = new Object();

	private static final Map<String, ThreadLocal<SimpleDateFormat>> POOL = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}


	public static String getYear(Date date) {
		return formatDate(date, "yyyy");
	}


	public static String getDay() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}


	public static String getDay(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}


	public static String getDays() {
		return formatDate(new Date(), "yyyyMMdd");
	}


	public static String getDays(Date date) {
		return formatDate(date, "yyyyMMdd");
	}


	public static String getTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}


	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}


	public static String getAllTime() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}


	public static String getTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtil.isNotEmpty(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}


	public static boolean compareDate(String s, String e) {
		if (parseDate(s) == null || parseDate(e) == null) {
			return false;
		}
		return parseDate(s).getTime() >= parseDate(e).getTime();
	}


	public static Date parseDate(String date) {
		return parse(date,"yyyy-MM-dd");
	}


	public static Date parseTime(String date) {
		return parse(date,"yyyy-MM-dd HH:mm:ss");
	}


	public static Date parse(String date, String pattern) {
		if (date != null) {
			if (pattern == null || "".equals(pattern)) {
				return null;
			}
			DateFormat format = getDFormat(pattern);
			try {
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static SimpleDateFormat getDFormat(String pattern) {
		ThreadLocal<SimpleDateFormat> tl = POOL.get(pattern);
		if (tl == null) {
			synchronized (LOCK) {
				tl = POOL.get(pattern);
				if (tl == null) {
					final String p = pattern;
					tl = new ThreadLocal<SimpleDateFormat>() {
						@Override
						protected synchronized SimpleDateFormat initialValue() {
							return new SimpleDateFormat(p);
						}
					};
					POOL.put(p, tl);
				}
			}
		}
		return tl.get();
	}


	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}


	public static Timestamp format(Date date) {
		return new Timestamp(date.getTime());
	}


	public static boolean isValidDate(String s) {
		return parse(s, "yyyy-MM-dd HH:mm:ss") != null;
	}


	public static boolean isValidDate(String s, String pattern) {
        return parse(s, pattern) != null;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
					startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {

			return 0;
		}
	}


	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);


		return day;
	}


	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}


	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}


	public static void main(String[] args) {
		System.out.println(getTime(new Date()));
		System.out.println(getAfterDayWeek("3"));
	}

}
