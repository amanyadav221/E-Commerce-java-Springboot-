package com.e_mart.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class SettingDTO {
	private String siteName;
	private String addressOne;
	private String addressTwo;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String mapOne;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String mapTwo;
	private String email;
	private String phone;
	private String whatsapp;
	private String linkedIn;
	private String gitHub;
	private String instagram;
	private Long products;
	private Long brands;
	private Long customer;
	private Long refund;
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public Long getRefund() {
		return refund;
	}
	public void setRefund(Long refund) {
		this.refund = refund;
	}
	public Long getProducts() {
		return products;
	}
	public void setProducts(Long products) {
		this.products = products;
	}
	public Long getBrands() {
		return brands;
	}
	public void setBrands(Long brands) {
		this.brands = brands;
	}
	public SettingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SettingDTO(String siteName, String addressOne, String addressTwo, String mapOne, String mapTwo, String email,
			String phone, String whatsapp, String linkedIn, String gitHub, String instagram) {
		super();
		this.siteName = siteName;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.mapOne = mapOne;
		this.mapTwo = mapTwo;
		this.email = email;
		this.phone = phone;
		this.whatsapp = whatsapp;
		this.linkedIn = linkedIn;
		this.gitHub = gitHub;
		this.instagram = instagram;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getMapOne() {
		return mapOne;
	}
	public void setMapOne(String mapOne) {
		this.mapOne = mapOne;
	}
	public String getMapTwo() {
		return mapTwo;
	}
	public void setMapTwo(String mapTwo) {
		this.mapTwo = mapTwo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getGitHub() {
		return gitHub;
	}
	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	@Override
	public String toString() {
		return "Setting [siteName=" + siteName + ", addressOne=" + addressOne + ", addressTwo=" + addressTwo
				+ ", mapOne=" + mapOne + ", mapTwo=" + mapTwo + ", email=" + email + ", phone=" + phone + ", whatsapp="
				+ whatsapp + ", linkedIn=" + linkedIn + ", gitHub=" + gitHub + ", instagram=" + instagram + "]";
	}

}
