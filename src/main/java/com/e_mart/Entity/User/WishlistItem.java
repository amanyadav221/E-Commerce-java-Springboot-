package com.e_mart.Entity.User;

import com.e_mart.Entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WishlistItem {
	 @Id @GeneratedValue
	    private Long id;

	    @ManyToOne
	    private Product product;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "WishlistItem [id=" + id + "]";
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Wishlist getWishlist() {
			return wishlist;
		}
		public void setWishlist(Wishlist wishlist) {
			this.wishlist = wishlist;
		}
		@ManyToOne
	    @JoinColumn(name="wishlist_id")
	    @JsonIgnoreProperties("items") 
    private Wishlist wishlist;
}
