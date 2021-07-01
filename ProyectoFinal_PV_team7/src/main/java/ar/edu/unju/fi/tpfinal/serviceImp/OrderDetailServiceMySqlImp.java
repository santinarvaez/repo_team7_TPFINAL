package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Service("orderDetailMySql")
public class OrderDetailServiceMySqlImp implements IOrderDetailService {
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private IOrderDetailRepository orderDetailRepository;

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
	}

	@Override
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getAllOrderDetails() {
		List <OrderDetail> orderDetails = (List<OrderDetail>) orderDetailRepository.findAll();
		return orderDetails;
	}

	public OrderDetail findOrderDetail(Order orderNumber, Product productCode) {
		return orderDetailRepository.findById(new OrderDetailId(productCode,orderNumber)).orElse(null);
	}

	@Override
	public void eliminar(Order orderNumber, Product productCode) {  
			OrderDetail orderDetail = findOrderDetail(orderNumber, productCode);
			orderDetail.setEstado(false);
			orderDetailRepository.save(orderDetail);
	}

	@Override
	public void eliminarOrderDetailByOrderId(Long id) {
		List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailRepository.findAll();
		for (int i=0;i<orderDetails.size();i++) {
			OrderDetail registro = orderDetails.get(i);
			if (registro.getId().getOrderNumber().getOrderNumber().compareTo(id) == 0) {
					registro.setEstado(false);
			}		
		}
	}

	@Override
	public OrderDetail findOrderDetail(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
	


