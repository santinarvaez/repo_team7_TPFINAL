package ar.edu.unju.fi.tpfinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;


@Controller
public class CustomerController {
	
	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);

	
	@Autowired
	@Qualifier("customerMySql")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier("employeeMySql")
	private IEmployeeService employeeService;
	
	
	@GetMapping("/newcustomer")
	public String getNewCustomerPage(Model model) {
		model.addAttribute("customer",customerService.getCustomer());
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "newcustomer";
	}
	
	
	@PostMapping("/addcustomer")
	public ModelAndView guardarCustomerPage(@Valid @ModelAttribute("customer")Customer customer,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true){
			modelView = new ModelAndView("newcustomer");
			return modelView;
			
		}else {
			modelView = new ModelAndView("customers");
			customerService.addCustomer(customer);
			List<Customer> customers = new ArrayList<Customer>();
			for(Customer c: customerService.getAllCustomers()){
				if(c.isEstado()==true)
					customers.add(c);
				
			}
			modelView.addObject("customers",customers);
			return modelView;
			
		}
	
	}
	
	/**
	 * METODO PARA LISTAR CUSTOMERS ACTIVOS
	 * @param model
	 * @return
	 */
	
	@GetMapping("/customerlist")
	public String getCustomerListadoPage(Model model){
		
		List<Customer> customers = new ArrayList<Customer>();
		for(Customer c: customerService.getAllCustomers()){
			if(c.isEstado()==true)
				customers.add(c);
			
		}
		model.addAttribute("customers",customers);
		return "customers";
		
	}
	
	@GetMapping("/custoedit/{id}")
	public String getCustoEditPage(@PathVariable(name="id") Long id, Model model) {
		Customer customer = customerService.findCustomer(id);
		model.addAttribute("employees",employeeService.getAllEmployees());
		model.addAttribute("customer",customer);
		
		return"newcustomer";
	}
	
	@GetMapping("/rmcustomer/{id}")
	public String eliminarCustomer(Model model,@PathVariable(value ="id")Long id) {
		try {
			customerService.eliminar(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/customerlist";
	}

}
