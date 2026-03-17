package com.e_mart.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.Feature;
import com.e_mart.Repository.FeatureRepository;

import jakarta.transaction.Transactional;

@Service
public class FeatureService {
	@Autowired
	private FeatureRepository repo;
	public String addFeature(Feature feature) {
	try {
			repo.save(feature);
			return "Added";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception : "+e.getMessage();
		}
	}
	public String updateFeature(
	        Long id,
	        Feature newData
	) throws IOException {
		System.out.println("testing.........."+id);
		Feature f = repo.findById(id).get();
		f.setIcon(newData.getIcon());
		f.setName(newData.getName());
		f.setShortDescription(newData.getShortDescription());
		f.setStatus(newData.getStatus());
		//repo.deleteById(id);
		repo.save(f);
		return "updated......";
	}
	public List<Feature> getAllData(){
		return repo.findAll();
	}
	public List<Feature> getByName(String name){
		return repo.findByName(name);
	}
	public Feature getById(Long id) {
		return repo.findById(id).get();
	}
	@Transactional
	public String delete(Long id) {
		 repo.deleteById(id);
		 return "Deleted";
	}
}
