package com.e_mart.Controller.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.CheckoutDTO;
import com.e_mart.DTO.ContactUsDTO;
import com.e_mart.DTO.MyUserDTO;
import com.e_mart.DTO.NewsletterDTO;
import com.e_mart.DTO.TestimonialDTO;

import com.e_mart.Entity.User.Address;

import com.e_mart.Entity.User.MyUser;

import com.e_mart.Response.CheckoutItemResponse;
import com.e_mart.Service.AddressService;
import com.e_mart.Service.CheckoutService;
import com.e_mart.Service.ContactUsService;
import com.e_mart.Service.MyUserService;
import com.e_mart.Service.NewsletterService;
import com.e_mart.Service.TestimonialService;

@RestController
@RequestMapping("/user")
public class UserAPI {
	@Autowired
	private MyUserService service;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private NewsletterService newsService;
	@Autowired
	private ContactUsService contactUsService;
	@Autowired
	private TestimonialService testimonialService;

	@GetMapping("/get/{username}")
	public ResponseEntity<MyUserDTO> getUserByUsername(@PathVariable String username){
		
		MyUser user=service.getUserByUsername(username);
		MyUserDTO dto=new MyUserDTO();
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setFullName(user.getFullName());
		dto.setPhone(user.getPhone());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
		
	}
	
	@PatchMapping("/update/{username}")
	public ResponseEntity<MyUserDTO> updateUser(@RequestBody MyUserDTO newUSer,@PathVariable String username){
		System.out.println(newUSer);
		System.out.println(username);
		MyUser oldUser=service.getUserByUsername(username);
		System.out.println(oldUser);
		if(newUSer.getUsername()!=null)
			oldUser.setUsername(newUSer.getUsername());
		if(newUSer.getFullName()!=null)
			oldUser.setFullName(newUSer.getFullName());
		if(newUSer.getEmail()!=null)
			oldUser.setEmail(newUSer.getEmail());
		if(newUSer.getPhone()!=null)
			oldUser.setPhone(newUSer.getPhone());
		
		System.out.println(oldUser);
		//newUSer.setPassword(oldUser.getPassword());
		//newUSer.setRole(oldUser.getRole());
		//service.deleteByUsername(username);
		service.addNewUser(oldUser);
	
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUSer);
	}
	
	@PostMapping("/add-adrs")
	public ResponseEntity<String> addNewaddress(@RequestBody Address address){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		 //  address.setUsername(username);
		MyUser user=service.getUserByUsername(username);
		System.out.println(address);
		address.setUser(user);
		System.out.println(address);
		addressService.addAddress(address);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("address added");
		
	}
	@GetMapping("/get-all-adrs")
	public ResponseEntity<List<Address>> gettingAllAddress(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		System.out.println("Testig");
		String userId=username;
		System.out.println("No of address of "+username+" user"+addressService.getAllAddressByUsername(userId).size());
		List<Address> add=addressService.getAllAddressByUsername(userId);
		for(Address a : add) {
			
			a.setUser(service.getUserByUsername(username));
			System.out.println(a);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(add);
	}
	@DeleteMapping("/del-adrs/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<String> handleDeleteAddress(@PathVariable Long id){
		System.out.println("Id : "+id);
		try {
			addressService.deleteAddressByid(id);
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Address Delete Success!!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return  ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}
	
	@PatchMapping("/update-adrs/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<?> updateAddress(@RequestBody Address newAddress,
			@PathVariable Long id
			){
		
		Address oldAddress=addressService.getById(id);
		if(newAddress.getArea()!=null)
			oldAddress.setArea(newAddress.getArea());
		if(newAddress.getCity()!=null)
			oldAddress.setCity(newAddress.getCity());
		if(newAddress.getHno()!=null)
			oldAddress.setHno(newAddress.getHno());
		if(newAddress.getLandmark()!=null)
			oldAddress.setLandmark(newAddress.getLandmark());
		if(newAddress.getName()!=null)
			oldAddress.setName(newAddress.getName());
		if(newAddress.getPhone()!=null)
			oldAddress.setPhone(newAddress.getPhone());
		if(newAddress.getPinCode()!=null)
			oldAddress.setPinCode(newAddress.getPinCode());
		if(newAddress.getState()!=null)
			oldAddress.setState(newAddress.getState());
		if(newAddress.getUser()!=null)
			oldAddress.setUser(newAddress.getUser());
		
		try {
			addressService.addAddress(oldAddress);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(oldAddress);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return ResponseEntity.ok(Map.of("message", e.getMessage()));
		}
	}
	
	@PostMapping("/checkout/add")
	public ResponseEntity<?> addingCheckout(@RequestBody CheckoutDTO checkout){
		System.out.println(checkout);
		String message=checkoutService.addCheckout(checkout);
		
		
		Map<String, Object> res=new HashMap<>();
		   res.put("message",message);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
		
	}
	@GetMapping("/checkout/get-all")
	public ResponseEntity<?> gettingAllCheckout(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName();
		   List<CheckoutItemResponse> orders=checkoutService.getAllCheckout(username);
		   Map<String, Object> res=new HashMap<>();
		   res.put("message","");
		   res.put("orders", orders);
		  return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
	}
	@PostMapping("/newsletter/create")
	public ResponseEntity<?> creatingNewslatter(@RequestBody NewsletterDTO letter){
		System.out.println(letter);
		System.out.println(letter);
		System.out.println(letter);
		System.out.println(letter);
		System.out.println(letter);
		System.out.println(letter);
		System.out.println(letter.getEmail());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		System.out.println(newsService.createNewsletter(username, letter.getEmail()));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newsService.createNewsletter(username, letter.getEmail()));
		
	}
	
	@PostMapping("/contact-us/create")
	public ResponseEntity<?> creatingContactus(@RequestBody ContactUsDTO contactUs){
		
//		System.out.println(contactUs);
//		System.out.println(contactUs);
//		System.out.println(contactUs);
//		System.out.println(contactUs);
//		System.out.println(contactUs);
//		System.out.println(contactUs);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		contactUsService.create(username, contactUs);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		
		
	}
	@PostMapping("/testimonials/add")
	public ResponseEntity<?> createTestimonials(@RequestBody TestimonialDTO dto){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName(); 
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.createService(dto, username));
	}
	@GetMapping("/testimonials/get")
	public ResponseEntity<?> getTestimonial(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName();
		   
		   
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.getByUsername(username));
	}
	@PatchMapping("/testimonials/update")
	public ResponseEntity<?> update(@RequestBody TestimonialDTO dto){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName();

		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.updateTestimonial(dto, username));
	}
	@DeleteMapping("/testimonials/del/{pId}")
	public ResponseEntity<?> deleting(@PathVariable Long pId){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   String username= auth.getName();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.deleteTestimonial(pId, username));
	}
	

}
