package nttdata.hibernate.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Cliente Entity Class
 * @author Adrian Camara Munoz
 *
 */
@Entity
@Table(name = "TABLA_CLIENTE")
public class Client extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCliente;
	private String name;
	private String surname;
	private String dni;
	private List<Contract> contracts;
	
	/**
	 * @return the client id
	 */
	@Transient
	@Override
	public Long getId() {
		return idCliente;
	}

	/**
	 * @return the client id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE_ID", unique = true)
	public Long getIdCliente() {
		return this.idCliente;
	}
	
	/**
	 * @param idCliente the Cliente id to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false)
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
	 * @return the surname
	 */
	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * 
	 * @return list of contracts
	 */
	@Column(name = "CONTRACTS")
	@OneToMany(mappedBy = "client")
	public List<Contract> getContracts() {
		return this.contracts;
	}
	
	/**
	 * 
	 * @param contracts list of contracts to set
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public String toString() {
		return "Client [idCliente=" + idCliente + ", name=" + name + ", surname=" + surname + ", dni=" + dni + "]";
	}

}
