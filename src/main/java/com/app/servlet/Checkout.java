package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.PaymentMethodDAO;
import com.app.daoimpl.AddresseDAOImpl;
import com.app.daoimpl.PaymentMethodDAOImpl;
import com.app.model.Address;
import com.app.model.PaymentMethod;
import com.app.model.User;

@SuppressWarnings("serial")
@WebServlet("/checkout")
public class Checkout extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(req.getParameter("totalAmount") != null) {
			float totalAmount = Float.parseFloat(req.getParameter("totalAmount"));
			session.setAttribute("totalAmount", totalAmount);
		}
		User loggedUser = (User) req.getSession().getAttribute("loggedUser");
		PaymentMethodDAO paymentDAO = new PaymentMethodDAOImpl();
		AddresseDAOImpl addressDao = new AddresseDAOImpl();
		List<PaymentMethod> allpaymentMethods = paymentDAO.getAllpaymentMethods();
		if(loggedUser != null) {
			List<Address> addresses = addressDao.getAddresseByUserId(loggedUser.getUser_id());
			session.setAttribute("addresses", addresses);
		}
		session.setAttribute("paymentmethods", allpaymentMethods);
		resp.sendRedirect("OrderConfirmation.jsp");
	}

}
