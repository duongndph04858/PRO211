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

	@Column(name="password")
	private String password;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="position")
	private String position;
	
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
}
