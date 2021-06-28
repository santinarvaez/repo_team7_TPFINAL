package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentService {
	public void addPayment(Payment payment);
	public Payment getPayment();
	public List<Payment> getAllPayments();
	public Payment findPayment(Customer customer,String checkNumber);
}
