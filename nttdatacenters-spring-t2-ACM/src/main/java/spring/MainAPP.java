package spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.repository.Order;
import spring.repository.Product;
import spring.services.changePvpI;

/**
 * Clase Principal
 * 
 * @author Adrian Camara Munoz
 *
 */
@SpringBootApplication()
public class MainAPP implements CommandLineRunner {

	/** Servicio: peninsula */
	@Autowired
	@Qualifier("peninsulaService")
	private changePvpI peninsulaService;

	/** Servicio: sistema */
	@Autowired
	@Qualifier("noPeninsulaService")
	private changePvpI noPeninsulaService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainAPP.class, args);
	}

	public void run(String... args) throws Exception {

		// creamos productos
		Product product1 = new Product(1L, "product1", 100.0);
		Product product2 = new Product(2L, "product2", 50.0);
		Product product3 = new Product(3L, "product3", 150.0);

		// creamos pedidos
		Order order1 = new Order(1L, "paco", "málaga", true);
		Order order2 = new Order(1L, "manolo", "tenerife", false);

		// añadimos productos a pedidos
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(product1);
		productList1.add(product2);

		List<Product> productList2 = new ArrayList<Product>();
		productList2.add(product3);

		order1.setProductList(productList1);
		order2.setProductList(productList2);

		// setear precio tras impuestos
		setPVP(order1);
		setPVP(order2);

		// mostramos el precio despues de impuesto de cada producto
		System.err.println("PVP productos lista 1");
		for (Product p : order1.getProductList()) {
			System.err.println(p.getPrecioPVP());
		}
		
		System.err.println("PVP productos lista 2");
		for (Product p : order2.getProductList()) {
			System.err.println(p.getPrecioPVP());
		}

	}

	/**
	 * recorre la lista de productos de un pedido y setea sus precios tras impuestos
	 * 
	 * @param order pedido a revisar
	 */
	private void setPVP(Order order) {
		if (order.getRegionPeninsular()) {
			for (Product p : order.getProductList()) {
				peninsulaService.precioPvp(p);
			}
		} else {
			for (Product p : order.getProductList()) {
				noPeninsulaService.precioPvp(p);
			}
		}
	}
}
