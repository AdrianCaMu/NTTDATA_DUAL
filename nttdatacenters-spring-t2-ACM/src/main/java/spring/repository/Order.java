package spring.repository;

import java.util.List;

public class Order {

	/** ID del pedido */
	private Long orderId;
	/**
	 * Destinatario del pedido
	 */
	private String destinatario;
	/**
	 * Direccion del pedido
	 */
	private String direccion;
	/**
	 * region del pedido (true para peninsula, false para fuera de la peninsula)
	 */
	private boolean regionPeninsular;
	/**
	 * lista de proctos del pedido
	 */
	private List<Product> productList;

	/**
	 * Constructor
	 * @param orderId
	 * @param destinatario
	 * @param direccion
	 * @param regionPeninsular
	 */
	public Order(Long orderId, String destinatario, String direccion, boolean regionPeninsular) {
		super();
		this.orderId = orderId;
		this.destinatario = destinatario;
		this.direccion = direccion;
		this.regionPeninsular = regionPeninsular;
	}

	// getters and setters

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean getRegionPeninsular() {
		return regionPeninsular;
	}

	public void setRegionPeninsular(boolean regionPeninsular) {
		this.regionPeninsular = regionPeninsular;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
