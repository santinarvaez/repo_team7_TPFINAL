package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeMySql")
public class EmployeeServiceMySqlImp implements IEmployeeService {
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee() {
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List <Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findEmployee(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}

	

}
