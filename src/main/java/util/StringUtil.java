package util;

public class StringUtil {

	public static final String getCode(String input) throws Exception {
		try {
			String result = input.replaceAll("\\s+", "");
			return result.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
