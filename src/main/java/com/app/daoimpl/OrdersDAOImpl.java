package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.app.dao.OrdersDAO;
import com.app.model.Orders;
import com.app.util.GenerateOrderId;
import com.app.util.MyConnector;

public class OrdersDAOImpl implements OrdersDAO {
	private static final String SAVE_ORDER = "INSERT INTO `ORDERS`(`ORDERID`, `USERID`, `RESTAURANTID`, "
											+ " `PAYMENTMETHOD`, `PAYEDAMOUNT`) VALUES(?, ? ,? ,?, ?)";
	private static final String FETCH_ALL_ORDERS = "SELECT * FROM `ORDERS`";
	private static final String FETCH_ORDERS_BY_USERID = "SELECT `ORDERID` FROM `ORDERS` WHERE `USERID`=?";
	MyConnector myConnector = null;
	Connection connection = null;
	PreparedStatement pstatement = null;

	public static String ORDERID = "";
	public OrdersDAOImpl() {
		ORDERID =  GenerateOrderId.generatOrderId().trim();
	}
	
	@Override
	public int saveOrder(Orders order, Connection connection) {
		int result = 0;
		try {
			pstatement = connection.prepareStatement(SAVE_ORDER);
			pstatement.setString(1, ORDERID);
			pstatement.setInt(2, order.getUserID());
			pstatement.setInt(3, order.getRestaurentId());
			pstatement.setString(4, order.getPaymentMethod());
			pstatement.setFloat(5, order.getPayedAmount());
			result = pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	@Override
	public List<Orders> getAllOrders() {

		return null;
	}

	@Override
	public List<Orders> getOrdersByUserId(int userId) {
		return null;
	}


}
