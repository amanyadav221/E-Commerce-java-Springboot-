package com.e_mart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.MainCatagoryClass;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCatagoryClass, String>{
	public List<MainCatagoryClass> findByName(String name);
	public List<MainCatagoryClass> deleteByName(String name);
	public Optional findById(String name);

}
