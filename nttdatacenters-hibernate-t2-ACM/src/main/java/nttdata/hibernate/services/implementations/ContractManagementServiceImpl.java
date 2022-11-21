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
	 * Método constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {
		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getId() == null) {

			// Insercción del nuevo cliente.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(Contract updatedContract) {
		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getId() != null) {

			// Actualización del cliente.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(Contract deletedContract) {
		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getId() != null) {

			// Eliminación del cliente.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(Long contractId) {
		// Resultado.
		Contract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del cliente por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {
		// Resultado.
		List<Contract> contractList = new ArrayList<>();

		// Obtención de clientes.
		contractList = contractDao.searchAll();

		return contractList;
	}

	@Override
	public List<Contract> searchByClientId(Client client) {
		// Resultado.
		List<Contract> contractList = new ArrayList<>();

		// Verificación de nulidad.
		if (client != null) {

			// Obtención del cliente por nombre y apellido.
			contractList = contractDao.searchByClientId(client);
		}

		return contractList;
	}

}
