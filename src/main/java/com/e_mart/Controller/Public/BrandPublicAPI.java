package com.e_mart.Controller.Public;

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

import com.e_mart.DTO.BrandDTO;
import com.e_mart.Entity.Brand;
import com.e_mart.Service.BrandService;


@RestController
@RequestMapping("/public/brand")
public class BrandPublicAPI {
	
	@Autowired
	private BrandService service;
	
	@GetMapping("/get")
	private ResponseEntity<List<String>> getBrand(){
		List<Brand> cat=service.getAllData();
		List<String> str=new ArrayList<>();
		for(Brand c :cat) {
			str.add(c.getName());
			System.out.println("Name : "+c.getName());
			System.out.println("Name : "+c.getStatus());
			System.out.println("Name : "+c.getFileName());
			System.out.println("Name : "+c.getFileType());
			System.out.println("Name : "+c.getFileData());
		}
		return ResponseEntity.ok(str);
	}
	
	
	@GetMapping("/get-all")
	private ResponseEntity<List<BrandDTO>> getAll(){
		System.out.println("Getting all brand.....");
		List<Brand> cat=service.getAllData();
		List<BrandDTO> response = cat.stream().map(c -> {
	        BrandDTO dto = new BrandDTO();
 
	        dto.setName(c.getName());
	        dto.setStatus(c.getStatus());
	        dto.setFileName(c.getFileName());
	        dto.setFileType(c.getFileType());

	        dto.setFile(
	            Base64.getEncoder().encodeToString(c.getFileData())
	        );

	        return dto;
	    }).toList();
		return ResponseEntity.ok(response);
	}
	

	@GetMapping("/get/{name}")
	private ResponseEntity<Brand> getUniques(@PathVariable String name){
		Brand cat=service.getByName(name);
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
	
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Brand> update(
			  @PathVariable String id,
			    @RequestPart("brand") Brand brand,
			    @RequestPart(value = "file", required = false) MultipartFile file) throws Throwable{
				System.out.println("In update   "+brand);
				
				
				System.out.println("Hello  from update "+service.updateBrand(id,brand, file));
			System.out.println();
			return new ResponseEntity<>(HttpStatus.CREATED).ok(service.getByName(brand.getName()));
				
	}
}
