package com.e_mart.Entity.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Newsletter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;

	private String status;
	  @ManyToOne
	    @JoinColumn(name = "user_id")
	  @JsonIgnore
	private MyUser user;
	  public Long getId() {
		  return id;
	  }
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public String getEmail() {
		  return email;
	  }
	  public void setEmail(String email) {
		  this.email = email;
	  }
	  public String getStatus() {
		  return status;
	  }
	  public void setStatus(String status) {
		  this.status = status;
	  }
	  public MyUser getUser() {
		  return user;
	  }
	  public void setUser(MyUser user) {
		  this.user = user;
	  }
	  @Override
	  public String toString() {
		return "Newsletter [id=" + id + ", email=" + email + ", status=" + status +"]";
	  }
	  
	  

}
