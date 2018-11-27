package util;

import core.entity.Message;
import data.Book;
import data.BookShelf;
import data.Card;
import data.Category;
import data.Manageable;
import data.Publisher;
import data.Roles;
import data.User;

public class MessageUtil {

	public static String getDescription(Message msg) {
		String message = "start create message";
		try {
			Manageable obj = msg.getObj();
			String type = obj.getType();
			switch (type) {
			case "sách":
				message = getMsg(msg, ((Book) obj).getName());
				break;
			case "thẻ":
				Card card = (Card) obj;
				message = getMsg(msg, card.getCard().getName() + "(số thẻ:" + card.getSeri() + ")");
				break;
			case "giá sách":
				message = getMsg(msg, ((BookShelf) obj).getShelf());
				break;
			case "nhà xuất bản":
				message = getMsg(msg, ((Publisher) obj).getName());
				break;
			case "danh mục":
				message = getMsg(msg, ((Category) obj).getName());
				break;
			default:
				message = "Empty object to create log message";
				break;
			}
			return message;
		} catch (

		Exception e) {
			e.printStackTrace();
			return AppConstrant.CORE_ERROR;
		}
	}

	private static String getMsg(Message msg, String detail) {
		String type = msg.getObj().getType();
		String command = msg.getCommand();
		User user = msg.getUser();
		String message = "";
		if (!type.isEmpty() && user != null) {
			Roles r = user.getPosition();
			message = r.getRoles() + " " + user.getFullname() + "(" + user.getUsername() + ") " + command + " " + type
					+ ": " + detail;
		}
		return message;
	}
}
