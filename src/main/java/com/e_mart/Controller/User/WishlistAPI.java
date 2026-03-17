package com.e_mart.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.WishlistDTO;
import com.e_mart.Service.WishlistService;

@RestController
@RequestMapping("/user/wishlist")
public class WishlistAPI {
	
	@Autowired
	private WishlistService wishlistService;
	@PostMapping("/add")
	public ResponseEntity<?> addTowishListAPI(@RequestBody WishlistDTO dto){
			System.out.println(dto);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String username = auth.getName();
		    
		    System.out.println("=======***********************8======");

		    System.out.println("=======***********************8======");

		    System.out.println("=======***********************8======");

		    System.out.println("=======***********************8======");

		    System.out.println("=======***********************8======");
		    
		    String res=wishlistService.addToWishlist(username,dto);
		    System.out.println(res);
		return new ResponseEntity<>(HttpStatus.ACCEPTED).ok( res);
		
	}
	
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	   
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(wishlistService.getMyWishlist(username));
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteWishlist(@PathVariable Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    System.out.println("Testing delete wishlist"+username);
	    wishlistService.deleteWishlist(username,id);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
	}
	
	

}
