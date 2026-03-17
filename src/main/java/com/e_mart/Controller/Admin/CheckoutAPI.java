package com.e_mart.Controller.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.UpdateCheckoutDTO;
import com.e_mart.Repository.AddressRepository;
import com.e_mart.Response.CheckoutItemResponse;
import com.e_mart.Service.CheckoutService;

@RestController
@RequestMapping("/admin/checkout")
public class CheckoutAPI {
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private AddressRepository adrsRepo;
	@GetMapping("/get-all")
	public ResponseEntity<?> getting(){
		List<CheckoutItemResponse> orders=checkoutService.admnGetAllCheckout();
		   Map<String, Object> res=new HashMap<>();
		   res.put("message","");
		   res.put("orders", orders);
		  return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
	}
	@GetMapping("/get-all-adrs")
	public ResponseEntity<?> gettingAddress(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(adrsRepo.findAll());
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateCheckoutById(@PathVariable Long id,@RequestBody UpdateCheckoutDTO dto){
//		System.out.println(dto);
//		System.out.println(dto);
//		System.out.println(dto);
//		System.out.println(dto);
//		System.out.println(dto);
//		System.out.println(dto);
		checkoutService.update(id, dto);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		
	}

}
