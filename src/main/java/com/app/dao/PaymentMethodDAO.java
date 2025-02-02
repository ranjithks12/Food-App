package com.app.dao;

import java.util.List;

import com.app.model.PaymentMethod;

public interface PaymentMethodDAO {
	List<PaymentMethod> getAllpaymentMethods();
	
	PaymentMethod getPaymentMethodById(int paymentMethodId);
}
