package com.app.servlet;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.daoimpl.PaymentMethodDAOImpl;
import com.app.model.PaymentMethod;

@SuppressWarnings("serial")
@WebServlet("/paymentMethod")
public class PaymentMethodList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PaymentMethodDAOImpl paymentDAO = new PaymentMethodDAOImpl();
		List<PaymentMethod> allpaymentMethods = paymentDAO.getAllpaymentMethods();
		Gson gson = new Gson();
        String json = gson.toJson(allpaymentMethods);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
		
	}
}
