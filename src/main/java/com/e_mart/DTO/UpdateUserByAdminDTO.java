package com.e_mart.DTO;

public class UpdateUserByAdminDTO {
	private String status;
	private String role;
	@Override
	public String toString() {
		return "UpdateUserByAdminDTO [status=" + status + ", role=" + role + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
