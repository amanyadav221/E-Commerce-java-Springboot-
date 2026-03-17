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

import com.e_mart.DTO.FaqDTO;
import com.e_mart.Entity.Faq;
import com.e_mart.Service.FaqService;

@RestController
@RequestMapping("/public/faq")
public class FaqPublicAPI {
	@Autowired
	private FaqService faqService;

	
	@GetMapping("/get")
	private ResponseEntity<?> getFaq(){
		List<Faq> cat=faqService.getAllData();
		List<String> str=new ArrayList<>();
		for(Faq c :cat) {
			str.add(c.getQuestion());
			System.out.println("Name : "+c.getQuestion());
			System.out.println("Name : "+c.getStatus());
		}
		return ResponseEntity.ok(str);
	}
	
	
	@GetMapping("/get-all")
	private ResponseEntity<List<FaqDTO>> getAll(){
		System.out.println("Getting all Feature.....");
		List<Faq> cat=faqService.getAllData();
		List<FaqDTO> response = cat.stream().map(c -> {
	        FaqDTO dto = new FaqDTO();
	        dto.setId(c.getId());
	        dto.setQuestion(c.getQuestion());
	        dto.setAnswer(c.getAnswer());
	        dto.setStatus(c.getStatus());


	        return dto;
	    }).toList();
		 System.out.println("Helooooooooooooo"+response.size());
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
	private ResponseEntity<List<Faq>> getUniques(@PathVariable String question){
		List<Faq> cat=faqService.getByName(question);
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
