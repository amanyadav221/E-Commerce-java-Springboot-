package com.e_mart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.Brand;
import com.e_mart.Entity.MainCatagoryClass;
@Repository
public interface BrandRepository extends JpaRepository<Brand, String>{
	public List<Brand> findByName(String name);
	public List<Brand> deleteByName(String name);
	public Optional findById(String name);

}
