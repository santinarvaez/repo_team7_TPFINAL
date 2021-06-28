package ar.edu.unju.fi.tpfinal.service;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {
	public void addProduct(Product product);
	public Product getProduct();
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public Optional <Product> getProductForId(String id);
	public void eliminarProductLine(String id);	
}
