package com.e_mart.Controller.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.FeatureDTO;
import com.e_mart.Entity.Feature;
import com.e_mart.Service.FeatureService;


@RestController
@RequestMapping("/admin/feature")
public class FeatureAPI {
	
	@Autowired
	private FeatureService service;
	
	@PostMapping("/add")
	private ResponseEntity<String> addFeature(
			@RequestBody	Feature feature){
		System.out.println(feature);
		List<Feature> x=service.getByName(feature.getName());
		System.out.println(x);
		if(!x.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Data already exists!!!!!!!");
		}else {
			System.out.println("Hello   "+service.addFeature(feature));
			return  ResponseEntity.status(HttpStatus.CREATED).body("Data Created!!!!!!!");
		}
	}
	
	
	
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> update(
			  @PathVariable Long id,
			    @RequestBody Feature feature) throws Throwable{
				System.out.println("In update   "+feature);
				
				
			System.out.println("Hello  from update "+service.updateFeature(id, feature));
			System.out.println();
			return  ResponseEntity.status(HttpStatus.CREATED).body(service.getById(id));
				
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Feature> del(@PathVariable Long id) {
		System.out.println(id);
		Feature cat= service.getById(id);
		service.delete(id);
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
	}


}
