package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de Clientes
 * @author Adrian Camara Munoz
 *
 */
@Repository
public interface ClientI extends JpaRepository<Client, Long> {
	/**
	 * Busca un cliente por su id
	 * 
	 * @param id ID del cliente
	 * @return Cliente buscado
	 */
	public Client searchByClientId(final Long id);

	/**
	 * Busca clientes con un nombre determinado
	 * 
	 * @param name Nombre de cliente a buscar
	 * @return Lista de clientes con ese nombre
	 */
	public List<Client> searchByName(final String name);

	/**
	 * Busca clientes con un apellido determinado
	 * 
	 * @param surname apellido a buscar
	 * @return Lista de clientes que tengan ese apellido
	 */
	public List<Client> searchBySurname(final String surname);
}