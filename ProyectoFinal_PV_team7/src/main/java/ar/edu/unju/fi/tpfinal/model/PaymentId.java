package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

@Embeddable
public class PaymentId implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * Aquí generamos la Id compuesta conformada por cu_number(customer number) y check_number
	 */
	
	@NotNull
	@Autowired
	@ManyToOne
	@JoinColumn(name = "cu_number")
	private Customer customer;
	
	@NotNull
	@Column(name="check_number")
	private String checkNumber;
	
	//CONSTRUCTORES
	
	public PaymentId() {
		// TODO Auto-generated constructor stub
	}
	

	public PaymentId(@NotNull Customer customer, @NotNull String checkNumber) {
		super();
		this.customer = customer;
		this.checkNumber = checkNumber;
	}

	//GETTERS AND SETTERS
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
