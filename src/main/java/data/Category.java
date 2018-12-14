package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import core.entity.Conditions;

@Entity
@Table(name = "CATEGORY")
public class Category implements Management {
	@Id
	@Column(name = "category")
	@Conditions
	private String id;

	@OneToMany(mappedBy = "categ")
	private List<BookCategory> bookCategory;

	@Conditions
	private String name;

	@Conditions
	private int status;
	private String descriptions;

	@Transient
	private int totalBook;

	/**
	 * @return the totalBook
	 */
	public int getTotalBook() {
		totalBook = 0;
		for (BookCategory x : bookCategory) {
			totalBook += x.getBook().getAmount();
		}
		return totalBook;
	}

	/**
	 * @param totalBook the totalBook to set
	 */
	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}

	/**
	 * 
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	public String getType() {
		return "danh mục";
	}

	/**
	 * @return the bookCategory
	 */
	public List<BookCategory> getBookCategory() {
		return bookCategory;
	}

	/**
	 * @param bookCategory the bookCategory to set
	 */
	public void setBookCategory(List<BookCategory> bookCategory) {
		this.bookCategory = bookCategory;
	}

}
