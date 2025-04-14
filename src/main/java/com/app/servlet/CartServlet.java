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
	private static final String ADD = "add";
	private static final String DECREASE = "decrease";
	private static final String INCREASE = "increase";
	private static final String DELETE = "delete";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		String action = req.getParameter("action");
		String redirectPage = null;

		switch (action) {
		    case ADD:
		        if (addItemToCart(req, resp, cart, session)) {
		            redirectPage = "menuItem.jsp";
		        } else {
		            session.setAttribute("showPopup", true);
		            redirectPage = "menuItem.jsp";
		        }
		        break;

		    case DECREASE:
		        updateQuantityDecrease(req, cart, session);
		        redirectPage = "cart.jsp";
		        break;

		    case INCREASE:
		        updateQuantityIncrease(req, cart, session);
		        redirectPage = "cart.jsp";
		        break;

		    case DELETE:
		        int menuItemId = Integer.parseInt(req.getParameter("menuItemId"));
		        cart.removeItem(menuItemId);
		        redirectPage = "cart.jsp";
		        break;

		    default:
		        redirectPage = "cart.jsp"; 
		        break;
		}

		// Final redirect
		if (redirectPage != null) {
		    resp.sendRedirect(redirectPage);
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

	    MenuItemDAOImplementation menuItemDAO = new MenuItemDAOImplementation();
	    MenuItem menuItem = menuItemDAO.getMenuItem(menuItemId);

	    if (menuItem == null) {
	        return false; // menu item not found
	    }

	    // Check if cart has items from a different restaurant
	    Map<Integer, CartItem> items = cart.getItems();
	    int existingRestaurantId = items.values().stream()
	        .findFirst()
	        .map(CartItem::getRestaurantId)
	        .orElse(menuItem.getRestaurantId()); // default to current item if empty

	    if (!items.isEmpty() && menuItem.getRestaurantId() != existingRestaurantId) {
	        return false; // different restaurant, cannot add
	    }

	    // Create and add item
	    CartItem item = new CartItem(
	        menuItem.getMenuId(),
	        menuItem.getRestaurantId(),
	        menuItem.getItemName(),
	        menuItem.getPrice(),
	        quantity,
	        quantity * menuItem.getPrice(),
	        menuItem.getImagePath()
	    );

	    cart.addItem(item);
	    session.setAttribute("cart", cart);
	    return true;
	}
}

