package nttdata.hibernate.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Contract Entity Class
 * 
 * @author Adrian Camara Munoz
 *
 */
@Entity
@Table(name = "TABLA_CONTRATO")
public class Contract extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idContract;
	private String validityDate;
	private String expirationDate;
	private Double priceMonth;
	private Client client;

	/**
	 * @return the contract id
	 */
	@Transient
	@Override
	public Long getId() {
		return getIdContract();
	}

	/**
	 * @return the contract id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID", unique = true)
	public Long getIdContract() {
		return this.idContract;
	}

	/**
	 * @param idContract the Contract id to set
	 */
	public void setIdContract(Long idContract) {
		this.idContract = idContract;
	}

	/**
	 * @return the validaty date
	 */
	@Column(name = "VALIDATY_DATE")
	public String getValidatyDate() {
		return this.validityDate;
	}

	/**
	 * @param validatyDate the validaty date to set
	 */
	public void setValidatyDate(String validatyDate) {
		this.validityDate = validatyDate;
	}

	/**
	 * @return the expiration date
	 */
	@Column(name = "EXPIRATION_DATE")
	public String getExpirationDate() {
		return this.expirationDate;
	}

	/**
	 * @param expirationDate the expiration date to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the price month
	 */
	@Column(name = "PRICE_MONTH")
	public Double getPriceMonth() {
		return this.priceMonth;
	}

	/**
	 * @param priceMonth the price month to set
	 */
	public void setPriceMonth(Double priceMonth) {
		this.priceMonth = priceMonth;
	}
	
	/**
	 * 
	 * @return
	 */
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID_FK")
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
