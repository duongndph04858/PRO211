package util;

import core.entity.Message;
import data.Manageable;
import data.Roles;
import data.User;

public class MessageUtil {

	public static String getDescription(Message msg) {
		String message = "Create message";
		try {
			Manageable obj = msg.getObj();
			String type = obj.getType();
			String command = msg.getCommand();
			User user = msg.getUser();
			if (!type.isEmpty() && user != null) {
				Roles r = user.getPosition();
				message = r.getRoles() + " " + user.getFullname() + "(" + user.getUsername() + ") " + command + " "
						+ type + ": " + msg.getValue();
			}
			return message;
		} catch (

		Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
	}

	public static String getNoticeMsg(Message msg) {
		String notice = "Create Notice";
		try {
			Manageable obj = msg.getObj();
			String type = obj.getType();
			String command = msg.getCommand();
			notice = "Bạn vừa" + command + " " + type + " " + msg.getValue();
		} catch (Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
		return notice;
	}
}
