package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailRepository extends CrudRepository <OrderDetail, Long>{

}
