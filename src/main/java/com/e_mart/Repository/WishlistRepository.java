package com.e_mart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	public Wishlist findByUserUsername(String username);
}
