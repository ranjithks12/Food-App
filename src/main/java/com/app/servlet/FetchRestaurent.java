package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.daoimpl.RestaurantDAOImplementation;
import com.app.model.Restaurant;

@SuppressWarnings("serial")
@WebServlet("/home")
public class FetchRestaurent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImplementation restaurantDao = new RestaurantDAOImplementation();
		List<Restaurant> restaurantList = restaurantDao.getAllRestaurants();
		req.getSession().setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("home.jsp");
	}
}
