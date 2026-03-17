package com.e_mart.Controller.Admin;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.e_mart.Entity.SubCategory;
import com.e_mart.Service.SubCategoryService;

@RestController
@RequestMapping("/admin/sub-cat")
public class SubCatAPI {
	@Autowired
	private SubCategoryService service;
	
	@PostMapping( value = "/add",
			  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	private ResponseEntity<String> addSubCategory(
			@RequestPart
			SubCategory subCat,
			@RequestPart MultipartFile file){
		System.out.println(subCat+"    "+file);
		SubCategory x=service.getByName(subCat.getName());
		System.out.println(x);
		if(!(x==null)) {
			return new ResponseEntity<>(HttpStatus.CREATED).ok("Data already exists!!!!!!!");
		}else {
			System.out.println("Hello   "+service.addSubCategory(subCat, file));
			return new ResponseEntity<>(HttpStatus.CREATED).ok("Data Created!!!!!!!");
		}
	}
	
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SubCategory> update(
			  @PathVariable String id,
			    @RequestPart("subCategory") SubCategory subCat,
			    @RequestPart(value = "file", required = false) MultipartFile file) throws Throwable{
				System.out.println("In update   "+subCat);
				
				
				System.out.println("Hello  from update "+service.updateSubCategory(id,subCat, file));
			System.out.println();
			return new ResponseEntity<>(HttpStatus.CREATED).ok(service.getByName(subCat.getName()));
				
	}
	@DeleteMapping("/del/{name}")
	public ResponseEntity<SubCategory> del(@PathVariable String name) {
		System.out.println(name);
		SubCategory cat= service.getByName(name);
		service.delete(name);
		return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(cat);
	}
	
	

}
