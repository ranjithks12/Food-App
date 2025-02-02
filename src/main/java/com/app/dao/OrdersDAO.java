package com.app.dao;

import java.util.List;

import com.app.model.Orders;

public interface OrdersDAO {
	int saveOrder(Orders orders);
	
	List<Orders> getAllOrders();
	
	List<Orders> getOrdersByUserId(int userId);

}
