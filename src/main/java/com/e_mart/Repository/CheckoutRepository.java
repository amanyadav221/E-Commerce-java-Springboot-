package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	public List<Checkout> findByUser_id(Long id);
}
