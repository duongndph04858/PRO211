package core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String getDateTime(String pattern) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
}
