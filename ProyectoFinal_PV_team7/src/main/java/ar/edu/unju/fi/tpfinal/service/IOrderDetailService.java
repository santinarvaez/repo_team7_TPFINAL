package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.Product;

public interface IOrderDetailService {

	public void addOrderDetail(OrderDetail orderDetail);
	public OrderDetail getOrderDetail();
	public List<OrderDetail> getAllOrderDetails();
	public OrderDetail findOrderDetail(Order orderNumber, Product productCode);
	public void eliminar(Order orderNumber,Product productCode);//"SOFT DELETE"
	
}
