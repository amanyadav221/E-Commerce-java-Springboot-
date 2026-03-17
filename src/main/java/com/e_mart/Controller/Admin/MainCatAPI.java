package com.e_mart.Controller.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.Entity.MainCatagoryClass;

import com.e_mart.Service.MainCategoryService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController 
@RequestMapping("/admin/main-cat")
public class MainCatAPI {

	@Autowired
	private MainCategoryService service;


	@PostMapping( value = "/add",
			  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	private ResponseEntity<String> addMainCategory(
			@RequestPart
			MainCatagoryClass mainCategory,
			@RequestPart MultipartFile file){
		System.out.println(mainCategory);
		MainCatagoryClass x=service.getByName(mainCategory.getName());
		System.out.println(x);
		if(!(x==null)) {
			return  ResponseEntity.status(HttpStatus.CREATED).body("Data already exists!!!!!!!");
		}else {
			System.out.println("Hello   "+service.addMainCategory(mainCategory, file));
			return ResponseEntity.status(HttpStatus.CREATED).body("Data Created!!!!!!!");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MainCatagoryClass> update(
			  @PathVariable String id,
			    @RequestPart("mainCategory") MainCatagoryClass mainCategory,
			    @RequestPart(value = "file", required = false) MultipartFile file) throws Throwable{
				System.out.println("In update   "+mainCategory);
				
				
				System.out.println("Hello  from update "+service.updateMainCategory(id,mainCategory, file));
			System.out.println();
			return new ResponseEntity<>(HttpStatus.CREATED).ok(service.getByName(mainCategory.getName()));
				
	}
	@DeleteMapping("/del/{name}")
	public ResponseEntity<MainCatagoryClass> del(@PathVariable String name) {
		//System.out.println(name.get("name")+"   jehgfj");
		MainCatagoryClass cat= service.getByName(name);
		service.delete(name);
		return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(cat);
	}

}
