package nttdata.hibernate.persistence.dao.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;

/**
 * Cliente Dao Interface 
 * @author Adrian Camara Munoz
 *
 */
public interface ClienteDaoI extends CommonDaoI<Client>{
	/**
	 * Obtiene clientes por nombre y apellido.
	 * 
	 * @param namePattern
	 * @param surnamePattern
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSurname(final String namePattern, final String surnamePattern);
	
}
