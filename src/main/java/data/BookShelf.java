package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKSHELF")
public class BookShelf implements Management {

	@Id
	private String shelf;
	private int line;
	private int col;
	private String location;
	private String status;
	private String descriptions;

	/**
	 * @return the shelf
	 */
	public String getShelf() {
		return shelf;
	}

	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	/**
	 * @return the line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
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
	public BookShelf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return "giá sách";
	}

	public String getName() {
		return shelf;
	}
}
