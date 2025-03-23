package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.daoimpl.UserDaoImplementation;
import com.app.model.User;
import com.app.util.EncryptDecrypt;

/**
 * This class is will update the existing customer details
 */
@SuppressWarnings("serial")
@WebServlet("/updateProfile")
public class ProfileUpdate extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("username");
		Long phoneNumber = Long.parseLong(req.getParameter("number"));
		String userEmail = req.getParameter("email");
		String newPassword = EncryptDecrypt.encrypt(req.getParameter("password"));
		
		User user = new User();
		user.setUser_id(userId);
		user.setUser_name(userName);
		user.setPassword(newPassword);
		user.setEmail(userEmail);
		user.setPhone_number(phoneNumber);
		
		UserDaoImplementation userImpl = new UserDaoImplementation();
		if(userImpl.updateUser(user) == 1) {
			//Romveing existing loggec user from the session
			req.getSession().removeAttribute("loggedUser");
			//After updating the user details re directed to home page log in again.
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			resp.sendRedirect("error.jsp");
		}
	}
}
