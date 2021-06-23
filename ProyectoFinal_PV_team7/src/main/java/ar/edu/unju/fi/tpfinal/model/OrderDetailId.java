package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Embeddable
public class OrderDetailId implements Serializable {
	
	/**
	 * Aquí generamos la Id compuesta conformada por pro_Code y order_number
	 */
		
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pro_code")
	private Product productCode;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "or_number")
	private Order orderNumber;
	
	//CONSTRUCTORES
	
	public OrderDetailId() {
	}


	public OrderDetailId(@NotNull Product productCode, @NotNull Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}
	
	//GETTERS & SETTERS

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
