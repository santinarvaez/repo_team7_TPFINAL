package ar.edu.unju.fi.tpfinal.controller;

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


import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {

	//@Autowired
	//private ProductLine productLine;
	
	@Autowired
	@Qualifier("productLineMysql")
	private IProductLineService productLineService;
	
	@GetMapping("/pline/nuevo")
	public String getNewProductLinePage(Model model) {
		model.addAttribute("productLine",productLineService.getProductLine());
		return "newproductline";
	}
	
	@PostMapping("/pline/guardar")
	public ModelAndView guardarProductoLinePage(@Valid @ModelAttribute("productLine")ProductLine productLine,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true){
			modelView = new ModelAndView("newproductline");
			List <ProductLine> productLines = productLineService.getAllProductLines();
			modelView.addObject("productlines",productLines);
			return modelView;
			
		}else {
			modelView = new ModelAndView("productlines");
			productLineService.addProductLine(productLine);
			modelView.addObject("productLines",productLineService.getAllProductLines());
			return modelView;
			
		}
		
	}
	
	@GetMapping("/pline/listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("productLines");
		model.addObject("productLines", productLineService.getAllProductLines());
		return model;
	}
	
	
}
