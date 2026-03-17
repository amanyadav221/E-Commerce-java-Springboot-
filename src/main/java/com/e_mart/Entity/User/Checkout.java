package com.e_mart.Entity.User;
import java.util.List;

import com.e_mart.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Checkout {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    private MyUser user;

  
    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheckoutItem> items;


    @ManyToOne
    private Address address;

    private String orderStatus;
    private String paymentMode;
    private String paymentStatus;
    private Long shipping;
    private Long subTotal;
    private Long total;
    private String dateOfOrder;
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
	public List<CheckoutItem> getItems() {
		return items;
	}
	public void setItems(List<CheckoutItem> items) {
		this.items = items;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Long getShipping() {
		return shipping;
	}
	public void setShipping(Long shipping) {
		this.shipping = shipping;
	}
	public Long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	@Override
	public String toString() {
		return "Checkout [id=" + id + ", user=" + user + ", items=" + items + ", address=" + address + ", orderStatus="
				+ orderStatus + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus + ", shipping="
				+ shipping + ", subTotal=" + subTotal + ", total=" + total + ", dateOfOrder=" + dateOfOrder + "]";
	}
    
}
