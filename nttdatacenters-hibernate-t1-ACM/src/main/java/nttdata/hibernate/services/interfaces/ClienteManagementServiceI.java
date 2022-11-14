package nttdata.hibernate.services.interfaces;

import java.util.List;

import nttdata.hibernate.persistence.entities.Client;

/**
 * Cliente Service Interface
 * @author Adrian Camara Munoz
 *
 */
public interface ClienteManagementServiceI {
	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCliente
	 */
	public void insertNewCliente(final Client newCliente);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCliente
	 */
	public void updateCliente(final Client updatedCliente);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCliente
	 */
	public void deleteCliente(final Client deletedCliente);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clienteId
	 */
	public Client searchById(final Long idCliente);

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
