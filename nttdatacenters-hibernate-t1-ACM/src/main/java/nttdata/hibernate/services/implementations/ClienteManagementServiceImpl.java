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
	 * Método constructor.
	 */
	public ClienteManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	@Override
	public void insertNewCliente(Client newCliente) {
		// Verificación de nulidad e inexistencia.
		if (newCliente != null && newCliente.getId() == null) {

			// Insercción del nuevo cliente.
			clienteDao.insert(newCliente);
		}
	}

	@Override
	public void updateCliente(Client updatedCliente) {
		// Verificación de nulidad y existencia.
		if (updatedCliente != null && updatedCliente.getId() != null) {

			// Actualización del cliente.
			clienteDao.update(updatedCliente);
		}

	}

	@Override
	public void deleteCliente(Client deletedCliente) {
		// Verificación de nulidad y existencia.
		if (deletedCliente != null && deletedCliente.getId() != null) {

			// Eliminación del cliente.
			clienteDao.delete(deletedCliente);
		}

	}

	@Override
	public Client searchById(Long clienteId) {
		// Resultado.
		Client cliente = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del cliente por ID.
			cliente = (Client) clienteDao.searchById(clienteId);
		}

		return cliente;
	}

	@Override
	public List<Client> searchAll() {
		// Resultado.
		List<Client> clienteList = new ArrayList<>();

		// Obtención de clientes.
		clienteList = clienteDao.searchAll();

		return clienteList;
	}

	@Override
	public List<Client> searchByNameAndSurname(String namePattern, String surnamePattern) {
		// Resultado.
		List<Client> clienteList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(namePattern) && StringUtils.isNotBlank(surnamePattern)) {

			// Obtención del cliente por nombre y apellido.
			clienteList = clienteDao.searchByNameAndSurname(namePattern, surnamePattern);
		}

		return clienteList;
	}

}
