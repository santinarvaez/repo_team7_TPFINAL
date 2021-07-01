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
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductList;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class OrderDetailController {
	
	
	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);

	
	@Autowired
	@Qualifier("orderDetailMySql")
	private IOrderDetailService orderDetailService;
	
	@Autowired
	@Qualifier("productMySql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("orderMySql")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("customerMySql")
	private ICustomerService customerService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private Payment payment;
	
	
	@Autowired
	private Order order;
	
	@Autowired
	private ProductList productList;
		
	
	@GetMapping("/neworderds")
	public String getNewOrderDetailPage (Model model) {
		model.addAttribute("orderDetail",orderDetailService.getOrderDetail());
		model.addAttribute(order);
		model.addAttribute("productList",productList);
		List<Customer> customers= new ArrayList<Customer>();
		for(Customer c: customerService.getAllCustomers()) {
			if(c.isEstado()==true)
				customers.add(c);
		}
		model.addAttribute("customers",customers);
		model.addAttribute("employees",employeeService.getAllEmployees());
		model.addAttribute("products",productService.getAllProducts());
		
		return "neworderdetail";
	
	}
	
	
	@PostMapping("/addorderds")
	public String getOrderDetailPage(@ModelAttribute("orderDetail") OrderDetail orderDetail,@Valid  @ModelAttribute("order") Order order,BindingResult resultadoValidacion,@ModelAttribute("productList") ProductList productList,Model model) {
		double amount=0;
				
		if(resultadoValidacion.hasErrors()==true) {
			model.addAttribute(orderDetail);
			model.addAttribute(order);
			model.addAttribute("productList",productList);
			List<Customer> customers= new ArrayList<Customer>();
			for(Customer c: customerService.getAllCustomers()) {
				if(c.isEstado()==true)
					customers.add(c);
			}
			LOGGER.info("*********************");
			LOGGER.info("llego aqui");
			model.addAttribute("customers", customers);
			model.addAttribute("employees",employeeService.getAllEmployees());
			model.addAttribute("products",productService.getAllProducts());
			return "neworderdetail";
			
		}else {
			LOGGER.info("ELSE");
			orderService.addOrder(order);
			for(Product p: productList.getProducts()) {
				LOGGER.info("PRODUCTO->"+p.getProductName());
				orderDetail.setId(new OrderDetailId(p,order));
				orderDetail.setPriceEach(orderDetail.getId().getProductCode().getBuyPrice()*orderDetail.getQuantityOrdered());
				orderDetailService.addOrderDetail(orderDetail);
				amount+=orderDetail.getPriceEach()*orderDetail.getQuantityOrdered();
			}
		}
		/**
		 * employee customer
		 * BUGS*
		 */
		Employee employee = employeeService.findEmployee(orderDetail.getId().getOrderNumber().getCustomer().getSalesRepEmployeeNumber().getEmployeeNumber());
		Customer customer = customerService.findCustomer(orderDetail.getId().getOrderNumber().getCustomer().getCustomerNumber());
		LOGGER.info("cliente "+customer.getCustomerNumber());

		customer.setSalesRepEmployeeNumber(employee);
		customerService.addCustomer(customer);
		/**
		 * payment
		 */
		model.addAttribute(payment);
		model.addAttribute("amount",amount);
		model.addAttribute("customer",customer);
		LOGGER.info("monto controlador order detail "+amount);
		LOGGER.info("cliente controla detail "+orderDetail.getId().getOrderNumber().getCustomer().getCustomerNumber());
		LOGGER.info("cliente "+customer.getCustomerNumber());

		return "newpayment";
	}
	
	
	
	@GetMapping("/orderdslist")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("orderdetails");
		model.addObject("orderDetails", orderDetailService.getAllOrderDetails());
		return model;
	}
	
	
	
	@GetMapping("/rmorderds/{id}")//bug
	public String eliminarOrderDs(Model model,@PathVariable (value = "id")Long id) {
		try {
			orderDetailService.eliminarOrderDetailByOrderId(id);
		}catch(Exception e) {
				model.addAttribute("listErrorMessage",e.getMessage());
		}
		return "redirect:/orderdslist";
	}

	
	/*@GetMapping("/plinedit/{id}")
	public String getProductLineEditPage (@PathVariable(name="id") String id, Model model) {
		
		ProductLine prodLine = productLineService.findProductLine(id);
		model.addAttribute("productLine", prodLine);
		
		return "newproductline";
	}*/
	
}
