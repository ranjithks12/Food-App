package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.daoimpl.RestaurantDAOImplementation;
import com.app.model.Restaurant;

@SuppressWarnings("serial")
@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	private static RestaurantDAOImplementation restaurantObj = null; 
	@Override
	public void init() throws ServletException {
		restaurantObj = new RestaurantDAOImplementation();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchString = req.getParameter("searchString");
		List<Restaurant> restaurantList = restaurantObj.getRestaurantBySearchString(searchString);
		HttpSession session = req.getSession();
		session.removeAttribute("restaurantList");
		session.setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("home.jsp");
	}
}
