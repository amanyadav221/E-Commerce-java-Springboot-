package com.e_mart.Entity;

import com.e_mart.Entity.User.MyUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	  @JsonIgnore
	private MyUser user;
	 private String name;
	 private String email;
	 private String phone;
	 private String subject;
	 private String message;
	 private String status;
	 private String date;
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
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public MyUser getUser() {
		 return user;
	 }
	 public void setUser(MyUser user) {
		 this.user = user;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getPhone() {
		 return phone;
	 }
	 public void setPhone(String phone) {
		 this.phone = phone;
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
	 @Override
	public String toString() {
		return "ContactUs [id=" + id + ", user=" + user + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", subject=" + subject + ", message=" + message + ", status=" + status + ", date=" + date + "]";
	}
	 

}
