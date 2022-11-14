package nttdata.hibernate.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.implementations.ClienteDaoImpl;
import nttdata.hibernate.persistence.dao.interfaces.ClienteDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.services.interfaces.ClienteManagementServiceI;

/**
 * Cliente Service Implementation
 * @author Adrian Camara Munoz
 *
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	private ClienteDaoI clienteDao;

	/**
	 * M�todo constructor.
	 */
	public ClienteManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	@Override
	public void insertNewCliente(Client newCliente) {
		// Verificaci�n de nulidad e inexistencia.
		if (newCliente != null && newCliente.getId() == null) {

			// Insercci�n del nuevo cliente.
			clienteDao.insert(newCliente);
		}
	}

	@Override
	public void updateCliente(Client updatedCliente) {
		// Verificaci�n de nulidad y existencia.
		if (updatedCliente != null && updatedCliente.getId() != null) {

			// Actualizaci�n del cliente.
			clienteDao.update(updatedCliente);
		}

	}

	@Override
	public void deleteCliente(Client deletedCliente) {
		// Verificaci�n de nulidad y existencia.
		if (deletedCliente != null && deletedCliente.getId() != null) {

			// Eliminaci�n del cliente.
			clienteDao.delete(deletedCliente);
		}

	}

	@Override
	public Client searchById(Long clienteId) {
		// Resultado.
		Client cliente = null;

		// Verificaci�n de nulidad.
		if (clienteId != null) {

			// Obtenci�n del cliente por ID.
			cliente = (Client) clienteDao.searchById(clienteId);
		}

		return cliente;
	}

	@Override
	public List<Client> searchAll() {
		// Resultado.
		List<Client> clienteList = new ArrayList<>();

		// Obtenci�n de clientes.
		clienteList = clienteDao.searchAll();

		return clienteList;
	}

	@Override
	public List<Client> searchByNameAndSurname(String namePattern, String surnamePattern) {
		// Resultado.
		List<Client> clienteList = new ArrayList<>();

		// Verificaci�n de nulidad.
		if (StringUtils.isNotBlank(namePattern) && StringUtils.isNotBlank(surnamePattern)) {

			// Obtenci�n del cliente por nombre y apellido.
			clienteList = clienteDao.searchByNameAndSurname(namePattern, surnamePattern);
		}

		return clienteList;
	}

}
