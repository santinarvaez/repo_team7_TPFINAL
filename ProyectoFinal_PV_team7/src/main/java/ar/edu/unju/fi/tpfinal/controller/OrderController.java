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
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {
	
	@Autowired
	@Qualifier("orderMySql")
	private IOrderService orderService;
	
	@GetMapping("/neworder")
	public String getNewOrderPage (Model model) {
		model.addAttribute("order",orderService.getOrder());
		return "neworder";
	}
	
	@PostMapping("/addorder")
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("order")Order order,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("neworder");
			return modelView;
		}else {
			modelView = new ModelAndView("orders");
			orderService.addOrder(order);
			modelView.addObject("orders",orderService.getAllOrders());
			return modelView;
		}
		
	}
	
	@GetMapping("/orderlist")
	public ModelAndView getOrderListadoPage() {
		ModelAndView model = new ModelAndView("orders");
		model.addObject("orders", orderService.getAllOrders());
		return model;
	}
	
}
