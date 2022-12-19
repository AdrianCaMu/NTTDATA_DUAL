package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.repository.Client;
import spring.repository.ClientI;
import spring.services.ClientManagementServiceI;

/**
 * Clase Principal
 * 
 * @author Adrian Camara Munoz
 *
 */
@SpringBootApplication()
public class MainAPP implements CommandLineRunner {

	/** Servicio: clientes */
	@Autowired
	@Qualifier("clientService")
	private ClientManagementServiceI  clientService;
	

	/** Repositorio: clientes */
	@Autowired
	private ClientI clients;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainAPP.class, args);
	}

	public void run(String... args) throws Exception {

		// creamos clientes
		Client client1 = new Client();
		client1.setName("Paco");
		client1.setSurname("Diaz");
		client1.setDni("12345678Z");
		
		Client client2 = new Client();
		client2.setName("Manolo");
		client2.setSurname("Rodiguez");
		client2.setDni("87654321Z");
		
		// Guardamos en la bbdd
		clients.save(client1);
		clients.save(client2);

		//consultas
		System.out.println("Consulta po ID: ");
		System.out.println(clientService.searchById(1L));
		
		System.out.println("Consulta por Nombre: ");
		System.out.println(clientService.searchByName("Manolo"));
		
		System.out.println("Consulta por Apellido: ");
		System.out.println(clientService.searchBySurname("Diaz"));
	}
}
