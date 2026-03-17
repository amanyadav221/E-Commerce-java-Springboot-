package com.e_mart.DTO;

public class FeatureDTO {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	private String icon;
	private String shortDescription;
	private String status;
	@Override
	public String toString() {
		return "FeatureDTO [name=" + name + ", icon=" + icon + ", shortDescription=" + shortDescription + ", status="
				+ status + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FeatureDTO(String name, String icon, String shortDescription, String status) {
		super();
		this.name = name;
		this.icon = icon;
		this.shortDescription = shortDescription;
		this.status = status;
	}
	public FeatureDTO() {
		// TODO Auto-generated constructor stub
	}
}
