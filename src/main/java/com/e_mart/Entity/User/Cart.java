package com.e_mart.Entity.User;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//
////@Entity
////public class Cart {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
////
////    @OneToOne
////    @JoinColumn(name="user_username", unique = true)
////    private MyUser user;
////
////    public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public MyUser getUser() {
////		return user;
////	}
////
////	public void setUser(MyUser user) {
////		this.user = user;
////	}
////
////	public List<CartItem> getItems() {
////		return items;
////	}
////
////	@Override
////	public String toString() {
////		return "Cart [id=" + id + ", user=" + user + ", items=" + items + "]";
////	}
////
////	public void setItems(List<CartItem> items) {
////		this.items = items;
////	}
////
////	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
////    private List<CartItem> items;
////
////    public double getTotal(){
////        return items.stream().mapToDouble(i -> i.getSubTotal()).sum();
////    }
////}
////
//
//@Entity
//public class Cart {
//
//    @Id @GeneratedValue
//    private Long id;
//
////    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
////    @JsonManagedReference
//    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
//    @JsonIgnoreProperties("cart")   // 🔥 LOOP BREAKER
//    private List<CartItem> items = new ArrayList<>();
//
//    @OneToOne
//    @JoinColumn(name = "user_username", referencedColumnName = "username", unique = true)
//    private MyUser user;
//
//    @Override
//	public String toString() {
//		return "Cart [id=" + id + ", items=" + items + ", user=" + user + "]";
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public List<CartItem> getItems() {
//		return items;
//	}
//
//	public void setItems(List<CartItem> items) {
//		this.items = items;
//	}
//
//	public MyUser getUser() {
//		return user;
//	}
//
//	public void setUser(MyUser user) {
//		this.user = user;
//	}
//
//	public double getGrandTotal(){
//        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
//    }
//}
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL, orphanRemoval=true)
//    @JsonIgnoreProperties("cart")
//    private List<CartItem> items = new ArrayList<>();

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("cart")
    private List<CartItem> items = new ArrayList<>();

    // Cart owns the FK
//    @OneToOne
//    @JoinColumn(name = "user_username", referencedColumnName = "username", nullable = false, unique = true)
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false, unique = true)
//    private MyUser user;

   // private MyUser user;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private MyUser user;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public double getGrandTotal(){
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
