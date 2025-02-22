package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.OrderItemDAO;
import com.app.model.OrderItem;
import com.app.util.MyConnector;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	private static final String SAVE_ORDERITEM = "INSERT INTO `ORDERITEM`(`ORDERID`, `MENUID`, `ITEMNAME`, `QUANTITY`, `SUBTOTAL`)"
			                                     + " VALUES(?, ?, ?, ?, ?)";
	
	private static final String GET_ORDER_ITEMS = "SELECT * FROM `ORDERITEM` WHERE `ORDERID` IN (SELECT `ORDERID` FROM `ORDERS` WHERE `USERID`= ?)"	;

	@Override
	public int saveOrderItem(OrderItem orderItem, Connection connection) {
		int result = 0;
		try {
			PreparedStatement pstatement = connection.prepareStatement(SAVE_ORDERITEM);
			pstatement.setString(1, orderItem.getOrderId());
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
	
	public List<OrderItem> getAllOrderedItemsForUser(int userId) {
		ArrayList<OrderItem> arrayList = new ArrayList<OrderItem>();
		
		try {
			Connection connection = MyConnector.getMyConnector().connect();
			PreparedStatement pstatement = connection.prepareStatement(GET_ORDER_ITEMS);
			pstatement.setInt(1, userId);
			ResultSet ordersItems = pstatement.executeQuery();
			while(ordersItems.next()) {
				arrayList.add(new OrderItem(ordersItems.getInt("orderItemId"), ordersItems.getString("orderId"),
						ordersItems.getInt("menuId"), ordersItems.getString("itemName"), ordersItems.getInt("quantity"),
						ordersItems.getFloat("subTotal")));
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
