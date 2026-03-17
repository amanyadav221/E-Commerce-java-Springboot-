package com.e_mart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.WishlistItem;

import jakarta.transaction.Transactional;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long>{
	
	
	public WishlistItem findByProductIdAndWishlistId(Long productId, Long wishlistId);
	
	public WishlistItem findByProductId(Long id);

	    @Modifying(clearAutomatically = true, flushAutomatically = true)
	    @Transactional
	    @Query("""
	       DELETE FROM WishlistItem w
	       WHERE w.wishlist.id = :wishlistId
	       AND w.product.id = :productId
	    """)
	    int deleteByWishlistAndProduct(@Param("wishlistId") Long wishlistId,
	                                   @Param("productId") Long productId);
	
}
