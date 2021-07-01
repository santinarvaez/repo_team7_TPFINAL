package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Table(name = "CUSTOMERS")
@Entity
@Component
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "cu_Number")
	private Long customerNumber;
	
	@NotEmpty(message = "Ingrese un nombre de empresa")
	@Column(name = "cu_Name")
	private String customerName;
	
	@NotEmpty(message = "Ingrese un apellido")
	@Column(name = "cu_lstName")
	private String customerLastName;
	
	@NotEmpty(message = "Ingrese un nombre")
	@Column(name = "cu_fstName")
	private String customerFirstName;
	
	@NotNull
	@Column(name = "cu_phone", length = 60)
	private String phone;
	
	@NotEmpty(message = "Ingrese una direccion")
	@Column(name = "cu_address1")
	private String address1;
	
	@Column(name = "cu_address2")
	private String address2;
	
	@NotEmpty(message = "Ingrese una ciudad válida")
	@Column(name = "cu_city")
	private String city;
	
	@Column(name = "cu_state")
	private String state;
	
	@Column(name = "cu_postalCode")
	private String postalCode;
	
	
	@NotEmpty(message = "Ingrese un país válida")
	@Column(name = "cu_country")
	private String country;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cu_salesRepEmployeeNumber")
	private Employee salesRepEmployeeNumber;

	@Column(name = "cu_creditLimit")
	private Double creditLimit;
	
	
	@Column(name = "cu_estado")
	@NotNull
	private Boolean estado = true;
	
	//CONSTRUCTORES
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(Long customerNumber, @NotEmpty(message = "Ingrese un nombre de empresa") String customerName,
			@NotEmpty(message = "Ingrese un apellido") String customerLastName,
			@NotEmpty(message = "Ingrese un nombre") String customerFirstName, @NotNull String phone,
			@NotEmpty(message = "Ingrese una direccion") String address1, String address2,
			@NotEmpty(message = "Ingrese una ciudad válida") String city, String state, String postalCode,
			@NotEmpty(message = "Ingrese un país válida") String country, Employee salesRepEmployeeNumber,
			Double creditLimit, Boolean estado) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerLastName = customerLastName;
		this.customerFirstName = customerFirstName;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
		this.estado = estado;
	}



	//GETTERS AND SETTERS

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Employee getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(Employee salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}


	public Boolean isEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
}
