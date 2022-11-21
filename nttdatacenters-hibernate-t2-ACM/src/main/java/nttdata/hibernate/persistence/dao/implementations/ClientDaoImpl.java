package nttdata.hibernate.persistence.dao.implementations;

import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.ClientDaoI;
import nttdata.hibernate.persistence.entities.Client;

/**
 * Cliente Dao Implementation
 * @author Adrian Camara Munoz
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {
	/** Sesi�n de conexi�n a BD */
	private Session session;

	/**
	 * M�todo constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndSurname(final String name, final String surname) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en funci�n del nombre y apellido.
		return session.createQuery("FROM Client WHERE name like '" + name + "' and surname like '" + surname + "'").list();
		
	}

}
