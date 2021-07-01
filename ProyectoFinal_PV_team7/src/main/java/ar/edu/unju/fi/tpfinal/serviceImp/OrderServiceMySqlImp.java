package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderMySql")
public class OrderServiceMySqlImp implements IOrderService {
	
	@Autowired
	private Order order;
	
	@Autowired
	private IOrderRepository orderRepository;
	

	@Override
	public void addOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public Order getOrder() {
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}

	@Override
	public Order findOrder(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	@Override
	public Optional<Order> orderForId(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order;
	}

}
