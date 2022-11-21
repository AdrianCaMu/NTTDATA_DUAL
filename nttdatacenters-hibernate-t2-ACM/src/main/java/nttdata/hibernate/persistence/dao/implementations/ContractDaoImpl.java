package nttdata.hibernate.persistence.dao.implementations;

import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.interfaces.ContractDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByClientId(final Client client) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y apellido.
		return session.createQuery("FROM Contract WHERE client=" + client.getId()).list();

	}
}
