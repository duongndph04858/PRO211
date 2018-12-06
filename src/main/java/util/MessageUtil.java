package util;

import data.Manageable;
import data.Roles;
import data.User;

public class MessageUtil {

	public static String getDescription(Manageable<?> manageable) {
		String message = "Create message";
		try {
			String type = manageable.getObj().getType();
			User user = manageable.getUserDo();
			if (!type.isEmpty() && user != null) {
				Roles r = user.getPosition();
				message = r.getRoles() + " " + user.getFullname() + "(" + user.getUsername() + ") "
						+ manageable.getCommand() + " " + type + ": " + manageable.getMessage() + " "
						+ manageable.getStatus();
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
			String type = manageable.getObj().getType();
			notice = "Bạn vừa" + manageable.getCommand() + " " + type + " " + manageable.getMessage() + " "
					+ manageable.getStatus();
		} catch (Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
		return notice;
	}
}
