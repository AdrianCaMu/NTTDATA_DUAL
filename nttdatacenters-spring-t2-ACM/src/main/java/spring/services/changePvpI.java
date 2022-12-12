package spring.services;

import spring.repository.Product;

/**
 * interfaz servicio para calcular precios después de impuestos
 * @author Adrian Camara Munoz
 *
 */
public interface changePvpI {

	public void precioPvp(final Product product);

}
