package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.CartItem;

import jakarta.transaction.Transactional;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	public List<CartItem> findByCartId(Long id);
	public CartItem findByProduct_id(Long id);
	@Transactional
	public void deleteByCart_idAndProduct_id(Long cartId,Long productId);
}
