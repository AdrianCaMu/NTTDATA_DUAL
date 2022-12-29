package spring.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase-Entidad Client
 *
 * @author Adrian Camara Munoz
 */
@Entity
@Table(name = "TABLE_CLIENTS")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	private Long clientId;
	private String name;
	private String surname;
	private String dni;

	// Getters & setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long id) {
		this.clientId = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	// toString
	@Override
	public String toString() {
		return "Cliente [id=" + clientId + ", name=" + name + ", surname=" + surname + ", dni=" + dni + "]";
	}
}
