package com.app.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.daoimpl.MenuItemDAOImplementation;
import com.app.model.Cart;
import com.app.model.CartItem;
import com.app.model.MenuItem;

@SuppressWarnings("serial")
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		String action = req.getParameter("action");
		if ("add".equals(action)) {
			boolean isAdded = addItemToCart(req, resp, cart, session);
			if(isAdded) {
				resp.sendRedirect("menuItem.jsp");
			} else {
				resp.sendRedirect("menuItem.jsp#popupcontainer");
//				resp.sendRedirect("menuItem.jsp?showPopup=true");
			}
		} else if ("decrease".equals(action)) {
			updateQuantityDecrease(req, cart, session);
			resp.sendRedirect("cart.jsp");
		} else if ("increase".equals(action)) {
			updateQuantityIncrease(req, cart, session);
			resp.sendRedirect("cart.jsp");
		} else if ("delete".equals(action)) {
			cart.removeItem(Integer.parseInt(req.getParameter("menuItemId")));
			resp.sendRedirect("cart.jsp");
		} else {

		}
	}

	private void updateQuantityDecrease(HttpServletRequest req, Cart cart, HttpSession session) {
		if (Integer.parseInt(req.getParameter("quantity")) <= 1) {
			cart.removeItem(Integer.parseInt(req.getParameter("menuItemId")));
		} else {
			cart.updateQuantity(Integer.parseInt(req.getParameter("menuItemId")),
					Integer.parseInt(req.getParameter("quantity")) - 1);
			session.setAttribute("cart", cart);
		}
	}

	private void updateQuantityIncrease(HttpServletRequest req, Cart cart, HttpSession session) {
		cart.updateQuantity(Integer.parseInt(req.getParameter("menuItemId")),
				Integer.parseInt(req.getParameter("quantity")) + 1);
		session.setAttribute("cart", cart);
	}

	private boolean addItemToCart(HttpServletRequest req, HttpServletResponse resp, Cart cart, HttpSession session) {
		int menuItemId = Integer.parseInt(req.getParameter("menuItemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		Map<Integer, CartItem> items = cart.getItems();
		int restaureantId = items.values().stream().findFirst().map(CartItem::getRestaurantId).orElse(-1);
		MenuItemDAOImplementation menuItemDAO = new MenuItemDAOImplementation();
		MenuItem menuItem = menuItemDAO.getMenuItem(menuItemId);
//		try {
			if (!items.isEmpty()) {
				if (menuItem.getRestaurantId() != restaureantId) {
					return false;
				} else {
					if (menuItem != null) {
						CartItem item = new CartItem(menuItem.getMenuId(), menuItem.getRestaurantId(),
								menuItem.getItemName(), menuItem.getPrice(), quantity, quantity * menuItem.getPrice());
						cart.addItem(item);
						return true;
					}
				}
			} else {
				if (menuItem != null) {
					CartItem item = new CartItem(menuItem.getMenuId(), menuItem.getRestaurantId(),
							menuItem.getItemName(), menuItem.getPrice(), quantity, quantity * menuItem.getPrice());
					cart.addItem(item);
					return true;
				}

			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		session.setAttribute("cart", cart);
		return true;
	}

}
