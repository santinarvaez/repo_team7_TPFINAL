package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PaymentId implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * Aquí generamos la Id compuesta conformada por cu_number(customer number) y check_number
	 */
	
	@ManyToOne
	@JoinColumn(name = "cu_number")
	private Customer customer;
	
	@Column(name="check_number")
	private String checkNumber;
	
	public PaymentId() {
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
}
