package spring.repository;

public class Product {
	/** ID del pedido */
	private Long productId;
	/**
	 * nombre del producto
	 */
	private String nombre;
	/**
	 * precio después de impuestos
	 */
	private Double precioPVP;
	/**
	 * precio antes de impuestos
	 */
	private Double precioSinImpuestos;
	/**
	 * pedido asociado al producto
	 */
	private Order order;
	
	/**
	 * Constructor
	 * @param productId
	 * @param nombre
	 * @param precioSinImpuestos
	 */
	public Product(Long productId, String nombre, Double precioSinImpuestos) {
		super();
		this.productId = productId;
		this.nombre = nombre;
		this.precioSinImpuestos = precioSinImpuestos;
	}
	
	//getters and setters
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecioPVP() {
		return precioPVP;
	}
	public void setPrecioPVP(Double precioPVP) {
		this.precioPVP = precioPVP;
	}
	public Double getPrecioSinImpuestos() {
		return precioSinImpuestos;
	}
	public void setPrecioSinImpuestos(Double precioSinImpuestos) {
		this.precioSinImpuestos = precioSinImpuestos;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
