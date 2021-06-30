package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;


@Controller
public class CustomerController {
	
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
			modelView.addObject("customers",customerService.getAllCustomers());
			return modelView;
			
		}
	
	}
	
	
	@GetMapping("/customerlist")
	public ModelAndView getCustomerListadoPage(){
		ModelAndView model = new ModelAndView("customers");
		model.addObject("customers", customerService.getAllCustomers());
		return model;
		
	}

}
