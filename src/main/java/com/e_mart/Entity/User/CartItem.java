package com.e_mart.Entity.User;
//
//import jakarta.persistence.*;
//
//@Entity
//public class CartItem {
//
//    @Override
//	public String toString() {
//		return "CartItem [id=" + id + ", productId=" + productId + ", name=" + name + ", size=" + size + ", color="
//				+ color + ", quantity=" + quantity + ", price=" + price + ", subTotal=" + subTotal + ", cart=" + cart
//				+ "]";
//	}
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long productId;
//    private String name;
//    private String size;
//    private String color;
//    private int quantity;
//    private double price;
//
//    private double subTotal;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    public CartItem() {}
//
//    @PrePersist
//    @PreUpdate
//    public void calculateSubTotal(){
//        this.subTotal = this.price * this.quantity;
//    }
//
//    // Getters & Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Long getProductId() { return productId; }
//    public void setProductId(Long productId) { this.productId = productId; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getSize() { return size; }
//    public void setSize(String size) { this.size = size; }
//
//    public String getColor() { return color; }
//    public void setColor(String color) { this.color = color; }
//
//    public int getQuantity() { return quantity; }
//    public void setQuantity(int quantity) { this.quantity = quantity; }
//
//    public double getPrice() { return price; }
//    public void setPrice(double price) { this.price = price; }
//
//    public double getSubTotal() { return subTotal; }
//
//    public Cart getCart() { return cart; }
//    public void setCart(Cart cart) { this.cart = cart; }
//}

import com.e_mart.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class CartItem {

    @Id @GeneratedValue
    private Long itemId;

    @ManyToOne
    private Product product;
    
    private String color;
    private String size;

    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	private Long quantity;
    @Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", product=" + product + ", color=" + color + ", size=" + size
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", cart=" + cart + "]";
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	private double totalPrice;

//	@ManyToOne
//	@JsonBackReference
	 @ManyToOne
	    @JoinColumn(name="cart_id")
	    @JsonIgnoreProperties("items") 
    private Cart cart;

    @PrePersist
    @PreUpdate
    void calc(){
        this.totalPrice = product.getFinalPrice() * quantity;
    }
}

