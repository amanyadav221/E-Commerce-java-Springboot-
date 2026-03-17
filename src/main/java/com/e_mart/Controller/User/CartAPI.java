package com.e_mart.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.e_mart.DTO.CartDTO;
import com.e_mart.DTO.CartItemDTO;
import com.e_mart.Entity.User.Cart;
import com.e_mart.Entity.User.CartItem;
import com.e_mart.Service.CartItemService;
import com.e_mart.Service.CartService;

@RestController
@RequestMapping("/user/cart")
public class CartAPI {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/get")
	public ResponseEntity<List<CartItemDTO>> gettingCart(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 

		System.out.println("Username "+username);
		System.out.println("getting cart size  "+cartService.getMyCart(username).size());
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.getMyCart(username));
	}
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteCartItem(@PathVariable Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		System.out.println("iddddddddd "+id);
		cartItemService.deleteCartItem(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
	}
	@DeleteMapping("/del/pId/{id}")
	public ResponseEntity<?> deleteCartItemByPid(@PathVariable Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		System.out.println("iddddddddd "+id);
		Long cId=cartItemService.deleteCartItemByPid(id,username);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cId);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addingCartItem(@RequestBody CartDTO item ){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    System.out.println(item);
	    String res=cartService.addToCart(username,item);
	    
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
		
		
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updatingCartItem(@RequestBody CartDTO dto, @PathVariable Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println(dto);
	    System.out.println();
	    System.out.println(id);
	    System.out.println();
	    
	    cartService.updateCartItem(id,dto,username);
	    
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
	}

}
