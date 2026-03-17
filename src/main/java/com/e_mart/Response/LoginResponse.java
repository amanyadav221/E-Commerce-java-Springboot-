package com.e_mart.Response;

import com.e_mart.Entity.User.USER_ROLE;

public class LoginResponse {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String fullName;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullname) {
		this.fullName = fullname;
	}
	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", fullName=" + fullName + ", role=" + role + ", jwt=" + jwt
				+ ", usernameError=" + usernameError + ", passwordError=" + passwordError + "]";
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	private String role;
	private String jwt;
	private String usernameError;
	private String passwordError;
	public String getRole() {
		return role;
	}
	public void setRole(String user_ROLE) {
		this.role = user_ROLE;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getUsernameError() {
		return usernameError;
	}
	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPassworderror(String passwordError) {
		this.passwordError = passwordError;
	}

}
