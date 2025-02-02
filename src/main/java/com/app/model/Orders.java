package com.app.model;

import java.time.LocalDateTime;

public class Orders {
	private int orderId;
	private int userID;
	private int restaurentId;
	private String paymentMethod;
	private float payedAmount;
	private String status;
	private LocalDateTime orderedDate;
	
	public Orders() {	}
	
	public Orders(int orderId, int userID, int restaurentId, String paymentMethod,
			float payedAmount) {
		super();
		this.orderId = orderId;
		this.userID = userID;
		this.restaurentId = restaurentId;
		this.paymentMethod = paymentMethod;
		this.payedAmount = payedAmount;
	}

	public Orders(int orderId, int userID, int restaurentId, String paymentMethod,
			float payedAmount, String status, LocalDateTime orderedDate) {
		super();
		this.orderId = orderId;
		this.userID = userID;
		this.restaurentId = restaurentId;
		this.paymentMethod = paymentMethod;
		this.payedAmount = payedAmount;
		this.status = status;
		this.orderedDate = orderedDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public float getPayedAmount() {
		return payedAmount;
	}
	
	public void setPayedAmount(float payedAmount) {
		this.payedAmount = payedAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userID=" + userID + ", restaurentId=" + restaurentId
				+ ", paymentMethod=" + paymentMethod + ", status=" + status
				+ ", orderedDate=" + orderedDate + "]";
	}
}
