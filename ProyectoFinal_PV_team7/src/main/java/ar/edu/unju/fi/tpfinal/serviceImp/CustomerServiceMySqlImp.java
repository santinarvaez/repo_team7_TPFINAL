package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;

@Service("customerMySql")
public class CustomerServiceMySqlImp implements ICustomerService {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer findCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

}
