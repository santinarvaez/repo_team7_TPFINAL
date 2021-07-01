package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;
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

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class OrderDetailController {
	
	@Autowired
	@Qualifier("orderDetailMySql")
	private IOrderDetailService orderDetailService;
	
	@Autowired
	@Qualifier("productMySql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("orderMySql")
	private IOrderService orderService;
	
	
	@GetMapping("/neworderds")
	public String getNewOrderDetailPage (Model model) {
		model.addAttribute("orderDetail",orderDetailService.getOrderDetail());
		model.addAttribute("orders",orderService.getAllOrders());
		model.addAttribute("products",productService.getAllProducts());
		return "neworderdetail";
	
	}
	
	
	@PostMapping("/addorderds")
	public ModelAndView guardarOrderDetailPage(@Valid @ModelAttribute("orderDetail")OrderDetail orderDetail,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true) {
			modelView = new ModelAndView("neworderdetail");
			modelView.addObject("orders",orderService.getAllOrders());
			modelView.addObject("products",productService.getAllProducts());
			return modelView;
		}else {
			modelView = new ModelAndView("orderdetails");
			orderDetailService.addOrderDetail(orderDetail);
			modelView.addObject("orderDetails",orderDetailService.getAllOrderDetails());
			return modelView;
		}
	
	}
	
	@GetMapping("/orderdslist")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("orderdetails");
		model.addObject("orderDetails", orderDetailService.getAllOrderDetails());
		return model;
	}
	
	
	
/*	@GetMapping("/rmorderds/{id}-{id2}")//bug
	public String eliminarOrderDs(Model model, @PathVariable(value ="id")Product  id,@PathVariable(value="id2")Order ornumber) {
		try {
			   orderDetailService.eliminar(ornumber, id);
		}catch(Exception e) {
				model.addAttribute("listErrorMessage",e.getMessage());
		}
		return "redirect:/orderdslist";
	}
*/
	
	/*@GetMapping("/plinedit/{id}")
	public String getProductLineEditPage (@PathVariable(name="id") String id, Model model) {
		
		ProductLine prodLine = productLineService.findProductLine(id);
		model.addAttribute("productLine", prodLine);
		
		return "newproductline";
	}*/
	
}
