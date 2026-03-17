package com.e_mart.DTO;

public class TestimonialDTO {
	private Long pId;
	private String message;
	private short rating;
	private Long userId;
	private Long checkoutId;
	public Long getCheckoutId() {
		return checkoutId;
	}
	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPId() {
		return pId;
	}
	public void setPId(Long pId) {
		this.pId = pId;
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
	public void setRating(short rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "TestimonialDTO [pId=" + pId + ", message=" + message + ", rating=" + rating + "]";
	}
}
