package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderRepository extends CrudRepository <Order, Long>{

}
