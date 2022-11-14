package nttdata.hibernate.persistence.dao.implementations;

import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.ClienteDaoI;
import nttdata.hibernate.persistence.entities.Client;

/**
 * Cliente Dao Implementation
 * @author Adrian Camara Munoz
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Client> implements ClienteDaoI {
	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndSurname(final String name, final String surname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y apellido.
		return session.createQuery("FROM Client WHERE name='" + name + "' and surname='" + surname + "'").list();
		
	}

}
