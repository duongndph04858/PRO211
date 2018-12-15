package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String getDateTime(String pattern) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	public static String getDateTime(Date date,String pattern) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date parse(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}
}
