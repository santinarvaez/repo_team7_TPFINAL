package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pro_code")
	private Product productCode;
	
	@ManyToOne
	@JoinColumn(name = "or_number")
	private Order orderNumber;
	
	public OrderDetailId() {
	}

	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Order getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
