package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.MenuItemDAO;
import com.app.model.MenuItem;
import com.app.util.MyConnector;
import com.app.util.QueryData;

public class MenuItemDAOImplementation implements MenuItemDAO {
	private static final String FETCH_BY_ID = "SELECT * FROM `MENUITEM` WHERE `RESTAURANTID`=?";
	private static final String FETCH_BY_MENUID = "SELECT * FROM `MENUITEM` WHERE `MENUID`=?";
	private static final String ADD_MENU_ITEM = "INSERT INTO `MENUITEM`(`RESTAURANTID`, `ITEMNAME`, `ITEMDESCRIPTION`, `PRICE`, `ISAVAILABLE`, `IMAGEPATH`) VALUES(?,?,?,?,?,?)";
	private static final String REMOVE_IETM = "DELETE FROM `MENUITEM` WHERE `MENUID`=?";
	
	private Connection connection = null;
	private PreparedStatement pstatement;
	private ResultSet result = null;
	MyConnector myConnector;
	
	private static List<MenuItem> menuItemList = new ArrayList<MenuItem>();

	@Override
	public List<MenuItem> getMenuItemById(int restaurantId) throws Exception {
		menuItemList.clear();
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(FETCH_BY_ID);
			pstatement.setInt(1, restaurantId);
			result = pstatement.executeQuery();

			while (result.next()) {
				menuItemList.add(new MenuItem(result.getInt("menuId"), result.getInt("restaurantId"),
						result.getString("itemName"), result.getString("itemDescription"), result.getFloat("price"),
						result.getInt("isAvailable"), result.getString("imagePath")));
			}
			if (!menuItemList.isEmpty()) {
				return menuItemList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connection);
		}
		return null;
	}

	@Override
	public MenuItem getMenuItem(int menuId) {
		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			pstatement = connection.prepareStatement(FETCH_BY_MENUID);
			pstatement.setInt(1, menuId);
			result = pstatement.executeQuery();

			while (result.next()) {
				return new MenuItem(result.getInt("menuId"), result.getInt("restaurantId"),
						result.getString("itemName"), result.getString("itemDescription"), result.getFloat("price"),
						result.getInt("isAvailable"), result.getString("imagePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connection);
		}
		return null;
	}

	@Override
	public int addMenuItem(MenuItem menuItem) throws Exception {
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(ADD_MENU_ITEM);
			pstatement.setInt(1, menuItem.getRestaurantId());
			pstatement.setString(2, menuItem.getItemName());;
			pstatement.setString(3, menuItem.getItemDescription());
			pstatement.setFloat(4, menuItem.getPrice());
			pstatement.setInt(5, menuItem.getIsAvailable());
			pstatement.setString(6, menuItem.getImagePath());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
//			throw new Exception(e.getMessage());
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}

	@Override
	public int removeMenuItem(int menuItemId) {
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(REMOVE_IETM);
			pstatement.setInt(1, menuItemId);
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		} 
		return 0;
	}

	@Override
	public int updateMenuItemDetails(MenuItem menuItem) {
		try {
			connection = MyConnector.getMyConnector().connect();
			QueryData data = buildUpdateQuery(menuItem);
			pstatement = connection.prepareStatement(data.getQuery());
			List<Object> paramList = data.getParams();
			for (int i = 0; i < paramList.size(); i++) {
		    	pstatement.setObject(i + 1, paramList.get(i));
		    }
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}
	
	
	private QueryData buildUpdateQuery(MenuItem menuItem) {
		StringBuilder query = new StringBuilder("UPDATE `MENUITEM` SET ");
		List<Object> params = new ArrayList<>();
		
		query.append("`RESTAURANTID` = ?, ");
		params.add(menuItem.getRestaurantId());
		
		if (menuItem.getItemName() != null) {
			query.append("`IETMNAME` = ?, ");
			params.add(menuItem.getItemName());
		}
		
		if (menuItem.getItemDescription() != null) {
			query.append("`ITEMDESCRIPTION` = ?, ");
			params.add(menuItem.getItemDescription());
		}

		query.append("`PRICE` = ?, ");
		params.add(menuItem.getPrice());
		
		query.append("`ISAVAILABLE` = ?, ");
		params.add(menuItem.getIsAvailable());
		

		if (menuItem.getImagePath() != null) {
			query.append("`IMAGEPATH` = ?, ");
			params.add(menuItem.getImagePath());
		}
		
		// Remove trailing comma and space
		if (query.toString().endsWith(", ")) {
			query.setLength(query.length() - 2);
		}

		query.append(" WHERE `MENUITEMID` = ?");
		params.add(menuItem.getMenuId());

		return new QueryData(query.toString(), params);
	}
}
