package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {
	public void addOrder(Order order);
	public Order getOrder();
	public List<Order> getAllOrders();
	public Order findOrder(Long id);
	public Optional<Order> orderForId(Long id);
}
