package com.app.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> items;
	
	public Cart() {
		this.items = new LinkedHashMap<>();
	}
	
	public void addItem(CartItem item) {
		int itemId = item.getMenuId();
		if(items.containsKey(itemId)) {
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
			existingItem.setSubTotal(existingItem.getPrice() * existingItem.getQuantity());
		} else {
			items.put(itemId, item);
		}
	}
	
	public CartItem getItem(int itemId) {
        return items.get(itemId);
    }
	
	public Map<Integer, CartItem> getItems(){
		return items;
	}
	
	public void removeItem(int menuItemId) {
		items.remove(menuItemId);
	}
	
	public void updateQuantity(int menuItemId, int itemQuantity) {
		if(items.containsKey(menuItemId)) {
			CartItem item = items.get(menuItemId);
			item.setQuantity(itemQuantity);
			item.setSubTotal(itemQuantity * item.getPrice());
		}
	}
}
