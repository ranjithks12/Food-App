package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.daoimpl.AddresseDAOImpl;
import com.app.model.Address;
import com.app.model.User;

@SuppressWarnings("serial")
@WebServlet("/addAddress")
public class AddAddress extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddresseDAOImpl address = new AddresseDAOImpl();
		User loggedUser = (User) req.getSession().getAttribute("loggedUser");
		Address userAddress = new Address(loggedUser.getUser_id(), req.getParameter("Area"), req.getParameter("Street"),
				req.getParameter("landmark"), req.getParameter("City&State"), 
				Integer.parseInt(req.getParameter("PostalCode")));		
		int status = address.addAddress(userAddress);
		if(status == 1) {
			resp.sendRedirect(req.getContextPath() + "/checkout");
		} else {
			resp.sendRedirect("error.jsp");
		}
	}
}
