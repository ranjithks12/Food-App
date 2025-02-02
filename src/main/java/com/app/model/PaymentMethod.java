package com.app.model;

public class PaymentMethod {
	private int paymentMethodId;
	private String paymentMethodName;
	private boolean isAvailable;
	
	public PaymentMethod() {}

	public PaymentMethod(int paymentMethodId, String paymentMethodName, boolean isAvailable) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.paymentMethodName = paymentMethodName;
		this.isAvailable = isAvailable;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return paymentMethodId + ", " + paymentMethodName + ", " + isAvailable;
	}
	
	
}
