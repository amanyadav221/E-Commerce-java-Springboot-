package com.e_mart.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.UpdateUserByAdminDTO;
import com.e_mart.Service.MyUserService;

@RestController
@RequestMapping("/admin/user")
public class UserAPIForAdmin {
	
	@Autowired
	private MyUserService service;
	@GetMapping("/get-all")
	public ResponseEntity<?> gettingAll(){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllUserForAdmin());
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updating(@PathVariable Long id,@RequestBody UpdateUserByAdminDTO dto){
		
//		System.out.println(id+" hello "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
//		System.out.println(id+" "+dto);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateUser(id,dto));
		
	}
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleting(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.deleteByUsername(id));
	}

}
