package ar.edu.unju.fi.tpfinal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductLineController {

	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);
	
	//@Autowired
	//private ProductLine productLine;
	
	@Autowired
	@Qualifier("productMySql")
	private IProductService productService;
	
	@Autowired
	@Qualifier("productLineMysql")
	private IProductLineService productLineService;
	
	@GetMapping("/newpline")
	public String getNewProductLinePage(Model model) {
		model.addAttribute("productLine",productLineService.getProductLine());
		return "newproductline";
	}
	
	@PostMapping("/addpline")
	public ModelAndView guardarProductoLinePage(@Valid @ModelAttribute("productLine")ProductLine productLine,BindingResult resultadoValidacion,@RequestParam("file") MultipartFile imagen) {
		ModelAndView modelView;
		
		if(resultadoValidacion.hasErrors()==true){
			modelView = new ModelAndView("newproductline");
			List<ProductLine> productLines = new ArrayList<ProductLine>();
			for(ProductLine p: productLineService.getAllProductLines()) {
				if(p.isEstado()==true)
					productLines.add(p);
			}
			modelView.addObject("productlines",productLines);
			return modelView;
			
		}
		
			
		/**
		 * GUARDAMOS LA IMAGEN EN IMG
		 */
		
		
		if(!imagen.isEmpty()) {
			LOGGER.info("TAMAÑO DE LA IMAGEN: "+imagen.getSize());
			Path directorioImagenes = Paths.get("src//main//resources//static/img");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte [] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get( rutaAbsoluta +  "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				productLine.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}

		/**
		 * CARGAMOS LA LISTA
		 */
				
			modelView = new ModelAndView("productlines");
			productLineService.addProductLine(productLine);
			List<ProductLine> productLines = new ArrayList<ProductLine>();
			for(ProductLine p: productLineService.getAllProductLines()) {
				if(p.isEstado()==true)
					productLines.add(p);
			}
			modelView.addObject("productLines",productLines);
			LOGGER.info("TAMAÑO DE LA IMAGEN: "+imagen.getSize());
			return modelView;

		
	}


	
	@GetMapping("/plinelist")
	public String getListadoFiltroPage(Model model) {
		List<ProductLine> productLines = new ArrayList<ProductLine>();
		for(ProductLine p: productLineService.getAllProductLines()) {
			if(p.isEstado()==true)
				productLines.add(p);
		}
		model.addAttribute("productLines",productLines);
		return "productlines";	
	}
	
	
	@GetMapping("/plinedit/{id}")
	public String getProductLineEditPage (@PathVariable(name="id") String id, Model model) {
		
		ProductLine prodLine = productLineService.findProductLine(id);
		model.addAttribute("productLine", prodLine);
		
		return "newproductline";
	}
	
	@GetMapping("/rmpline/{id}")
	public String eliminarProductLine(Model model, @PathVariable(value ="id") String id) {
		try {
			productLineService.eliminar(id);
		}catch(Exception e) {
				model.addAttribute("listErrorMessage",e.getMessage());
		}
		return "redirect:/plinelist";
	}
	
	
	@GetMapping("/plinelist2")//NO FUNCIONA *****BUGS*****
	public ModelAndView getListadoPage() throws Exception {
		ModelAndView model = new ModelAndView("productLines");
		try {
		model.addObject("productLines", productLineService.listarProductLines(true));
		}catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	

}
