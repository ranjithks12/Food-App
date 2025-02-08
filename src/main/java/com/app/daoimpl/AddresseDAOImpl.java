package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.AddAddressDAO;
import com.app.model.Address;
import com.app.util.MyConnector;

public class AddresseDAOImpl implements AddAddressDAO{
	private static final String ADD_ADDRESS = "INSERT INTO `user_address`(`userId`, `area`, `street`, `landmark`, `city_state`, `postalcode`) " +
											  "values(?, ?, ?, ?, ?, ?)";
	private static final String FETCH_ADDRESSES_BY_USER_ID = "SELECT * FROM `user_address` WHERE `userId` = ?";
	private Connection connecttion = null;
	private PreparedStatement pstatement = null;
	private ResultSet result = null;

	@Override
	public int addAddress(Address address) {
		try {
			connecttion = MyConnector.getMyConnector().connect();
			pstatement = connecttion.prepareStatement(ADD_ADDRESS);
			pstatement.setInt(1, address.getUserId());
			pstatement.setString(2, address.getArea());
			pstatement.setString(3, address.getStreet());
			pstatement.setString(4, address.getLandMark());
			pstatement.setString(5, address.getCityAndState());
			pstatement.setInt(6, address.getPostalCode());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connecttion);
		}
		return 0;
	}

	@Override
	public List<Address> getAddresseByUserId(int userId) {
		List<Address> addressList = new ArrayList<Address>();
		try {
			connecttion = MyConnector.getMyConnector().connect();
			pstatement = connecttion.prepareStatement(FETCH_ADDRESSES_BY_USER_ID);			
			pstatement.setInt(1, userId);
			result = pstatement.executeQuery();
			while (result.next()) {
				addressList.add(new Address(result.getInt("userAddressId"), result.getInt("userId"),
						result.getString("area"), result.getString("street"), result.getString("landmark"),
						result.getString("city_state"), result.getInt("postalcode"), result.getDate("updated")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connecttion);
		}
		return addressList;
	}

}
