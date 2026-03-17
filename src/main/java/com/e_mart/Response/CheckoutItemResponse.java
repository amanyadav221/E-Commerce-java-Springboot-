package com.e_mart.Response;

import java.util.List;

public class CheckoutItemResponse {

	private Long checkoutId;
	
	private List<Long> itemId;
	
	private List<Long> productId;
	
	private List<String> color;
	
	private List<String> size;
	
	private List<Integer> quantity;
	
	private List<Double> price;
	
	private List<Double> totalPrice;
	
	private String orderStatus;
	
	private String paymentMode;
	
	private String paymentStatus;
	
	private Long shipping;
	
	private Long subTotal;
	
	private Long total;
	
	private Long addressId;
	
	private String dateOfOrder;

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

	public void setSubTotal(Long long1) {
		this.subTotal = long1;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long long1) {
		this.total = long1;
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

	public Long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public List<Long> getItemId() {
		return itemId;
	}

	public void setItemId(List<Long> itemId) {
		this.itemId = itemId;
	}

	public List<Long> getProductId() {
		return productId;
	}

	public void setProductId(List<Long> productId) {
		this.productId = productId;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<String> getSize() {
		return size;
	}

	public void setSize(List<String> size) {
		this.size = size;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public List<Double> getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(List<Double> totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CheckoutItemResponse [checkoutId=" + checkoutId + ", itemId=" + itemId + ", productId=" + productId
				+ ", color=" + color + ", size=" + size + ", quantity=" + quantity + ", price=" + price
				+ ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", paymentMode=" + paymentMode
				+ ", paymentStatus=" + paymentStatus + ", shipping=" + shipping + ", subTotal=" + subTotal + ", total="
				+ total + ", addressId=" + addressId + ", dateOfOrder=" + dateOfOrder + "]";
	}
	
	
}
