package nttdata.hibernate.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public abstract class AbstractEntity implements Serializable {
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditor�a | Usuario que actualiza */
	private String updatedUser;

	/** Auditor�a | D�a actualizado */
	private Date updatedDate;

	/**
	 * GET ID
	 * 
	 * @return Long id
	 */
	public abstract Long getId();

	/**
	 * @return the updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
