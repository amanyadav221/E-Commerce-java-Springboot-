package com.e_mart.DTO;

import java.util.List;

import com.e_mart.Entity.Product;

public class WishlistResDTO {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
