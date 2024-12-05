package com.sam.beans;

import com.sam.daos.UserDao;
import com.sam.daos.UserDaoImpl;
import com.sam.entities.User;

public class LoginBean {

	private String email;
	private String password;
	User user;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void loginUser() {
		try (UserDao userDao = new UserDaoImpl()) {
			User u = userDao.findByEmail(email);

			if (u != null && u.getPassword().equals(password)) {
				user = u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
