package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Table(name = "ORDERSDS")
@Entity
@Component
public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderDetailId id;
	
	@Column(name = "ors_quantity_ordered")
	private int quantityOrdered;
	
	@Column(name = "ors_price_each")
	private float priceEach;
	
	@Column(name = "ors_lNumber")
	private int orderLineNumber;
	
	//CONSTRUCTORES
	
	 public OrderDetail() {
	}
	 
	
	public OrderDetail(OrderDetailId id, int quantityOrdered, float priceEach, int orderLineNumber) {
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
