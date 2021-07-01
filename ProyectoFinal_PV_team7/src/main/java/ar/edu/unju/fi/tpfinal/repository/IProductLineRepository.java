package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineRepository extends CrudRepository<ProductLine,String> {
	public List <ProductLine> findEstadoById(boolean estado);
}
