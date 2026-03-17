package com.e_mart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feature")
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String name;
	@Override
	public String toString() {
		return "Feature [name=" + name + ", icon=" + icon + ", shortDescription=" + shortDescription + ", status="
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
	public Feature() {
		super();
		// TODO Auto-generated constructor stub
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
	public Feature(String name, String icon, String shortDescription, String status) {
		super();
		this.name = name;
		this.icon = icon;
		this.shortDescription = shortDescription;
		this.status = status;
	}
	private String icon;
	private String shortDescription;
	private String status;
}
