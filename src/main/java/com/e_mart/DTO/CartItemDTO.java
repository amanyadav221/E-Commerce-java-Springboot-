package com.e_mart.DTO;

public class CartItemDTO {
	 private Long id;
	 
  private Long productId;
	     @Override
public String toString() {
	return "CartItemDTO [id=" + id + ", productId=" + productId + ", name=" + name + ", size=" + size + ", color="
			+ color + ", quantity=" + quantity + ", price=" + price + ", subTotal=" + subTotal + "]";
}

		 public Long getId() {
	return id;
}

  public void setId(Long id) {
	this.id = id;
  }

  public Long getProductId() {
	return productId;
  }

  public void setProductId(Long productId) {
	this.productId = productId;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
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

  public Long getQuantity() {
	return quantity;
  }

  public void setQuantity(Long quantity) {
	this.quantity = quantity;
  }

  public double getPrice() {
	return price;
  }

  public void setPrice(double price) {
	this.price = price;
  }

  public double getSubTotal() {
	return subTotal;
  }

  public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
  }

		 private String name;
	     private String size;
	     private String color;
	     private Long quantity;
     private double price;

     private double subTotal;
}
