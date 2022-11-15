package nttdata.hibernate.main;

import java.util.Date;
import java.util.List;
import java.util.function.IntToLongFunction;

import org.hibernate.Session;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.services.implementations.ClienteManagementServiceImpl;
import nttdata.hibernate.services.interfaces.ClienteManagementServiceI;

public class MainApp {
	public static void main(String[] args) {
		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClienteManagementServiceI clientService = new ClienteManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "ACM";
		final Date updatedDate = new Date();

		final Client clienteprueba = new Client();
		clienteprueba.setDni("12345678A");
		clienteprueba.setName("Nombre");
		clienteprueba.setSurname("Apellido");
		clienteprueba.setUpdatedUser(updatedUser);
		clienteprueba.setUpdatedDate(updatedDate);

		clientService.insertNewCliente(clienteprueba);
		
		clienteprueba.setName("NombreModificado");
		
		clientService.updateCliente(clienteprueba);
		clienteprueba.setUpdatedUser(updatedUser);
		clienteprueba.setUpdatedDate(updatedDate);
		
		final Client clienteBorrar = new Client();
		clienteBorrar.setDni("12312312B");
		clienteBorrar.setName("borable");
		clienteBorrar.setSurname("borrado");
		clienteprueba.setUpdatedUser(updatedUser);
		clienteprueba.setUpdatedDate(updatedDate);
		
		clientService.deleteCliente(clienteBorrar);
		clienteprueba.setUpdatedUser(updatedUser);
		clienteprueba.setUpdatedDate(updatedDate);
		

		// Consultas (JPA Criteria)
		List<Client> clients = clientService.searchByNameAndSurname("N%", "A%");

		for (final Client client : clients) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getDni());
		}
		
		List<Client> clients2 = clientService.searchAll();

		for (final Client client : clients2) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getDni());
		}
		
		Long id = (long) 1;
		Client clients3 = clientService.searchById(id);
		System.out.println(clients3);
		
		// Cierre de sesión.
		session.close();
	}
}
