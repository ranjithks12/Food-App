package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.daoimpl.UserDaoImplementation;
import com.app.model.User;
import com.app.util.EncryptDecrypt;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = EncryptDecrypt.encrypt(req.getParameter("password"));
		Long phonenumber =Long.parseLong(req.getParameter("phonenumber"));
		String email = req.getParameter("email");
		
		User user = new User(username, password	, phonenumber, email);
		UserDaoImplementation userDao = new UserDaoImplementation();
		int status = userDao.addUser(user);
		if(status != 0) {
			req.getSession().setAttribute("showLoginPopup", true);
			resp.sendRedirect("home.jsp");
		}
		else {
			resp.sendRedirect("error.jsp");
		}
	}
}
