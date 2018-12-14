package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import core.entity.Conditions;

@Entity
@Table(name = "PUBLISHER")
public class Publisher implements Management {
	@Id
	@Conditions
	@Column(name = "publisher")
	private String id;
	@OneToMany(mappedBy = "publisher",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Book> books;
	@Conditions
	@Column(name = "name")
	private String name;
	@Conditions
	@Column(name = "status")
	private int status;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "descriptions")
	private String descriptions;

	public String getType() {
		return "nhà xuất bản";
	}

	/**
	 * @return the publisher
	 */

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
