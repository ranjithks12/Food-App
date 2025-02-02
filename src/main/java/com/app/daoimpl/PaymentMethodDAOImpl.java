package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.PaymentMethodDAO;
import com.app.model.PaymentMethod;
import com.app.util.MyConnector;

public class PaymentMethodDAOImpl implements PaymentMethodDAO {

	private static final String FETCH_ALL = "SELECT * FROM `PAYMENTMETHOD`";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	MyConnector myConnector;

	@Override
	public List<PaymentMethod> getAllpaymentMethods() {
		List<PaymentMethod> paymentMethodList = new ArrayList<>();
		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			statement = connection.createStatement();
			result = statement.executeQuery(FETCH_ALL);
			while (result.next()) {
				paymentMethodList.add(new PaymentMethod(result.getInt("paymentMethodId"),
						result.getString("paymentMethodName"), result.getBoolean("isAvailable")));
			}
			if(!paymentMethodList.isEmpty()) {
				return paymentMethodList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, statement, connection);
		}
		return null;
	}

	@Override
	public PaymentMethod getPaymentMethodById(int paymentMethodId) {
		return null;
	}

}
