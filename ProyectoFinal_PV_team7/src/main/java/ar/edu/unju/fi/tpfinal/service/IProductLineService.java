package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	public void addProductLine(ProductLine productLine);
	public ProductLine getProductLine();
	public List<ProductLine> getAllProductLines();
	public ProductLine getProductLineForId(String id);
	public void eliminarProductLine(String id);	
}
