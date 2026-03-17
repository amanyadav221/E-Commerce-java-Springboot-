package com.e_mart.Controller.Public;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.FeatureDTO;
import com.e_mart.Entity.Feature;
import com.e_mart.Service.FeatureService;


@RestController
@RequestMapping("/public/feature")
public class FeaturePublicAPI {
	
	@Autowired
	private FeatureService service;

	
	@GetMapping("/get")
	private ResponseEntity<?> getFeature(){
		List<Feature> cat=service.getAllData();
		List<Long> str=new ArrayList<>();
		for(Feature c :cat) {
			str.add(c.getId());
			System.out.println("Name : "+c.getName());
			System.out.println("Name : "+c.getStatus());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(str);
	}
	
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getAll(){
		System.out.println("Getting all Feature.....");
		List<Feature> cat=service.getAllData();
		List<FeatureDTO> response = cat.stream().map(c -> {
	        FeatureDTO dto = new FeatureDTO();
	       dto.setId(c.getId());
	        dto.setName(c.getName());
	        dto.setIcon(c.getIcon());
	        dto.setShortDescription(c.getShortDescription());
	        dto.setStatus(c.getStatus());


	        return dto;
	    }).toList();
		 System.out.println("Helooooooooooooo"+response.size());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	

	
	
	@GetMapping("/get/{name}")
	private ResponseEntity<List<Feature>> getUniques(@PathVariable String name){
		List<Feature> cat=service.getByName(name);
		//System.out.println("Get By Name Triggered!!!!!!!!   in   get/name"+name+cat);
//		List<String> catName=new ArrayList<>();
//		for(MainCatagoryClass c :cat) {
//			catName.add(c.getName());
//			System.out.println("Name : "+c.getName());
//			System.out.println("Name : "+c.getStatus());
//			System.out.println("Name : "+c.getFileName());
//			System.out.println("Name : "+c.getFileType());
//			System.out.println("Name : "+c.getFileData());
//		}
		return ResponseEntity.ok(cat);
	}
	
	


}
