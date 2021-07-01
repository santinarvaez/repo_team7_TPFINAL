package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerService {
	public void addCustomer(Customer customer);
	public Customer getCustomer();
	public List<Customer> getAllCustomers();
	public Customer findCustomer(Long id);
	public void eliminar(Long id);

}
