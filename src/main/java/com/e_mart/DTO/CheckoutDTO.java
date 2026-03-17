package com.e_mart.DTO;

import java.util.Arrays;


public class CheckoutDTO {
	private String username;
	private Long productIds[];
	private int quantities[];
	private String[] color;
	private String[] size;
	public String[] getColor() {
		return color;
	}
	public void setColor(String[] color) {
		this.color = color;
	}
	public String[] getSize() {
		return size;
	}
	public void setSize(String[] size) {
		this.size = size;
	}
	public int[] getQuantities() {
		return quantities;
	}
	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}
	public Long[] getProductIds() {
		return productIds;
	}
	private Long subTotal;
	private Long shipping;
	private Long total;
	private Long addressId;
	private String dateOfOrder;
	private String orderStatus;
	private String paymentMode;
	private String paymentStatus;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long[] getProductId() {
		return productIds;
	}
	public void setProductIds(Long[] productIds) {
		this.productIds = productIds;
	}
	public Long getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Long subTotal) {
		this.subTotal = subTotal;
	}
	public Long getShipping() {
		return shipping;
	}
	public void setShipping(Long shipping) {
		this.shipping = shipping;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
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
	@Override
	public String toString() {
		return "CheckoutDTO [username=" + username + ", productIds=" + Arrays.toString(productIds) + ", quantities="
				+ Arrays.toString(quantities) + ", color=" + Arrays.toString(color) + ", size=" + Arrays.toString(size)
				+ ", subTotal=" + subTotal + ", shipping=" + shipping + ", total=" + total + ", addressId=" + addressId
				+ ", dateOfOrder=" + dateOfOrder + ", orderStatus=" + orderStatus + ", paymentMode=" + paymentMode
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	

}
