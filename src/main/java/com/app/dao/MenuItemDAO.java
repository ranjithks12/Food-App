package com.app.dao;

import java.util.List;

import com.app.model.MenuItem;

public interface MenuItemDAO {
	List<MenuItem> getMenuItemById(int restaurantId);
	MenuItem getMenuItem(int menuId);
}
