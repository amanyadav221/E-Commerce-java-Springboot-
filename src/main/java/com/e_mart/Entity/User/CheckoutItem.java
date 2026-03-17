package com.e_mart.Entity.User;

import com.e_mart.Entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CheckoutItem {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "checkout_id")
    private Checkout checkout;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
	public String toString() {
		return "CheckoutItem [id=" + id + ", checkout=" + checkout + ", product=" + product + ", size=" + size
				+ ", color=" + color + ", quantity=" + quantity + ", price=" + price + ", totalPrice=" + totalPrice
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Checkout getCheckout() {
		return checkout;
	}
	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}
	private String size;
    private String color;
    private Integer quantity;
    private double price;
    private double totalPrice;
}

