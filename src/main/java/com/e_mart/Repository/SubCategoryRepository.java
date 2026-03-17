package com.e_mart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.e_mart.Entity.SubCategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, String>{
	public List<SubCategory> findByName(String name);
	public List<SubCategory> deleteByName(String name);
	public Optional findById(String name);

}
