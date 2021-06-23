package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PAYMENTS")
public class Payment {
		
	@EmbeddedId
	private PaymentId id;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "pay_payDate")
	private LocalDate paymentDate;
	
	@NotNull
	@Column(name = "pay_amount") 
	private Double amount;
	
	//CONSTRUCTORES
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(PaymentId id, @NotNull LocalDate paymentDate, @NotNull Double amount) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	//GETTERS & SETTERS
	public PaymentId getId() {
		return id;
	}

	public void setId(PaymentId id) {
		this.id = id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
