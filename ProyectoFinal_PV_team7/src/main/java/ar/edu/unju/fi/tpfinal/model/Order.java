package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Table(name = "ORDERS")
@Component
@Entity
public class Order {

	@Id
	@Column(name = "or_number")
	private Long orderNumber;
	
	@Column(name = "or_order_date")
	private LocalDate orderDate;
	
	@Column(name = "or_req_date")
	private LocalDate requiredDate;
	
	@Column(name = "or_status")
	private String status;
	
	@Column(name = "or_comments")
	private String comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customer;
	
	//CONSTRUCTORES
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(Long orderNumber, LocalDate orderDate, LocalDate requiredDate, String status, String comments,
			Customer customer) {
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
