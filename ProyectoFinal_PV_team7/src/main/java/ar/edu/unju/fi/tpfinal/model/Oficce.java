package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Table(name = "OFICCES")
@Component
@Entity
public class Oficce {
	
	@Id
	@Column(name = "of_code")
	private Integer officeCode;
	
	@NotEmpty(message = "Ingrese un nombre de ciudad")
	@Column(name = "of_city")
	private String city;
	
	@NotEmpty(message = "Ingrese un telefono")
	@Column(name = "of_phone")
	private String phone;
	
	@NotEmpty(message = "Ingrese una dirección válida")
	@Column(name = "of_addressline1")
	private String addressline1;
	
	@Column(name = "of_addressline2")
	private String addressline2;
	
	@Column(name = "of_state")
	private String state;
	
	@Column(name = "of_country")
	private String country;
	
	@Column(name = "of_postalCode")
	private String postalCode;
	
	@Column(name = "of_territory")
	private String territory;
	

	//CONSTRUCTORES
	
	public Oficce() {
	}
	
	public Oficce(Integer officeCode, @NotEmpty(message = "Ingrese un nombre de ciudad") String city,
			@NotEmpty(message = "Ingrese un telefono") String phone,
			@NotEmpty(message = "Ingrese una dirección válida") String addressline1, String addressline2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}



	//GETTERS & SETTERS 

	public Integer getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	
	
}
