package com.e_mart.Entity;

import java.util.List;

import com.e_mart.Service.MainCategoryService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
public class Product {

    @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", mainCategory="
				+ mainCategory + ", subCategory=" + subCategory + ", brand=" + brand + ", color=" + color + ", size="
				+ size + ", basePrice=" + basePrice + ", discount=" + discount + ", finalPrice=" + finalPrice
				+ ", stock=" + stock + ", stockQuantity=" + stockQuantity + ", pics=" + pics + ", status=" + status
				+ "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Lob
	private String description;
    public void setDescription(String desc) {
    	this.description=desc;
    }
    public String getDescription() {
    	return this.description;
    }
    
    @ManyToOne
    private MainCatagoryClass mainCategory;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private Brand brand;

    @ElementCollection
    private java.util.List<String> color;

    @ElementCollection
    private java.util.List<String> size;

    private double basePrice;
    private double discount;
    private double finalPrice;

    private String stock;
    private int stockQuantity;

    @OneToMany(
    	    mappedBy = "product",
    	    cascade = CascadeType.ALL,
    	    orphanRemoval = false
    	)
    private java.util.List<ProductImage> pics;

    private String status;

    public Product() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public MainCatagoryClass getMainCategory() { return mainCategory; }
    public void setMainCategory(MainCatagoryClass mainCategory) { this.mainCategory = mainCategory; }

    public SubCategory getSubCategory() { return subCategory; }
    public void setSubCategory(SubCategory subCategory) { this.subCategory = subCategory; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public java.util.List<String> getColor() { return color; }
    public void setColor(java.util.List<String> color) { this.color = color; }

    public java.util.List<String> getSize() { return size; }
    public void setSize(java.util.List<String> size) { this.size = size; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(double finalPrice) { this.finalPrice = finalPrice; }

    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public java.util.List<ProductImage> getPics() { return pics; }
    public void setPics(java.util.List<ProductImage> pics) { this.pics = pics; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
