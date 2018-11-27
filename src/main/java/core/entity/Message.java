package core.entity;

import data.Manageable;
import data.User;

public class Message {
	private String command;
	private User user;
	private Manageable obj;

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the obj
	 */
	public Manageable getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Manageable obj) {
		this.obj = obj;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
