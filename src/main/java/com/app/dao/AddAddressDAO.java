package com.app.dao;

import java.util.List;

import com.app.model.Address;

public interface AddAddressDAO {
	int addAddress(Address address);
	List<Address> getAddresseByUserId(int userId);
}
