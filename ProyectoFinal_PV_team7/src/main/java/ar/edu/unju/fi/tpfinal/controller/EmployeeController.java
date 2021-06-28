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
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOficceService;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeMySql")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("oficceMySql")
	private IOficceService oficceService;
	
	@GetMapping("/newemployee")
	public String getNewEmployeePage (Model model) {
		model.addAttribute("employee",employeeService.getEmployee());
		model.addAttribute("oficces",oficceService.getAllOficces());
		return "newcustomer";
	}
	
	@PostMapping("/addemployee")
	public ModelAndView guardarEmpleadoPage(@Valid @ModelAttribute("employee")Employee employee,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("newemployee");
			return modelView;
		}else {
			modelView = new ModelAndView("employee");
			employeeService.addEmployee(employee);
			modelView.addObject("employees",employeeService.getAllEmployees());
			return modelView;
		}
		
	}
	
	@GetMapping("/employeelist")
	public ModelAndView getEmployeeListadoPage() {
		ModelAndView model = new ModelAndView("employees");
		model.addObject("employees",employeeService.getAllEmployees());
		return model;
	}
}
