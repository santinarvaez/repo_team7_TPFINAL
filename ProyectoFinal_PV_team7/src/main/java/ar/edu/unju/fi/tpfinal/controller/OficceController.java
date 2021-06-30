package ar.edu.unju.fi.tpfinal.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpfinal.model.Oficce;
import ar.edu.unju.fi.tpfinal.service.IOficceService;

@Controller
public class OficceController {
	
	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);


	@Autowired
	@Qualifier("oficceMySql")
	private IOficceService oficceService;
	
	@GetMapping("newoficce")
	public String getNewOficcePage (Model model) {
		model.addAttribute("oficce",oficceService.getOficce());
		return "newoficce";
	}
	
	@PostMapping("/addoficce")
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("oficce")Oficce oficce,BindingResult resultadoValidacion) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true) {
			LOGGER.info("DIO ERROR->>"+oficce.getCity());

			modelView = new ModelAndView("newoficce");
			return modelView;
		}else {
			modelView = new ModelAndView("oficces");
			oficceService.addOficce(oficce);
			LOGGER.info("oficce->>"+oficce.getCity());
			modelView.addObject("oficces",oficceService.getAllOficces());
			return modelView;
		}
		
	}
	
	@GetMapping("/oficcelist")
	public ModelAndView getOficceListadoPage() {
		ModelAndView model = new ModelAndView("oficces");
		model.addObject("oficces", oficceService.getAllOficces());
		return model;
	}
	
}
