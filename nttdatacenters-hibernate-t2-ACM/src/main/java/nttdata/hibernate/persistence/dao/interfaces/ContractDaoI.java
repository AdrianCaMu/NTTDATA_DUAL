package nttdata.hibernate.persistence.dao.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;

public interface ContractDaoI extends CommonDaoI<Contract>{
	/**
	 * Obtiene contratos por id de cliente.
	 * 
	 * @param Long clientId
	 * @return List<Contract>
	 */
	public List<Contract> searchByClientId(final Client client);
}
