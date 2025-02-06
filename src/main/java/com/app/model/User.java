package com.app.model;

import java.util.Date;

public class User {
	private int user_id;
	private String user_name;
	private String password;
	private long phone_number;
	private String email;
	private Date created_on;
	private Date last_login_date;
	public User() {
		super();
	}
	public User(String user_name, String password, long phone_number, String email) {
		this.user_name = user_name;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
	}
	public User(String user_name, String password, long phone_number, String email, Date created_on,
			Date last_login_date) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.created_on = created_on;
		this.last_login_date = last_login_date;
	}
	public User(int user_id, String user_name, String password, long phone_number, String email,
			Date created_on, Date last_login_date) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.created_on = created_on;
		this.last_login_date = last_login_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", phone_number="
				+ phone_number + ", email=" + email + ", address=" + ", created_on=" + created_on
				+ ", last_login_date=" + last_login_date + "]";
	}
	
	
}
