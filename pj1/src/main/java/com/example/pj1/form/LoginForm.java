package com.example.pj1.form;

public class LoginForm {

	private String userId;
	private String password;

	public String getUserId() {
		return userId;
	}
	public final void setUserId(String userIdP) {
		userId = userIdP;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String passwordP) {
		password = passwordP;
	}
}
