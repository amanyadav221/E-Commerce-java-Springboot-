
package com.e_mart.Entity;

import com.e_mart.Entity.User.Checkout;
import com.e_mart.Entity.User.MyUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "testimonials")
public class Testimonial {

    @Override
	public String toString() {
		return "Testimonial [id=" + id + ", message=" + message + ", rating=" + rating + ", product=" + product
				+ ", user=" + user + ", checkoutId=" + checkoutId + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private short rating;
    
    /* ================= PRODUCT ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    /* ================= USER ================= */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private MyUser user;
    
    @ManyToOne
    @JoinColumn(name="checkout_id",nullable=false)
    @JsonIgnore
    private Checkout checkoutId;
    
    /* ================= CONSTRUCTORS ================= */

    public Checkout getCheckout() {
		return checkoutId;
	}

	public void setCheckout(Checkout checkout_id) {
		this.checkoutId = checkout_id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Testimonial() {}

    public Testimonial(String message, short rating, Product product, MyUser user) {
        this.message = message;
        this.rating = rating;
        this.product = product;
        this.user = user;
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
