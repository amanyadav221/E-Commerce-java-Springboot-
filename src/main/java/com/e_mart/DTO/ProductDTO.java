package com.e_mart.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Lob;

public class ProductDTO {

    private Long id;
    private String name;
    @Lob
    private String description;
    private SimpleNameDTO mainCategory;
    private SimpleNameDTO subCategory;
    private SimpleNameDTO brand;

    private List<String> color;
    private List<String> size;

    private Double basePrice;
    private Double discount;
    private Double finalPrice;

    private String stock;
    private Integer stockQuantity;

    private List<ImageDTO> pics;
    private String status;

    public ProductDTO() {}

    /* ===================== INNER DTOs ===================== */

    public static class SimpleNameDTO {

        private String name;

        public SimpleNameDTO() {}

        public SimpleNameDTO(String name) {
            this.name = name;
        }

        @JsonCreator
        public static SimpleNameDTO from(Object value) {
            if (value instanceof String s) {
                return new SimpleNameDTO(s);
            }
            return null;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }


    public static class ImageDTO {
    	private Long id;
        private String fileType;
        private String base64;

        public ImageDTO() {}

        public ImageDTO(Long id,String fileType, String base64) {
        	this.id=id;
            this.fileType = fileType;
            this.base64 = base64;
        }
        public Long getId() {return id;}
        public void setId(Long id) {this.id=id;}
        public String getFileType() { return fileType; }
        public void setFileType(String fileType) { this.fileType = fileType; }

        public String getBase64() { return base64; }
        public void setBase64(String base64) { this.base64 = base64; }
    }

    /* ===================== GETTERS & SETTERS ===================== */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SimpleNameDTO getMainCategory() { return mainCategory; }
    public void setMainCategory(SimpleNameDTO mainCategory) { this.mainCategory = mainCategory; }

    public SimpleNameDTO getSubCategory() { return subCategory; }
    public void setSubCategory(SimpleNameDTO subCategory) { this.subCategory = subCategory; }

    public SimpleNameDTO getBrand() { return brand; }
    public void setBrand(SimpleNameDTO brand) { this.brand = brand; }

    public List<String> getColor() { return color; }
    public void setColor(List<String> color) { this.color = color; }

    public List<String> getSize() { return size; }
    public void setSize(List<String> size) { this.size = size; }

    public Double getBasePrice() { return basePrice; }
    public void setBasePrice(Double basePrice) { this.basePrice = basePrice; }
    
    public void setDescription(String desc) {
    	this.description=desc;
    }
    public String getDescription() {
    	return this.description;
    }
    
    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public Double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(Double finalPrice) { this.finalPrice = finalPrice; }

    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public List<ImageDTO> getPics() { return pics; }
    public void setPics(List<ImageDTO> pics) { this.pics = pics; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
