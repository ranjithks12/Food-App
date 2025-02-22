package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.daoimpl.OrderItemDAOImpl;
import com.app.model.OrderItem;

@SuppressWarnings("serial")
@WebServlet("/orderhistory")
public class OrderHistory extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int userId = Integer.parseInt(req.getParameter("userId"));
		
		OrderItemDAOImpl orderItemImpl = new OrderItemDAOImpl();
		List<OrderItem> allOrderedItemsForUser = orderItemImpl.getAllOrderedItemsForUser(1);
		for(OrderItem singleitem : allOrderedItemsForUser) {
			resp.getWriter().write(singleitem.toString());
		}
		
	}
	
}
