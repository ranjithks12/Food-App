package com.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.daoimpl.OrderItemDAOImpl;
import com.app.daoimpl.OrdersDAOImpl;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.OrderItem;
import com.app.model.Orders;
import com.app.model.User;
import com.app.util.MyConnector;

@SuppressWarnings("serial")
@WebServlet("/placeorder")
public class PalcedOrder extends HttpServlet {
	MyConnector myConnector = null;
	Connection connection = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loggedUser");
		Cart cartItems = (Cart) session.getAttribute("cart");
		float paybleAmount = (float) (session.getAttribute("totalAmount"));
		String paymentMethod = req.getParameter("dropdown-value");

		OrdersDAOImpl order = new OrdersDAOImpl();
		OrderItemDAOImpl orderItem = new OrderItemDAOImpl();
		Orders orderObject = new Orders();
//		orderObject.setUserID(1);
//		orderObject.setRestaurentId(1);
//		orderObject.setPaymentMethodId(2);
//		orderObject.setPaymentMethod("Cash");
//		orderObject.setPayedAmount(120.09f);
//		
		OrderItem orderItemObj = new OrderItem();
//		orderItemObj.setMenuId(1);
//		orderItemObj.setItemName("Butter Chicken");
//		orderItemObj.setQuantity(3);
//		orderItemObj.setSubtotal(120.0f);

		if (user != null) {
			orderObject.setUserID(user.getUser_id());
		}
		if (cartItems != null) {
			Map<Integer, CartItem> items = cartItems.getItems();
			int restaureantId = items.values().stream().findFirst().map(CartItem::getRestaurantId).orElse(-1);
			orderObject.setRestaurentId(restaureantId);
		}
		if (paymentMethod != null) {
			orderObject.setPaymentMethod(paymentMethod);
		}
		orderObject.setPayedAmount(paybleAmount);

		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			connection.setAutoCommit(false);
			int saveOrderResult = order.saveOrder(orderObject, connection);
			if (saveOrderResult == 1) {
				if (cartItems != null) {
					Map<Integer, CartItem> items = cartItems.getItems();
					boolean allItemsSaved = true;
					for (CartItem item : items.values()) {
						orderItemObj.setMenuId(item.getMenuId());
						orderItemObj.setItemName(item.getName());
						orderItemObj.setQuantity(item.getQuantity());
						orderItemObj.setSubtotal(item.getSubTotal());
						int saveOrderItemReult = orderItem.saveOrderItem(orderItemObj, connection);
						if (saveOrderItemReult != 1) {
							allItemsSaved = false;
							break;
						}
					}
					if (allItemsSaved) {
						connection.commit(); // Commit transaction
						resp.getWriter().write("Order Placed Successfully");
//						resp.sendRedirect("home.jsp");
					} else {
						connection.rollback(); // Rollback if any order item fails
						resp.getWriter().write("Failed to place order. Transaction rolled back.");
					}
					
//				for(CartItem item : items.values()) {
//					cartItems.removeItem(item.getMenuId());
//				}
//					resp.sendRedirect("home.jsp");
				}

//			session.removeAttribute("cart");
			} else {
				connection.rollback(); // Rollback if order insertion fails
		        resp.getWriter().write("Failed to insert order. Transaction rolled back.");
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, null, connection);
		}

	}

}
