package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.entity.Conditions;

@Entity
@Table(name = "BOOK_CATEGORY")
public class BookCategory implements Management {
	@Id
	@GeneratedValue
	@Conditions
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category categ;

	@ManyToOne
	@JoinColumn(name = "book")
	private Book book;

	@Conditions
	private int status;
	private String descriptions;

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
	 * @return the categ
	 */
	public Category getCateg() {
		return categ;
	}

	/**
	 * @param categ the categ to set
	 */
	public void setCateg(Category categ) {
		this.categ = categ;
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the descriptions
	 */
	public String getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * 
	 */
	public BookCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "sách-danh mục";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

}
