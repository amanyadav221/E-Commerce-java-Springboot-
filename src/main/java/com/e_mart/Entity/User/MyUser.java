package com.e_mart.Entity.User;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class MyUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Newsletter> newsletters = new ArrayList<>();

	private String fullName;
	private String email;
	private Long phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String password;
	private USER_ROLE role;
	private String status;
	
public List<Newsletter> getNewsletters() {
		return newsletters;
	}
	public void setNewsletters(List<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private Cart cart;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private Wishlist wishlist;
	

	 public Wishlist getWishlist() {
		return wishlist;
	}
	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	 public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JsonIgnore
	    private List<Address> addresses;
	
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public USER_ROLE getRole() {
		return role;
	}
	public void setRole(USER_ROLE role) {
		this.role = role;
	}
	@Override
	public String toString() {
	    return "MyUser{" +
	            "id=" + id +
	            ", username='" + username + '\'' +
	            ", email='" + email + '\'' +
	            ", role=" + role +
	            '}';
	}

	public MyUser(String fullName, String username, String email, Long phone, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
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
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
