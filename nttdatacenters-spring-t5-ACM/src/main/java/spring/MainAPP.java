package spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase Principal
 * 
 * @author Adrian Camara Munoz
 *
 */
@SpringBootApplication()
public class MainAPP implements CommandLineRunner {

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainAPP.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Servidor lanzado.");
	}
}
