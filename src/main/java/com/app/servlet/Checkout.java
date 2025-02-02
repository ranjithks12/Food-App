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
import com.app.daoimpl.PaymentMethodDAOImpl;
import com.app.model.PaymentMethod;

@SuppressWarnings("serial")
@WebServlet("/checkout")
public class Checkout extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		float totalAmount = Float.parseFloat(req.getParameter("totalAmount"));
		
		PaymentMethodDAO paymentDAO = new PaymentMethodDAOImpl();
		List<PaymentMethod> allpaymentMethods = paymentDAO.getAllpaymentMethods();
		HttpSession session = req.getSession();
		session.setAttribute("totalAmount", totalAmount);
		session.setAttribute("paymentmethods", allpaymentMethods);
		resp.sendRedirect("OrderConfirmation.jsp");
	}

}
