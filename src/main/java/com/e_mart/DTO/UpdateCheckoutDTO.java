package com.e_mart.DTO;

public class UpdateCheckoutDTO {
	private String orderStatus;
	private String paymentStatus;
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "UpdateCheckoutDTO [orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + "]";
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
