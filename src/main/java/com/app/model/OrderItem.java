package com.app.model;

public class OrderItem {
	private int orderItemId;
	private String orderId;
	private int menuId;
	private String itemName;
	private int quantity;
	private float subtotal;
	
	public OrderItem() {	}

	public OrderItem(int orderItemId, String orderId, int menuId, String itemName, int quantity, float subtotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + menuId + ", itemName="
				+ itemName + ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}
	
	

}
