package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Table(name = "ORDERSDS")
@Entity
@Component
public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderDetailId id;
	
	@NotNull(message = "Ingrese una cantidad mayor a 0")
	@Min(value = 0)
	@Column(name = "ors_quantity_ordered")
	private int quantityOrdered;
	
	@NotNull
	@Column(name = "ors_price_each")
	private float priceEach;
	
	@NotNull
	@Column(name = "ors_lNumber")
	private int orderLineNumber;
	
	//CONSTRUCTORES
	
	 public OrderDetail() {
	}
	 
	
	public OrderDetail(OrderDetailId id,
			@NotNull(message = "Ingrese una cantidad mayor a 0") @Min(0) int quantityOrdered, @NotNull float priceEach,
			@NotNull int orderLineNumber) {
		super();
		this.id = id;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}


	//GETTERS AND SETTERS

	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public float getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(float priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
