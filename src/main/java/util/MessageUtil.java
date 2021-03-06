package util;

import data.Manageable;
import data.Roles;
import data.User;

public class MessageUtil {

	public static String getDescription(Manageable<?> manageable) {
		String message = "Create message";
		try {
			String type = nvl(manageable.getObj().getType(), "");
			User user = manageable.getUserDo();
			if (!type.isEmpty() && user != null) {
				Roles r = user.getPosition();

				message = nvl(r.getRoles(), "") + " " + nvl(user.getFullname(), "") + "(" + nvl(user.getUsername(), "")
						+ ") " + nvl(manageable.getCommand(), "") + " " + type + ": "
						+ nvl(manageable.getMessage(), "") + " " + nvl(manageable.getStatus(), "") + " "
						+ nvl(manageable.getCause(), "");
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
	}

	public static String getNoticeMsg(Manageable<?> manageable) {
		String notice = "Create Notice";
		try {
			String type = nvl(manageable.getObj().getType(), "");
			notice = "Bạn vừa " + nvl(manageable.getCommand(), "") + " " + type + ": "
					+ nvl(manageable.getMessage(), "") + " " + nvl(manageable.getStatus(), "") + " "
					+ nvl(manageable.getCause(), "");
		} catch (Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
		return notice;
	}

	public static String nvl(String old, String ifNull) {
		if (old != null) {
			return old;
		} else {
			return ifNull;
		}
	}
}
