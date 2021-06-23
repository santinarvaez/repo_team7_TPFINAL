package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.PaymentId;

public interface IPaymentIDRepository extends CrudRepository <PaymentId, Long> {

}
