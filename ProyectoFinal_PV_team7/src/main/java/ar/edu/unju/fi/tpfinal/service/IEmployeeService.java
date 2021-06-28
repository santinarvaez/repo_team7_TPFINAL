package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {
		public void addEmployee(Employee employee);
		public Employee getEmployee();
		public List<Employee> getAllEmployees();
		public Employee findEmployee(Integer id);
}
