package ar.edu.unju.fi.tpfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {
	
	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);

	
	@Autowired
	Payment payment;

	@Autowired
	@Qualifier("paymentMySql")
	private IPaymentService paymentService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@GetMapping("/newpayment")
	public String getNewPaymentPage(Model model) {
		model.addAttribute(payment);
		OrderDetail orderds = orderDetailService.getAllOrderDetails().get(orderDetailService.getAllOrderDetails().size()-1);
		model.addAttribute("amount",orderds.getPriceEach()*orderds.getQuantityOrdered());
		model.addAttribute("customer",orderds.getId().getOrderNumber().getCustomer().getCustomerNumber());
		LOGGER.info("AMOUNT->>>"+orderds.getOrderLineNumber());
		LOGGER.info("AMOUNT->>>"+orderds.getPriceEach()*orderds.getQuantityOrdered());
		return "newpayment";
	}
	
	@PostMapping("/addpayment")
	public String guardarPagoPage(@ModelAttribute("payment")Payment payment,Model model) {
		OrderDetail orderds = orderDetailService.getAllOrderDetails().get(orderDetailService.getAllOrderDetails().size()-1);
		payment.setAmount((double) (orderds.getPriceEach()*orderds.getQuantityOrdered()));
		/***
		 * Asignar n° de cheque
		 */
		if(paymentService.getAllPayments().isEmpty()) {
			payment.getId().setCheckNumber((long) 1);
		}else {
			payment.getId().setCheckNumber(paymentService.getAllPayments().get(paymentService.getAllPayments().size()-1).getId().getCheckNumber()+1);
		}
		
		paymentService.addPayment(payment);
		model.addAttribute("payments",paymentService.getAllPayments());
		return "payments";
	}
	
	@GetMapping("/paymentlist")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("payments");
		model.addObject("payments",paymentService.getAllPayments());
		return model;
	}
	
}
