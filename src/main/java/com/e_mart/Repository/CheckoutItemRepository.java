package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.CheckoutItem;

@Repository
public interface CheckoutItemRepository extends JpaRepository<CheckoutItem, Long>{
	public List<CheckoutItem> findByCheckout_Id(Long id);

}
