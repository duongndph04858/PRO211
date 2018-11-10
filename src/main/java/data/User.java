package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="username")
	private String username;

	@Column(name="pass")
	private String password;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="position")
	private boolean position;
	
	@Column(name="image")
	private String image;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="cmnd")
	private String cmnd;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private boolean isMale;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String username, String password, String fullname, String address, boolean position, String image,
			String phone, String cmnd, String email, boolean isMale) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.position = position;
		this.image = image;
		this.phone = phone;
		this.cmnd = cmnd;
		this.email = email;
		this.isMale = isMale;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}



	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}



	/**
	 * @return the position
	 */
	public boolean getPosition() {
		return position;
	}



	/**
	 * @param position the position to set
	 */
	public void setPosition(boolean position) {
		this.position = position;
	}



	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}



	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}



	/**
	 * @return the cmnd
	 */
	public String getCmnd() {
		return cmnd;
	}



	/**
	 * @param cmnd the cmnd to set
	 */
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the isMale
	 */
	public boolean isMale() {
		return isMale;
	}



	/**
	 * @param isMale the isMale to set
	 */
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	
}
