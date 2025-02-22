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

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password =  req.getParameter("password");
		String redirectUrl = req.getParameter("redirectUrl");
		
		UserDaoImplementation userDao = new UserDaoImplementation();
		User user = userDao.fetchUserByUsername(username);
		if(user != null) {
			if(password.equals(EncryptDecrypt.decrypt(user.getPassword()))) {
				HttpSession session = req.getSession();
				session.setAttribute("loggedUser", user);
				resp.getWriter().write("User Logged Successfully");
				resp.sendRedirect(redirectUrl);
			}
			else {
				resp.sendRedirect("error.jsp");
			}
		} else {
			resp.getWriter().write("No user Found..! Please Register");
		}
		
	}

}
