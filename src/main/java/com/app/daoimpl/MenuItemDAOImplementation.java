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

public class MenuItemDAOImplementation implements MenuItemDAO {
	private static final String FETCH_BY_ID = "SELECT * FROM `MENUITEM` WHERE `RESTAURANTID`=?";
	private static final String FETCH_BY_MENUID = "SELECT * FROM `MENUITEM` WHERE `MENUID`=?";
	private Connection connection = null;
	private PreparedStatement pstatement;
	private ResultSet result = null;
	MyConnector myConnector;

	@Override
	public List<MenuItem> getMenuItemById(int restaurantId) {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			pstatement = connection.prepareStatement(FETCH_BY_ID);
			pstatement.setInt(1, restaurantId);
			result = pstatement.executeQuery();

			while (result.next()) {
				menuItemList.add(new MenuItem(result.getInt("menuId"), result.getInt("restaurantId"),
						result.getString("itemName"), result.getString("itemDescription"), result.getFloat("price"),
						result.getBoolean("isAvailable"), result.getString("imagePath")));
			}
			if (!menuItemList.isEmpty()) {
				return menuItemList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
						result.getBoolean("isAvailable"), result.getString("imagePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connection);
		}
		return null;
	}
}
