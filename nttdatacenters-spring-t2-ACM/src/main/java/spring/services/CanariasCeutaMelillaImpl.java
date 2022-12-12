package spring.services;

import org.springframework.stereotype.Service;

import spring.repository.Product;

/**
 * calcula precio tras impuestos fuera de la peninsula
 * @author Adrian Camara Munoz
 *
 */
@Service("noPeninsulaService")
public class CanariasCeutaMelillaImpl implements changePvpI {
	
	private static final double IPSI = 1.04;

	public void precioPvp(Product product) {
		product.setPrecioPVP(product.getPrecioSinImpuestos()*IPSI);		
	}


}
