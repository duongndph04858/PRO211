package data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARD_TYPE")
public class CardType implements Management {

	@Id
	private int id;

	@OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
	private Set<Card> listCard;

	@Column(name = "card_type")
	private String name;

	private int status;

	@Column(name = "expire_date")
	private int longevity;

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
	 * @return the listCard
	 */
	public Set<Card> getListCard() {
		return listCard;
	}

	/**
	 * @param listCard the listCard to set
	 */
	public void setListCard(Set<Card> listCard) {
		this.listCard = listCard;
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
	 * @return the longevity
	 */
	public int getLongevity() {
		return longevity;
	}

	/**
	 * @param longevity the longevity to set
	 */
	public void setLongevity(int longevity) {
		this.longevity = longevity;
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
	public CardType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return "loại thẻ";
	}
}
