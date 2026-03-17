package com.e_mart.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Service.ContactUsService;

@RestController
@RequestMapping("/admin/contact-us")
public class ContactUsAPI {
	@Autowired
	private ContactUsService service;
	@GetMapping("/get")
	public ResponseEntity<?> getting(){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.gettingAll());
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updating(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id));
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleting(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.delete(id));
	}

}
