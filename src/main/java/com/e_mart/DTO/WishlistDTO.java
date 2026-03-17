package com.e_mart.DTO;

public class WishlistDTO {
	private Long productId;
	private Long quantity;
	private String color;
	private String size;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "WishlistDTO [productId=" + productId + ", quantity=" + quantity + ", color=" + color + ", size=" + size
				+ "]";
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
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
}
