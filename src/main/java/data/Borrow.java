package data;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BORROW")
public class Borrow {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "card_seri")
	private String cardSeri;

	@ManyToMany
	@JoinColumn(name = "book_id")
	private Set<Book> books;

	@Column(name = "borrow_date")
	@Temporal(TemporalType.DATE)
	private Date borrowDate;

	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "amount")
	private int amount;

	@Column(name = "paid")
	private boolean paid;

	@Column(name = "description")
	private String description;

	/**
	 * 
	 */
	public Borrow() {
	}

	/**
	 * @param id
	 * @param cardSeri
	 * @param book
	 * @param borrowDate
	 * @param dueDate
	 * @param employeeId
	 * @param amount
	 * @param paid
	 * @param description
	 */
	public Borrow(int id, String cardSeri, Set<Book> books, Date borrowDate, Date dueDate, String employeeId,
			int amount, boolean paid, String description) {
		super();
		this.id = id;
		this.cardSeri = cardSeri;
		this.books = books;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.employeeId = employeeId;
		this.amount = amount;
		this.paid = paid;
		this.description = description;
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
	 * @return the cardSeri
	 */
	public String getCardSeri() {
		return cardSeri;
	}

	/**
	 * @param cardSeri the cardSeri to set
	 */
	public void setCardSeri(String cardSeri) {
		this.cardSeri = cardSeri;
	}

	/**
	 * @return the book
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param book the book to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/**
	 * @return the borrowDate
	 */
	public Date getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the paid
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
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

}
