package ar.edu.unju.fi.tpfinal.model;

/*import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;*/
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

@Table( name = "EMPLOYEES")
@Component
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_number")
	private Integer employeeNumber;
	
	@NotEmpty(message = "Ingrese un nombre")
	@Column(name = "em_lastname")
	private String lastName;
	
	@NotEmpty(message = "Ingrese un nombre")
	@Column(name = "em_firstname")
	private String firstName;
	
	@NotNull(message = "Este campo no puede estar vacio")
	@Column(name = "em_extension")
	private String extension;
	
	@NotNull
	@Column(name = "em_email")
	private String email;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "of_code")
	private Oficce officeCode;
	
	@NotNull
	@Column(name = "em_jobtitle")
	private String jobTitle;
	
	/**
	 * Relación de supervisor con uno o más empleados.
	 */
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "em_reportsto",referencedColumnName = "em_number")
	private Employee reportsTo;
	
	//CONSTRUCTORES
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employeeNumber, @NotEmpty(message = "Ingrese un nombre") String lastName,
			@NotEmpty(message = "Ingrese un nombre") String firstName,
			@NotNull(message = "Este campo no puede estar vacio") String extension, @NotNull String email,
			Oficce officeCode, @NotNull String jobTitle, Employee reportsTo) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
	}

	//GETTERS & SETTERS
	
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Employee getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}
	
	
}
