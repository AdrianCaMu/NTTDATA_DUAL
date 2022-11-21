package nttdata.hibernate.services.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;

/**
 * Cliente Service Interface
 * @author Adrian Camara Munoz
 *
 */
public interface ClientManagementServiceI {
	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newClient
	 * @return 
	 */
	public Client insertNewCliente(final Client newClient);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedClient
	 */
	public void updateCliente(final Client updatedClient);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedClient
	 */
	public void deleteCliente(final Client deletedClient);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clientId
	 */
	public Client searchById(final Long clientId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Cliente>
	 */
	public List<Client> searchAll();

	/**
	 * Obtiene clientes por nombre y salario.
	 * 
	 * @param namePattern
	 * @param surnamePattern
	 * @return List<Cliente>
	 */
	public List<Client> searchByNameAndSurname(final String namePattern, final String surnamePattern);
}
