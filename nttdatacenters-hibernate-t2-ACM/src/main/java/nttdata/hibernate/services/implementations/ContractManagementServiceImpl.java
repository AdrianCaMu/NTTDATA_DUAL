package nttdata.hibernate.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import nttdata.hibernate.persistence.dao.implementations.ContractDaoImpl;
import nttdata.hibernate.persistence.dao.interfaces.ContractDaoI;
import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;
import nttdata.hibernate.services.interfaces.ContractManagementServiceI;

public class ContractManagementServiceImpl implements ContractManagementServiceI {

	private ContractDaoI contractDao;

	/**
	 * M�todo constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {
		// Verificaci�n de nulidad e inexistencia.
		if (newContract != null && newContract.getId() == null) {

			// Insercci�n del nuevo cliente.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(Contract updatedContract) {
		// Verificaci�n de nulidad y existencia.
		if (updatedContract != null && updatedContract.getId() != null) {

			// Actualizaci�n del cliente.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(Contract deletedContract) {
		// Verificaci�n de nulidad y existencia.
		if (deletedContract != null && deletedContract.getId() != null) {

			// Eliminaci�n del cliente.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(Long contractId) {
		// Resultado.
		Contract contract = null;

		// Verificaci�n de nulidad.
		if (contractId != null) {

			// Obtenci�n del cliente por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {
		// Resultado.
		List<Contract> contractList = new ArrayList<>();

		// Obtenci�n de clientes.
		contractList = contractDao.searchAll();

		return contractList;
	}

	@Override
	public List<Contract> searchByClientId(Client client) {
		// Resultado.
		List<Contract> contractList = new ArrayList<>();

		// Verificaci�n de nulidad.
		if (client != null) {

			// Obtenci�n del cliente por nombre y apellido.
			contractList = contractDao.searchByClientId(client);
		}

		return contractList;
	}

}
