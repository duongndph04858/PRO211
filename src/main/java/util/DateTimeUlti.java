package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUlti {
	public static String getCurrentDatetime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
	}
}
