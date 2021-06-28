package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentMySql")
public class PaymentServiceMySqlImp implements IPaymentService {
	
	@Autowired
	private Payment payment;
	
	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public void addPayment(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public Payment getPayment() {
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = (List<Payment>) paymentRepository.findAll();
		return payments;
	}

	@Override
	public Payment findPayment(Customer customer, String checkNumber) {
		return paymentRepository.findById(new PaymentId(customer,checkNumber)).orElse(null);
	}

}
