package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	public void addProductLine(ProductLine productLine);
	public ProductLine getProductLine();
	public List<ProductLine> getAllProductLines();
	public Optional <ProductLine> getProductLineForId(String id);//No testeado
	public void eliminarProductLine(String id);	//No testeado
	public ProductLine findProductLine(String id);
	public void eliminar (String id);
	public Iterable<ProductLine> listarProductLines(boolean estado) throws Exception;//bug
	public List<ProductLine> filtrarProductLines(boolean estado) throws Exception;//bug
}
