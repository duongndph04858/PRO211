package data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notification {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "rp_rype")
	private String rp_type;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "borrow_id")
	private Borrow borrow;

	@Column(name = "employee_username")
	private String username;

	@Column(name = "description")
	private String description;

	@Column(name = "date_create")
	@Temporal(TemporalType.DATE)
	private Date dateCreate;

	@Column(name = "is_read")
	private String isRead;

	/**
	 * 
	 */
	public Notification() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param rp_type
	 * @param book
	 * @param borrow
	 * @param username
	 * @param description
	 * @param dateCreate
	 * @param isRead
	 */
	public Notification(int id, String rp_type, Book book, Borrow borrow, String username, String description,
			Date dateCreate, String isRead) {
		super();
		this.id = id;
		this.rp_type = rp_type;
		this.book = book;
		this.borrow = borrow;
		this.username = username;
		this.description = description;
		this.dateCreate = dateCreate;
		this.isRead = isRead;
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
	 * @return the rp_type
	 */
	public String getRp_type() {
		return rp_type;
	}

	/**
	 * @param rp_type the rp_type to set
	 */
	public void setRp_type(String rp_type) {
		this.rp_type = rp_type;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the borrow
	 */
	public Borrow getBorrow() {
		return borrow;
	}

	/**
	 * @param borrow the borrow to set
	 */
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the isRead
	 */
	public String getIsRead() {
		return isRead;
	}

	/**
	 * @param isRead the isRead to set
	 */
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
