package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.e_mart.Entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long>{
	public List<Feature> findByName(String name);
	public List<Feature> deleteByName(String name);


}
