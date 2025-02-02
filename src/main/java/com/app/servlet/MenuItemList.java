package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.daoimpl.MenuItemDAOImplementation;
import com.app.daoimpl.RestaurantDAOImplementation;
import com.app.model.MenuItem;
import com.app.model.Restaurant;

@SuppressWarnings("serial")
@WebServlet("/menuItem")
public class MenuItemList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		MenuItemDAOImplementation menuItemDAO = new MenuItemDAOImplementation();
		RestaurantDAOImplementation restaurantDAO = new RestaurantDAOImplementation();
		List<MenuItem> menuItemList = menuItemDAO.getMenuItemById(restaurantId);
		Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
		
		HttpSession session = req.getSession();
		session.setAttribute("menuItemList", menuItemList);
		session.setAttribute("restaurant", restaurant);
		resp.sendRedirect("menuItem.jsp");
		
	}
}
