package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BORROW")
public class Borrow {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="card_seri")
	private String cardSeri;
	
	

}
