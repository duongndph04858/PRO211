package data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToMany(mappedBy="books",fetch=FetchType.EAGER)
	private List<Borrow> borrows;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private long price;

	@Column(name = "insert_date")
	@Temporal(TemporalType.DATE)
	private Date insertDate;

	@Column(name = "author")
	private String author;

	@Column(name = "description")
	private String description;

	/**
	 * 
	 */
	public Book() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param category
	 * @param price
	 * @param insertDate
	 * @param author
	 * @param description
	 */
	public Book(int id, String name, String category, long price, Date insertDate, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.insertDate = insertDate;
		this.author = author;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate the insertDate to set
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * @return the borrows
	 */
	public List<Borrow> getBorrows() {
		return borrows;
	}

	/**
	 * @param borrows the borrows to set
	 */
	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}
	
	

}
