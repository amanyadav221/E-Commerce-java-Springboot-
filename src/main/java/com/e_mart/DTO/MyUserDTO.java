package com.e_mart.DTO;

import com.e_mart.Entity.User.USER_ROLE;

public class MyUserDTO {
	private String fullName;
	private String username;
	private String email;
	private String password;
//	private USER_ROLE role;
//	public USER_ROLE getRole() {
//		return role;
//	}
//	public void setRole(USER_ROLE role) {
//		this.role = role;
//	}
	@Override
	public String toString() {
		return "MyUserDTO [fullname=" + fullName + ", username=" + username + ", email=" + email + ", password="
				+ password + ", phone=" + phone + "]";
	}
	public MyUserDTO(String fullname, String username, String email, String password, Long phone) {
		super();
		this.fullName = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	public MyUserDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullname) {
		this.fullName = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	private Long phone;
	
}
