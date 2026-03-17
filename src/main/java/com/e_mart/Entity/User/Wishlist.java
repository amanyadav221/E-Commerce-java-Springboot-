package com.e_mart.Entity.User;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue
    private Long id;
	 @OneToMany(mappedBy="wishlist", cascade=CascadeType.ALL, orphanRemoval=true)
	    @JsonIgnoreProperties("wishlist")   // 🔥 LOOP BREAKER
	    private List<WishlistItem> items = new ArrayList<>();
	   public Long getId() {
		return id;
	}
	 @Override
	public String toString() {
		return "Wishlist [id=" + id + "]";
	}
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public List<WishlistItem> getItems() {
		 return items;
	 }
	 public void setItems(List<WishlistItem> items) {
		 this.items = items;
	 }
	 public MyUser getUser() {
		 return user;
	 }
	 public void setUser(MyUser user) {
		 this.user = user;
	 }
	 @OneToOne
	 @JoinColumn(name = "user_id", nullable = false, unique = true)
	 private MyUser user;
}
