package com.e_mart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	public Cart findByUser_Id(Long id);
	@Query("""
			SELECT c FROM Cart c
			LEFT JOIN FETCH c.items
			WHERE c.user.username = :username
			""")
			Optional<Cart> findByUsernameWithItems(String username);


}
