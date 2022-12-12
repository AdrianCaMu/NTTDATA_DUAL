package spring.services;

import org.springframework.stereotype.Service;

import spring.repository.Product;

/**
 * calcula precio tras impuestos en la peninsula
 * @author Adrian Camara Munoz
 *
 */
@Service("peninsulaService")
public class PeninsulaImpl implements changePvpI {

	private static final double IVA = 1.21;

	public void precioPvp(Product product) {
		product.setPrecioPVP(product.getPrecioSinImpuestos()*IVA);		
	}
	
}
