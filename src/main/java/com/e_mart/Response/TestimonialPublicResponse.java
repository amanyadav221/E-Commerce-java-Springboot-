package com.e_mart.Response;

public class TestimonialPublicResponse {
	private Long userId;
	private String username;
	private String fullName;
	private Long productId;
	private String message;
	private short rating;
	private Long checkoutId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public short getRating() {
		return rating;
	}
	public void setRating(short s) {
		this.rating = s;
	}
	public Long getCheckoutId() {
		return checkoutId;
	}
	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}
	@Override
	public String toString() {
		return "TestimonialPublicResponse [userId=" + userId + ", username=" + username + ", fullName=" + fullName
				+ ", productId=" + productId + ", message=" + message + ", rating=" + rating + ", checkoutId="
				+ checkoutId + "]";
	}
	
}
