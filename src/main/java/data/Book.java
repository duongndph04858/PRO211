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
@Table(name="BOOK")
public class Book {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private long price;
	
	@Column(name="insert_date")
	@Temporal(TemporalType.DATE)
	private Date insertDate;
	
	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
}
