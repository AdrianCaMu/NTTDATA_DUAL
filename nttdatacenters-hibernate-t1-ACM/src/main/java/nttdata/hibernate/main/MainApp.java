package nttdata.hibernate.main;

import java.util.Date;
import java.util.List;

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

		// Consultas (JPA Criteria)
		List<Client> clients = clientService.searchByNameAndSurname("N%", "A%");

		for (final Client client : clients) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getDni());
		}
		
		// Cierre de sesión.
		session.close();
	}
}
