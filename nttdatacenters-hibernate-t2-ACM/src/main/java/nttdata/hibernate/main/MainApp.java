package nttdata.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import nttdata.hibernate.persistence.entities.Client;
import nttdata.hibernate.persistence.entities.Contract;
import nttdata.hibernate.services.implementations.ClientManagementServiceImpl;
import nttdata.hibernate.services.implementations.ContractManagementServiceImpl;
import nttdata.hibernate.services.interfaces.ClientManagementServiceI;
import nttdata.hibernate.services.interfaces.ContractManagementServiceI;

public class MainApp {
	public static void main(String[] args) {
		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "ACM";
		final Date updatedDate = new Date();

		// Cliente prueba 1
		Client clienteprueba = new Client();
		clienteprueba.setDni("12345678A");
		clienteprueba.setName("nombrePrueba1");
		clienteprueba.setSurname("apellidoPrueba1");
		clienteprueba.setUpdatedUser(updatedUser);
		clienteprueba.setUpdatedDate(updatedDate);
		
		// Cliente prueba 2
		Client clienteprueba2 = new Client();
		clienteprueba2.setDni("87654321Z");
		clienteprueba2.setName("nombrePrueba2");
		clienteprueba2.setSurname("apellidoPrueba2");
		clienteprueba2.setUpdatedUser(updatedUser);
		clienteprueba2.setUpdatedDate(updatedDate);
		
		// Contrato prueba 1
		final Contract contrato1 = new Contract();
		contrato1.setClient(clienteprueba);
		contrato1.setExpirationDate("2030-09-09");
		contrato1.setValidatyDate("2010-09-09");
		contrato1.setPriceMonth(1.11);
		contrato1.setUpdatedDate(updatedDate);
		contrato1.setUpdatedUser(updatedUser);
		
		// Contrato prueba 2
		final Contract contrato2 = new Contract();
		contrato2.setClient(clienteprueba);
		contrato2.setExpirationDate("2030-09-09");
		contrato2.setValidatyDate("2010-09-09");
		contrato2.setPriceMonth(2.22);
		contrato2.setUpdatedDate(updatedDate);
		contrato2.setUpdatedUser(updatedUser);
		
		// Contrato prueba 3
		final Contract contrato3 = new Contract();
		contrato3.setClient(clienteprueba);
		contrato3.setExpirationDate("2030-09-09");
		contrato3.setValidatyDate("2010-09-09");
		contrato3.setPriceMonth(3.33);
		contrato3.setUpdatedDate(updatedDate);
		contrato3.setUpdatedUser(updatedUser);
		
		// insertamos contratos
		contractService.insertNewContract(contrato1);
		contractService.insertNewContract(contrato2);
		contractService.insertNewContract(contrato3);

		//lista contratos cliente 1
		final List<Contract> contracts = new ArrayList<>();
		contracts.add(contrato1);
		contracts.add(contrato2);
		
		//asignamos contratos a cliente 1
		clienteprueba.setContracts(contracts);

		//insertamos clientes
		clienteprueba = clientService.insertNewCliente(clienteprueba);
		clienteprueba2 = clientService.insertNewCliente(clienteprueba2);
		
		//modificamos cliente2
		clienteprueba2.setName("NombreModificado");
		clientService.updateCliente(clienteprueba2);

		// Consultas Clientes (JPA Criteria)
		List<Client> clients = clientService.searchByNameAndSurname("nombrePrueba1", "a%");

		System.out.println("\nClientes por nombre y apellido: ");
		for (final Client client : clients) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getDni());
		}
		System.out.println();
		
		List<Client> clients2 = clientService.searchAll();

		System.out.println("\nTodos los clientes: ");
		for (final Client client : clients2) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getDni());
		}
		
		System.out.println(" \nCliente con id = 1: ");
		Client clients3 = clientService.searchById(1L);
		System.out.println(clients3.toString());
				
		// Consultas Contratos (JPA Criteria)
		System.out.println();

		List<Contract> contracts2 = contractService.searchByClientId(clienteprueba);
		
		System.out.println("\nContratos del cliente 1: ");
		for (final Contract contract : contracts2) {
			System.out.println(contract.getId() + " | " + contract.getExpirationDate() + " | " + contract.getValidatyDate());
		}
				
		// Cierre de sesión.
		session.close();
	}
}
