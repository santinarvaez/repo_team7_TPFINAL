package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	public void addProductLine(ProductLine productLine);
	public ProductLine getProductLine();
	public List<ProductLine> getAllProductLines();
	public Optional <ProductLine> getProductLineForId(String id);
	public void eliminarProductLine(String id);	
	public ProductLine findProductLine(String id);

}
