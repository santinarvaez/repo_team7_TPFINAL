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
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {

	@Autowired
	@Qualifier("paymentMySql")
	private IPaymentService paymentService;
	
	@Autowired
	@Qualifier("customerMySql")
	private ICustomerService customerService;
	
	@GetMapping("/newpayment")
	public String getNewPaymentPage(Model model) {
		model.addAttribute("payment",paymentService.getPayment());
		model.addAttribute("customers",customerService.getAllCustomers());
		return "newpayment";
	}
	
	@PostMapping("/addpayment")
	public ModelAndView guardarPagoPage(@Valid @ModelAttribute("payment")Payment payment,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("newpayment");
			return modelView;
		}else {
			modelView = new ModelAndView("payments");
			paymentService.addPayment(payment);
			modelView.addObject("payments",paymentService.getAllPayments());
			return modelView;
		}
		
	}
	
	@GetMapping("/paymentlist")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("payments");
		model.addObject("payments",paymentService.getAllPayments());
		return model;
	}
	
}
