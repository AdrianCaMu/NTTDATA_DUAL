package spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.repository.Client;
import spring.repository.ClientI;


/**
 * Implementacion Servicio de clientes
 * 
 * @author Adrian Camara Munoz
 */
@Service("clientService")
public class ClientManagementServiceImpl implements ClientManagementServiceI {
	
	@Autowired
	private ClientI client;

	/**
	 * Busca cliente por su ID
	 */
	public Client searchById(Long clientId) {

		if (clientId != null) {

			return this.client.searchByClientId(clientId);
		}
		
		return null;
	}

	/**
	 * Busca cliente por su nombre
	 */
	public List<Client> searchByName(String name) {
		List<Client> clientList = new ArrayList<>();

		// Si no es nulo
		if (name != null) {

			// Clientes con ese nombre
			clientList = client.searchByName(name);
		}
		return clientList;
	}

	/**
	 * Busca cliente por su apellido
	 */
	public List<Client> searchBySurname(String surname) {
		List<Client> clientList = new ArrayList<>();

		// Si no es nulo
		if (surname != null) {

			// Clientes con ese nombre
			clientList = client.searchBySurname(surname);
		}
		return clientList;
	}
}