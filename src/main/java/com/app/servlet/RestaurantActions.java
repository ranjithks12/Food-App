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
import javax.servlet.http.Part;

import com.app.daoimpl.RestaurantDAOImplementation;
import com.app.model.Restaurant;
import com.app.util.Utils;

@SuppressWarnings("serial")
@WebServlet("/restaurantActions")
@MultipartConfig
public class RestaurantActions extends HttpServlet {
	private static final String ADD = "add";
	private static final String DELETE = "delete";
	private static final String UPDATE = "update";

	String action;
	int restaurantId;
	String restaurantName;
	int deliveryTime;
	String cusineType;
	float ratings;
	String addres;
	boolean isActive;
	String imagePath;
	RestaurantDAOImplementation implObj;
	
	@Override
	public void init() throws ServletException {
		implObj = new RestaurantDAOImplementation();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Part imagePart = req.getPart("imagePath");
		extractData(req);
		Restaurant restaurant = returnRestaurantObject();
		if(imagePart != null) {
			String imagePartName = imagePart.getSubmittedFileName();
			if(!imagePartName.isEmpty()) {
				try {
					restaurant.setImagePath(imagePartName.substring(0, imagePartName.lastIndexOf('.')));
				} catch(StringIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (ADD.equals(action)) {
			if (generateFolders(restaurantName, imagePart)) {
				int result = implObj.addRestaurant(restaurant);
				if(result == 1) {
					List<Restaurant> allRestaurants = implObj.getAllRestaurants();
					req.getSession().setAttribute("restaurantList", allRestaurants);
					resp.sendRedirect("rest-actions.jsp");
				} else {
					resp.getWriter().write("Some error happened failed to insert data");
				}
			}
		} else if (UPDATE.equals(action)) {
			int result = implObj.updateRestaurant(restaurant);
			if(result == 1) {
				List<Restaurant> allRestaurants = implObj.getAllRestaurants();
				req.getSession().setAttribute("restaurantList", allRestaurants);
				resp.sendRedirect("rest-actions.jsp");
			} else {
				resp.getWriter().write("Some error happened failed to Update Restaurant data");
			}
		} else if (DELETE.equals(action)) {
			int result = implObj.deleteRestaurant(restaurantId);
			if(result == 1) {
				List<Restaurant> allRestaurants = implObj.getAllRestaurants();
				req.getSession().setAttribute("restaurantList", allRestaurants);
				resp.sendRedirect("rest-actions.jsp");
			} else {
				resp.getWriter().write("Some error happened failed to delete Restaurant data");
			}
		}
	}

	/**
	 * Creates the folder structure for a new restaurant and saves the uploaded
	 * image file.
	 *
	 * @param restaurantName the name of the restaurant (used for creating folder
	 *                       structure)
	 * @param imagePart      the uploaded image file to be saved in the folder
	 * @return true if the folders were created and the file was saved successfully;
	 *         false otherwise
	 */

	private boolean generateFolders(String restaurantName, Part imagePart) {
		if (Utils.createFolders(restaurantName)) {
			String fileName = imagePart.getSubmittedFileName();
			File imageUploadDir = Utils.generateRestaurantImageSavePath(restaurantName);
			File imageSavedLoc = new File(imageUploadDir, fileName);

			try {
				imagePart.write(imageSavedLoc.getAbsolutePath());
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Folders unable to create");
			return false;
		}
	}

	private void extractData(HttpServletRequest req) {
		if (Utils.validateFeild(req.getParameter("action"))) {
			action = req.getParameter("action");
		}
		if (Utils.validateFeild(req.getParameter("restaurantId"))) {
			restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		}
		if (Utils.validateFeild(req.getParameter("restaurantName"))) {
			restaurantName = req.getParameter("restaurantName");
		}
		if (Utils.validateFeild(req.getParameter("delTime"))) {
			deliveryTime = Integer.parseInt(req.getParameter("delTime"));
		}
		if (Utils.validateFeild(req.getParameter("cusineType"))) {
			cusineType = req.getParameter("cusineType");
		}
		if (Utils.validateFeild(req.getParameter("ratings"))) {
			ratings = Float.parseFloat(req.getParameter("ratings"));
		}
		if (Utils.validateFeild(req.getParameter("addres"))) {
			addres = req.getParameter("addres");
		}
		if (Utils.validateFeild(req.getParameter("isActive"))) {
			isActive = Boolean.parseBoolean(req.getParameter("isActive"));
		}
	}

	private Restaurant returnRestaurantObject() {
		Restaurant restaurantObj = new Restaurant();
		restaurantObj.setRestaurantId(restaurantId);
		restaurantObj.setRestaurantName(restaurantName);
		restaurantObj.setCusineType(cusineType);
		restaurantObj.setRatings(ratings);
		restaurantObj.setDeliveryTime(deliveryTime);
		restaurantObj.setActive(isActive);
		restaurantObj.setAddress(addres);
		restaurantObj.setImagePath(imagePath);
		return restaurantObj;
	}
}
