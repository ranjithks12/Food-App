package com.app.model;

import java.util.Date;

public class Address {
	
	private int addresId;
	private int userId;
	private String area;
	private String street;
	private String landMark;
	private String cityAndState;
	private int postalCode;
	private Date updated;
	
	public Address() {	}

	public Address(int addresId, int userId, String area, String street, String landMark, String cityAndState,
			int postalCode, Date updated) {
		this.addresId = addresId;
		this.userId = userId;
		this.area = area;
		this.street = street;
		this.landMark = landMark;
		this.cityAndState = cityAndState;
		this.postalCode = postalCode;
		this.updated = updated;
	}
	
	

	public Address(int userId, String area, String street, String landMark, String cityAndState, int postalCode) {
		this.userId = userId;
		this.area = area;
		this.street = street;
		this.landMark = landMark;
		this.cityAndState = cityAndState;
		this.postalCode = postalCode;
	}

	public int getAddresId() {
		return addresId;
	}

	public void setAddresId(int addresId) {
		this.addresId = addresId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCityAndState() {
		return cityAndState;
	}

	public void setCityAndState(String cityAndState) {
		this.cityAndState = cityAndState;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Address [addresId=" + addresId + ", userId=" + userId + ", area=" + area + ", street=" + street
				+ ", landMark=" + landMark + ", cityAndState=" + cityAndState + ", postalCode=" + postalCode
				+ ", updated=" + updated + "]";
	}
}
