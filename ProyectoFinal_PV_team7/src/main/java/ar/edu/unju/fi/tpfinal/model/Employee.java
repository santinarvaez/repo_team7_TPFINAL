package ar.edu.unju.fi.tpfinal.model;

/*import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Table( name = "EMPLOYEES")
@Component
@Entity
public class Employee {

	@Id
	@Column(name = "em_number")
	private Integer employeeNumber;
	
	@Column(name = "em_lastname")
	private String lastName;
	
	@Column(name = "em_firstname")
	private String firstName;
	
	@Column(name = "em_extension")
	private String extension;
	
	@Column(name = "em_email")
	private String email;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "of_code")
	private Oficce officeCode;
	
	@Column(name = "em_jobtitle")
	private String jobTitle;
	
	/**
	 * Relación con de supervisor con un empleado.
	 */
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "em_reportsto",referencedColumnName = "em_number")
	private Employee reportsTo;
	
	//CONSTRUCTORES
	
	public Employee() {
		// TODO Auto-generated constructor stub
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
