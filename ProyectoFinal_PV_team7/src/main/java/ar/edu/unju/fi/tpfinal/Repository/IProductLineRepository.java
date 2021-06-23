package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineRepository extends CrudRepository <ProductLine, String> {

}
