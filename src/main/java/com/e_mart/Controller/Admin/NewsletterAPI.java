package com.e_mart.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Service.NewsletterService;

@RestController
@RequestMapping("/admin/newsletter")
public class NewsletterAPI {
	
	@Autowired
	private NewsletterService newsService;
	
	@GetMapping("/get")
	public ResponseEntity<?> gettingNewsletter(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(newsService.getAll());
		   
		
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateNewsletter(@PathVariable Long id){
		System.out.println("Updating newsletter "+id);
			newsService.update(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteNewsletter(@PathVariable Long id){
		System.out.println("Deleting News Letter "+id);
		
		newsService.deleteNewsletter(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}

}
