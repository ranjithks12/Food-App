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
import com.app.daoimpl.UserDaoImplementation;
import com.app.model.Restaurant;
import com.app.model.User;
import com.app.util.EncryptDecrypt;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static UserDaoImplementation userObj; 
	private static RestaurantDAOImplementation implObj;
	
	@Override
	public void init() throws ServletException {
		userObj = new UserDaoImplementation();
		implObj = new RestaurantDAOImplementation();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password =  req.getParameter("password");
		String redirectUrl = req.getParameter("redirectUrl");
		User user = userObj.fetchUserByUsername(username);
		
		if(user != null) {
			if(password.equals(EncryptDecrypt.decrypt(user.getPassword()))) {
				if(req.getParameter("adminLogin") != null) {
					boolean hasAdminAccess = userObj.hasAdminAccess(user);
					if(hasAdminAccess) {
						session.setAttribute("loggedAdminUser", user);
						session.setAttribute("message", "Admin Login Successfull");
						session.setAttribute("displayPopup", true);
						if(session.getAttribute("restaurantList") == null) {
							List<Restaurant> restaurantList = implObj.getAllRestaurants();
							session.setAttribute("restaurantList", restaurantList);
						}
						resp.sendRedirect("adminDashboard.jsp");
						return;
					}
				}
				session.setAttribute("loggedUser", user);
				session.setAttribute("message", "User Login Successfull");
				session.setAttribute("displayPopup", true);
				resp.getWriter().write("User Logged Successfully");
				if(redirectUrl.contains("OrderConfirmation")) {
					session.setAttribute("message", "User Login Successfull");
					session.setAttribute("displayPopup", true);
					req.getRequestDispatcher("/checkout").forward(req, resp);
				} else {
					resp.sendRedirect(redirectUrl);
				}
			}
			else {
				session.setAttribute("message", "Something Error happend");
				session.setAttribute("displayPopup", true);
				resp.sendRedirect(redirectUrl);
			}
		} else {
			session.setAttribute("message", "No User Found with the details");
			session.setAttribute("displayPopup", true);
			resp.sendRedirect(redirectUrl);
		}
		
	}

}
