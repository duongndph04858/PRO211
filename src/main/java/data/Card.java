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
@Table(name = "CARDS")
public class Card implements Manageable {

	@Id
	@GeneratedValue
	@Column(name = "seri")
	private long seri;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Column(name = "fullname")
	private String fullname;

	@ManyToOne
	@JoinColumn(name = "card_type")
	private CardType card;

	@Column(name = "date_create")
	@Temporal(TemporalType.DATE)
	private Date dateCreate;

	@Column(name = "date_expire")
	@Temporal(TemporalType.DATE)
	private Date dateExpire;

	@Column(name = "status")
	private int status;

	@Column(name = "loan_time")
	private int loanTime;

	@Column(name = "descriptions")
	private String descriptions;

	@Override
	public String getType() {
		return "thẻ";
	}

	/**
	 * 
	 */
	public Card() {
	}

	/**
	 * @return the seri
	 */
	public long getSeri() {
		return seri;
	}

	/**
	 * @param seri the seri to set
	 */
	public void setSeri(long seri) {
		this.seri = seri;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the card
	 */
	public CardType getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(CardType card) {
		this.card = card;
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
	 * @return the dateExpire
	 */
	public Date getDateExpire() {
		return dateExpire;
	}

	/**
	 * @param dateExpire the dateExpire to set
	 */
	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
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
	 * @return the loanTime
	 */
	public int getLoanTime() {
		return loanTime;
	}

	/**
	 * @param loanTime the loanTime to set
	 */
	public void setLoanTime(int loanTime) {
		this.loanTime = loanTime;
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
}
