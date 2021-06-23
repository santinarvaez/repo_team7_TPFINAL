package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentRepository extends CrudRepository <Payment, Integer>{

}
