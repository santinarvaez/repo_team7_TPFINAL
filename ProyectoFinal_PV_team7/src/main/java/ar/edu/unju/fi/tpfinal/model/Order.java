package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Table(name = "ORDERS")
@Component
@Entity
public class Order {

	@Id
	@NotNull(message = "Ingrese id")
	@Column(name = "or_number")
	private Long orderNumber;
	
	@NotNull(message = "Ingrese una fecha válida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "or_order_date")
	private LocalDate orderDate;
	
	@NotNull(message = "Ingrese una fecha válida")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "or_req_date")
	private LocalDate requiredDate;
	
	@NotNull(message = "La orden debe tener un estado")
	@Column(name = "or_status")
	private String status;
	
	@Column(name = "or_comments")
	private String comments;
	
	@Autowired
	@NotNull(message = "Debe ingresar un cliente existente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customer;
	
	//CONSTRUCTORES
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	

	public Order(@NotNull(message = "Ingrese id") Long orderNumber,
			@NotNull(message = "Ingrese una fecha válida") LocalDate orderDate,
			@NotNull(message = "Ingrese una fecha válida") LocalDate requiredDate,
			@NotNull(message = "La orden debe tener un estado") String status, String comments,
			@NotNull(message = "Debe ingresar un cliente existente") Customer customer) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.status = status;
		this.comments = comments;
		this.customer = customer;
	}


	//GETTERS & SETTERS

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
