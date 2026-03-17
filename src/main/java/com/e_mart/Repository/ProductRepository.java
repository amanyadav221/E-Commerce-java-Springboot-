package com.e_mart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
