package com.e_mart.DTO;

public class ContactUsDTO {

	private String name;
	private String phone;
	private String email;
	private String subject;
	private String message;
	private String status;
	private String date;
	@Override
	public String toString() {
		return "ContactUsDTO [name=" + name + ", phone=" + phone + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + ", status=" + status + ", date=" + date + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
