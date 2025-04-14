package com.app.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.app.daoimpl.MenuItemDAOImplementation;
import com.app.model.MenuItem;
import com.app.model.Restaurant;
import com.app.util.Utils;

@SuppressWarnings("serial")
@WebServlet("/menuItemActions")
@MultipartConfig
public class MenuItemActions extends HttpServlet {
	private static final String ADD = "add";
	private static final String DELETE = "delete";
	private static final String UPDATE = "update";
	private static final String GET_DETAILS = "getDetails";

	private String action;
	private int restaurantId;
	private int menuItemId;
	private String menuItemName;
	private String description;
	private float itemPrice;
	private int isAvailable;
	private String imagePath;
	
	
	private static MenuItemDAOImplementation implObj;
	private static List<MenuItem> menuItems;
	
	@Override
	public void init() throws ServletException {
		implObj = new MenuItemDAOImplementation();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		extractdata(req);
		Part imagePart;
		MenuItem menuItem = buildMenuItemObject();

		if(action.equals(GET_DETAILS)) {
			try {
				menuItems = implObj.getMenuItemById(restaurantId);
				session.setAttribute("menuItems", menuItems);
				resp.sendRedirect("menu-actions.jsp");
			} catch (Exception e) { 
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		} else if(action.equals(ADD)) {
			imagePart = req.getPart("imagePath");
			Utils.setImagePath(menuItem, imagePart);
			String restaurantName = getRestaurantNameById(restaurantId, session);
			if (saveItemImage(imagePart, restaurantName)) {
				try {
					int result = implObj.addMenuItem(menuItem);
					if (result == 1) {
						session.setAttribute("showPopup", "Menu item Added Succesfully.!");
						resp.sendRedirect("menu-actions.jsp");
					} else {
						session.setAttribute("showPopup", "Failed to add Menu item.!");
						resp.sendRedirect("menu-actions.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				session.setAttribute("showPopup", "Failed to add Menu item.!");
				resp.sendRedirect("menu-actions.jsp");
			}
		} else if(action.equals(UPDATE)) {
			int result = implObj.updateMenuItemDetails(menuItem);
			if(result == 1) {
				session.setAttribute("showPopup", "Menu item Details Updated Succesfully.!");
				resp.sendRedirect("menu-actions.jsp");
			} else {
				session.setAttribute("showPopup", "Failed to update Menu details.!");
				resp.sendRedirect("menu-actions.jsp");
			}
			
		} else if(action.equals(DELETE)) {
			int result = implObj.removeMenuItem(menuItemId);
			if(result == 1) {
				session.setAttribute("showPopup", "Menu item Deletd Succesfully.!");
				resp.sendRedirect("menu-actions.jsp");
			} else {
				session.setAttribute("showPopup", "Failed to delete Menu item.!");
				resp.sendRedirect("menu-actions.jsp");
			}
		}
	}
	
	void extractdata(HttpServletRequest req) {
		if(Utils.validateFeild(req.getParameter("submitAction"))){
			action = req.getParameter("submitAction");
		}
		if(Utils.validateFeild(req.getParameter("restaurantId"))) {
			restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		}
		if(Utils.validateFeild(req.getParameter("menuItemId"))) {
			menuItemId = Integer.parseInt(req.getParameter("menuItemId"));
		}
		if(Utils.validateFeild(req.getParameter("itemName"))) {
			menuItemName = req.getParameter("itemName");
		}
		if(Utils.validateFeild(req.getParameter("description"))) {
			description = req.getParameter("description");
		}
		if(Utils.validateFeild(req.getParameter("itemPrice"))) {
			itemPrice = Float.parseFloat(req.getParameter("itemPrice"));
		}
		if(Utils.validateFeild(req.getParameter("isAvailable"))) {
			isAvailable = Integer.parseInt(req.getParameter("isAvailable"));
		}
		if(Utils.validateFeild(req.getParameter("imagePath"))) {
			imagePath = req.getParameter("imagePath");
		}
	}
	
	private MenuItem buildMenuItemObject() {
		return new MenuItem(menuItemId, restaurantId, menuItemName, description, itemPrice, isAvailable, imagePath);
	}
	
	private boolean saveItemImage(Part imagePart, String restaurantName) {
		String fileName = imagePart.getSubmittedFileName();
		File imageUploadDir = Utils.generateMenuItemImageSavePath(restaurantName);
		File imageSavedLoc = new File(imageUploadDir, fileName);
		try {
			imagePart.write(imageSavedLoc.getAbsolutePath());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private String getRestaurantNameById(int restaurantId, HttpSession session) {
		List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurantList");
		 return restaurants.stream()
                 .filter(restaurant -> restaurant.getRestaurantId() == restaurantId)
                 .map(restaurant -> restaurant.getRestaurantName().trim())
                 .findFirst()
                 .orElse("");
	}
}



//if(imagePart != null) {
//String imagePartName = imagePart.getSubmittedFileName();
//if(!imagePartName.isEmpty()) {
//	try {
//		menuItem.setImagePath(imagePartName.substring(0, imagePartName.lastIndexOf('.')));
//	} catch(StringIndexOutOfBoundsException e) {
//		e.printStackTrace();
//	}
//}
//}
