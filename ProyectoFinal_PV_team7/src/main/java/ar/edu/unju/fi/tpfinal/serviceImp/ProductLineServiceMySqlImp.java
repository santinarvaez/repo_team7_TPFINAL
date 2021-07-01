package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.controller.ProductLineController;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Service("productLineMysql")
public class ProductLineServiceMySqlImp implements IProductLineService {

	private static final Log LOGGER = LogFactory.getLog(ProductLineController.class);

	
	@Autowired
	private ProductLine productLine;
	
	@Autowired
	private IProductLineRepository productLineRepository;
	
	@Override
	public void addProductLine(ProductLine productLine) {
		productLineRepository.save(productLine);
	}

	@Override
	public ProductLine getProductLine() {
		return productLine;
	}

	@Override
	public List<ProductLine> getAllProductLines() {
		List<ProductLine> productLines = (List<ProductLine>) productLineRepository.findAll();
		return productLines;
	}

	@Override
	public Optional<ProductLine> getProductLineForId(String id) {
		Optional <ProductLine> productLine = productLineRepository.findById(id);
		return productLine;
	}

	@Override
	public void eliminarProductLine(String id) {
		productLineRepository.deleteById(id);
	}

	@Override
	public ProductLine findProductLine(String id) {
		return productLineRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(String id)  {
		ProductLine productLine = findProductLine(id);
		productLine.setEstado(false);
		productLineRepository.save(productLine);
	}
	
	@Override//BUGEADO
	public Iterable<ProductLine> listarProductLines(boolean estado) throws Exception {
		Iterable <ProductLine> listaProductLines = productLineRepository.findEstadoById(estado);
		if(!listaProductLines.iterator().hasNext()) {
			throw new Exception("Lista Vacia ");
		}
		return listaProductLines; 
	}
	
	@Override//BUGEADO
	public List<ProductLine> filtrarProductLines(boolean estado) throws Exception{
		List<ProductLine> productLines = new ArrayList <ProductLine>();
		return productLines;
	}

}
