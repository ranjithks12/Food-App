package com.app.dao;

import java.sql.Connection;

import com.app.model.OrderItem;

public interface OrderItemDAO {
	
	int saveOrderItem(OrderItem orderItem, Connection connection);

}
