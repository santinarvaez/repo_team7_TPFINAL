package ar.edu.unju.fi.tpfinal.controller;

import java.util.ArrayList;
import java.util.List;
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
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productMySql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("productLineMysql")
	private IProductLineService productLineService;
	
	/**
	 * 
	 * Controlador para la pagina de alta de un producto
	 * 
	 */
	
	
	@GetMapping("/pnew")
	public String getNewProductLinePage(Model model) {
	model.addAttribute("product",productService.getProduct());
	List<ProductLine> productLines = new ArrayList<ProductLine>();
	for(ProductLine p: productLineService.getAllProductLines()) {
		if(p.isEstado()==true)
			productLines.add(p);
	}
	model.addAttribute("productLine",productLines);
	return "newproduct";
	}
	
	/**
	 * 
	 * Controlador para el post de alta de un producto 
	 * 
	 */
	
	
	@PostMapping("/addp")
	public ModelAndView guardarProductoLinePage(@Valid @ModelAttribute("product")Product product,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true){
			modelView = new ModelAndView("newproduct");
			List <Product> products = productService.getAllProducts();
			modelView.addObject("products",products);
			return modelView;
			
		}else {
			modelView = new ModelAndView("products");
			productService.addProduct(product);
			modelView.addObject("products",productService.getAllProducts());
			return modelView;
		}
		
	}
	
	
	/**
	 * 
	 * Controlador para listar productos
	 * 
	 */
	
	@GetMapping("/plist")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("products");
		model.addObject("products", productService.getAllProducts());
		return model;
	}

}
