package data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CARD")
public class Card {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "seri")
	private String seri;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_class")
	private String studentClass;

	@Column(name = "date_create")
	@Temporal(TemporalType.DATE)
	private Date dateCreate;

	@Column(name = "date_expire")
	@Temporal(TemporalType.DATE)
	private Date dateExpire;

	@Column(name = "email")
	private String email;

	/**
	 * 
	 */
	public Card() {
	}

	/**
	 * @param id
	 * @param seri
	 * @param studentName
	 * @param studentClass
	 * @param dateCreate
	 * @param dateExpire
	 * @param email
	 */
	public Card(int id, String seri, String studentName, String studentClass, Date dateCreate, Date dateExpire,
			String email) {
		super();
		this.id = id;
		this.seri = seri;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.dateCreate = dateCreate;
		this.dateExpire = dateExpire;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the seri
	 */
	public String getSeri() {
		return seri;
	}

	/**
	 * @param seri the seri to set
	 */
	public void setSeri(String seri) {
		this.seri = seri;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentClass
	 */
	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}

	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the dateExpire
	 */
	public Date getDateExpire() {
		return dateExpire;
	}

	/**
	 * @param dateExpire the dateExpire to set
	 */
	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
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

}
