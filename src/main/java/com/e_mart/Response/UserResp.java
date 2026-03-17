package com.e_mart.Response;

public class UserResp {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String fullName;
	private String username;
	private String email;
	private Long phone;
	private String role;
	private String status;
	@Override
	public String toString() {
		return "UserResp [id=" + id + ", fullName=" + fullName + ", username=" + username + ", email=" + email
				+ ", phone=" + phone + ", role=" + role + ", status=" + status + "]";
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long long1) {
		this.phone = long1;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
