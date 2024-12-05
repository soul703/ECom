package org.example.sangecom.service;


import org.example.sangecom.entity.OrderRequest;
import org.example.sangecom.entity.ProductOrder;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

	public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

	public List<ProductOrder> getOrdersByUser(Integer userId);

	public ProductOrder updateOrderStatus(Integer id, String status);

	public List<ProductOrder> getAllOrders();

	public ProductOrder getOrdersByOrderId(String orderId);
	
	public Page<ProductOrder> getAllOrdersPagination(Integer pageNo,Integer pageSize);
}
