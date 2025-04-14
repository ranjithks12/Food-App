package com.app.dao;

import java.util.List;

import com.app.model.MenuItem;

public interface MenuItemDAO {
	List<MenuItem> getMenuItemById(int restaurantId) throws Exception;
	MenuItem getMenuItem(int menuId);
	int addMenuItem(MenuItem menuItem) throws Exception;
	int removeMenuItem(int menuItemId);
	int updateMenuItemDetails(MenuItem menuItem);
}
