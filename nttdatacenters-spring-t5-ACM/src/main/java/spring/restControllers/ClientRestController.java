package spring.restControllers;

import java.util.HashMap;
import java.util.Map;
import spring.repository.Client;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementacion Controlador Rest de Clientes
 * 
 * @author Adrian Camara Munoz
 */
@RestController
@RequestMapping("/home/clients")
public class ClientRestController {

	private Map<Long, Client> clientList;

	/**
	 * Creamos el falso respositorio 
	 */
	public ClientRestController() {

		clientList = new HashMap<>();

		// Clientes de prueba
		final Client client1 = new Client();
		client1.setClientId(1L);
		client1.setName("Paco");
		client1.setSurname("Diaz");
		client1.setDni("12345678Z");
		clientList.put(1L, client1);

		final Client client2 = new Client();
		client2.setClientId(2L);
		client2.setName("Manolo");
		client2.setSurname("Rodiguez");
		client2.setDni("87654321Z"); 
		clientList.put(2L, client2);
	}

	/**
	 * Obtiene los clientes del repositorio falso
	 * 
	 * @return Mapa de clientes junto a sus ids
	 */
	@GetMapping
	public Map<Long, Client> getClientsList() {
		return clientList;
	}

	/**
	 * Añade un nuevo cliente
	 * 
	 * @param newClient Cliente a añadir
	 */
	@PostMapping
	public void addClient(final @RequestBody Client newClient) {
		clientList.put(newClient.getClientId(), newClient);
	}

	/**
	 * Elimina un cliente
	 * 
	 * @param clientId Id del cliente a eliminar
	 */
	@DeleteMapping(value = "/{clientId}")
	public void deleteClient(final @PathVariable Long clientId) {
		clientList.remove(clientId);
	}

	/**
	 * Obtiene cliente con una id determinada
	 * 
	 * @param clientId id del cliente buscada
	 * @return client Cliente buscado
	 */
	@RequestMapping(path = "/client", method = RequestMethod.GET, consumes = "application/json")
	public Client searchById(@RequestBody Long clientId) {
		return clientList.get(clientId);
	}
}