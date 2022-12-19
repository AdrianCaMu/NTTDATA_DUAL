package spring.services;

import java.util.List;

import spring.repository.Client;

/**
 * Interfaz Servicio de clientes
 * 
 * @author Adrian Camara Munoz
 */
public interface ClientManagementServiceI {

	/**
	 * Busca en la bbdd el cliente con un id determinado
	 * 
	 * @param clientId ID de cliente a buscar
	 * @return cliente con la ID buscada
	 */
	public Client searchById(final Long clientId);

	/**
	 * Busca en la bbdd los clientes con un nombre determinado
	 * 
	 * @param name Nombre a buscar
	 * @return Lista de clientes que ienen el nombre buscado 
	 */
	public List<Client> searchByName(final String name);


	/**
	 * Busca en la bbdd los clientes con un apellido determinado
	 * 
	 * @param surname Apellido a buscar
	 * @return Lista de clientes que tienen el apellido buscado
	 */
	public List<Client> searchBySurname(String surname);
}