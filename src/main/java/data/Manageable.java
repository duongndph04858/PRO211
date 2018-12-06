package data;

public abstract class Manageable<T extends Management> {

	private String command;
	private T obj;
	private User userDo;
	private String message;
	private String status;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public User getUserDo() {
		return userDo;
	}

	public void setUserDo(User userDo) {
		this.userDo = userDo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
