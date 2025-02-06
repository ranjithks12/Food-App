package com.app.dao;

import java.sql.Connection;
import java.util.List;

import com.app.model.Orders;

public interface OrdersDAO {
	int saveOrder(Orders orders, Connection connection);
	
	List<Orders> getAllOrders();
	
	List<Orders> getOrdersByUserId(int userId);

}
