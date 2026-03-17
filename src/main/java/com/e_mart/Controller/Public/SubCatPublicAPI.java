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
import com.e_mart.DTO.SubCategoryDTO;
import com.e_mart.Entity.SubCategory;
import com.e_mart.Service.SubCategoryService;

@RestController
@RequestMapping("/public/sub-cat")
public class SubCatPublicAPI {
	@Autowired
	private SubCategoryService service;

	@GetMapping("/get")
	private ResponseEntity<List<String>> getSubData(){
		List<SubCategory> cat=service.getData();
		List<String> str=new ArrayList<>();
		for(SubCategory c :cat) {
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
	private ResponseEntity<List<SubCategoryDTO>> getAll(){
		System.out.println("Getting all sub cat.....");
		List<SubCategory> cat=service.getData();
		List<SubCategoryDTO> response = cat.stream().map(c -> {
	        SubCategoryDTO dto = new SubCategoryDTO();
 
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
	
	
//	@GetMapping("/get-name/{name}")
//	private ResponseEntity<List<String>> getCat(@PathVariable String name){
//		System.out.println("Get By Name Triggered!!!!!!!!");
//		List<SubCategory> cat=service.getByName(name);
//		List<String> catName=new ArrayList<>();
//		for(SubCategory c :cat) {
//			catName.add(c.getName());
//			System.out.println("Name : "+c.getName());
//			System.out.println("Name : "+c.getStatus());
//			System.out.println("Name : "+c.getFileName());
//			System.out.println("Name : "+c.getFileType());
//			System.out.println("Name : "+c.getFileData());
//		}
//		return ResponseEntity.ok(catName);
//	}
	
	
	@GetMapping("/get/{name}")
	private ResponseEntity<SubCategory> getUniques(@PathVariable String name){
		SubCategory cat=service.getByName(name);
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
