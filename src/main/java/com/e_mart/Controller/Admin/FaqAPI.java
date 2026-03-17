package com.e_mart.Controller.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Entity.Faq;
import com.e_mart.Service.FaqService;

@RestController
@RequestMapping("/admin/faq")
public class FaqAPI {
	@Autowired
	private FaqService faqService;
	
	@PostMapping("/add")
	private ResponseEntity<String> addFaq(
			@RequestBody	Faq faq){
		System.out.println(faq);
		List<Faq> x=faqService.getByName(faq.getQuestion());
		System.out.println(x);
		if(!x.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.CREATED).ok("Data already exists!!!!!!!");
		}else {
			System.out.println("Hello   "+faqService.AddFaq(faq));
			return new ResponseEntity<>(HttpStatus.CREATED).ok("Data Created!!!!!!!");
		}
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<List<Faq>> update(
			  @PathVariable Long id,
			    @RequestBody Faq faq) throws Throwable{
				System.out.println("In update   "+faq);
				
				
			System.out.println("Hello  from update "+faqService.updateFaq(id, faq));
			System.out.println();
			return new ResponseEntity<>(HttpStatus.CREATED).ok(faqService.getByName(faq.getQuestion()));
				
	}
	@DeleteMapping("/del/{name}")
	public ResponseEntity<Faq> del(@PathVariable String name) {
		System.out.println(name);
		Faq cat= faqService.getByName(name).get(0);
		faqService.delete(name);
		return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(cat);
	}


}
