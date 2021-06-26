package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Service("productMySql")
public class ProductServiceMySqlImp implements IProductService{
	
	@Autowired
	private Product product;
	
	@Autowired
	private IProductRepository IProductRepository;


	@Override
	public void addProduct(Product product) {
		IProductRepository.save(product);
	}

	@Override
	public Product getProduct() {
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) IProductRepository.findAll();
		return products;
	}

	@Override
	public Optional<Product> getProductForId(String id) {
		Optional<Product> products = IProductRepository.findById(id);
		return products;
	}

	@Override
	public void eliminarProductLine(String id) {
		IProductRepository.deleteById(id);
		
	}
	

}
