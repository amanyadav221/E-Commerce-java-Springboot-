package com.e_mart.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.Entity.Brand;
import com.e_mart.Service.BrandService;


@RestController
@RequestMapping("/admin/brand")
public class BrandAPI {
	
	@Autowired
	private BrandService service;
	
	@PostMapping( value = "/add",
			  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	private ResponseEntity<String> addBrand(
			@RequestPart
			Brand brand,
			@RequestPart MultipartFile file){
		System.out.println(brand);
		Brand x=service.getByName(brand.getName());
		System.out.println(x);
		if(!(x==null)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Data already exists!!!!!!!");
		}else {
			System.out.println("Hello   "+service.AddBrand(brand, file));
			return ResponseEntity.status(HttpStatus.CREATED).body("Data Created!!!!!!!");
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Brand> update(
			  @PathVariable String id,
			    @RequestPart("brand") Brand brand,
			    @RequestPart(value = "file", required = false) MultipartFile file) throws Throwable{
				System.out.println("In update   "+brand);
				
				
				System.out.println("Hello  from update "+service.updateBrand(id,brand, file));
			System.out.println();
			return ResponseEntity.status(HttpStatus.CREATED).body(service.getByName(brand.getName()));
				
	}
	@DeleteMapping("/del/{name}")
	public ResponseEntity<Brand> del(@PathVariable String name) {
		System.out.println(name);
		Brand cat= service.getByName(name);
		service.delete(name);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
	}

}
