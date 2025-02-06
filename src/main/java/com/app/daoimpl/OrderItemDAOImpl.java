package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.OrderItemDAO;
import com.app.model.OrderItem;
import com.app.util.MyConnector;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	private static final String SAVE_ORDERITEM = "INSERT INTO `ORDERITEM`(`ORDERID`, `MENUID`, `ITEMNAME`, `QUANTITY`, `SUBTOTAL`)"
			                                     + " VALUES(?, ?, ?, ?, ?)";
	private static final String ORDER_ID = OrdersDAOImpl.ORDERID.trim();

	@Override
	public int saveOrderItem(OrderItem orderItem, Connection connection) {
		int result = 0;
		try {
//			MyConnector myConnector = MyConnector.getMyConnector();
//			Connection connection = myConnector.connect();
//			connection.setAutoCommit(false);
			PreparedStatement pstatement = connection.prepareStatement(SAVE_ORDERITEM);
			pstatement.setString(1, ORDER_ID);
			pstatement.setInt(2, orderItem.getMenuId());
			pstatement.setString(3, orderItem.getItemName());
			pstatement.setInt(4, orderItem.getQuantity());
			pstatement.setFloat(5, orderItem.getSubtotal());
			result = pstatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
