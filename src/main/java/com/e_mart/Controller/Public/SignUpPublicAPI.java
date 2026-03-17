package com.e_mart.Controller.Public;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Configuration.JwtProvider;
import com.e_mart.DTO.MyUserDTO;

import com.e_mart.Entity.User.Address;
import com.e_mart.Entity.User.Cart;
import com.e_mart.Entity.User.MyUser;
import com.e_mart.Entity.User.USER_ROLE;
import com.e_mart.Request.LoginRequest;
import com.e_mart.Response.LoginResponse;
import com.e_mart.Service.AddressService;
import com.e_mart.Service.CartService;
import com.e_mart.Service.CustomUserDetailsService;
import com.e_mart.Service.MyUserService;
import com.e_mart.Service.TestimonialService;

@RestController
@RequestMapping("/public")
public class SignUpPublicAPI {

    private final PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserDetailsService customUserDetailService;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private MyUserService service;
	@Autowired
	private CartService cartService;
	@Autowired
	private TestimonialService testimonialService;


    SignUpPublicAPI(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	@PostMapping("/add")
	public ResponseEntity<String> addNewUser(@RequestBody MyUserDTO dto){
		System.out.println("MyUser adding....."+dto);
		
		MyUser user=service.getUserByEmail(dto.getEmail());
		if(user!=null) {
			if(user.getUsername().equals(dto.getUsername()))
				return new ResponseEntity<>(HttpStatus.ACCEPTED).ok("Username already exists!!!");
			else if(user.getEmail().equals(dto.getEmail()))
				return new ResponseEntity<>(HttpStatus.ACCEPTED).ok("Email already exists!!!");
		}
		MyUser newUser=new MyUser();
		if(dto.getUsername()!=null)
			newUser.setUsername(dto.getUsername());
		if(dto.getFullName()!=null)
			newUser.setFullName(dto.getFullName());
		if(dto.getEmail()!=null)
			newUser.setEmail(dto.getEmail());
		if(dto.getPhone()!=null)
			newUser.setPhone(dto.getPhone());
		if(dto.getPassword()!=null)
			newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
		newUser.setRole(USER_ROLE.ROLE_USER);
		newUser.setStatus("true");
		
		
		MyUser savedUSer=service.addNewUser(newUser);
		Cart cart=new Cart();
		cart.setUser(savedUSer);
		cartService.addCart(cart);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED).ok("User Registered Successfully!!!!!!!");
	}
	@GetMapping("/get-all")
	public List<MyUser> getAll(){
		return service.getAllUser();
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> getLogin(@RequestBody LoginRequest req){
		System.out.println(req);
		String username=req.getUsername();
		String password=req.getPassword();
		MyUser user=service.getUserByUsername(username);
		LoginResponse res=new LoginResponse();
		try {
			Authentication auth=authenticate(username,password);
			System.out.println(auth);
			String jwt=jwtProvider.generateToken(auth);
			
			System.out.println(jwt);
			res.setFullName(user.getFullName());
			res.setUsername(user.getUsername());
			res.setJwt(jwt);
			System.out.println("login Res  "+res+"\n"+user.getRole());
			res.setRole(user.getRole().toString().equals("ROLE_USER")?"USER":"ADMIN");
			System.out.println("login Res  "+res);
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
		} catch (Exception e) {
			String error=e.getMessage();
			if(error.equals("Invalid username!!!!")) {
				System.out.println("Invalid Username");
				res.setUsernameError(error);
				return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(res);
			}else if(error.equals("Invalid Password")) {
				System.out.println("Invalid Password");
				res.setPassworderror(error);
				return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(res);
			}
			e.getMessage();
			return null;
				
		}
			
	}
	
	private Authentication authenticate(String username,String password) {
		System.out.println("Testing");
		UserDetails userDetails=null;
		try {
			userDetails=customUserDetailService.loadUserByUsername(username);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(userDetails);
		if(userDetails==null) {
			//System.out.println("Testing");
			throw new BadCredentialsException("Invalid username!!!!");
		}
		if(!(passwordEncoder.matches(password, userDetails.getPassword()))) {
			throw new BadCredentialsException("Invalid Password");
		}
			
		return new UsernamePasswordAuthenticationToken(username, null,userDetails.getAuthorities());
	}
	
@GetMapping("/testimonials/get-by-pId/{id}")
public ResponseEntity<?> gettingByPid(@PathVariable Long id){
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println(id);
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.getByPid(id));
}
@GetMapping("/testimonials/get-all")
public ResponseEntity<?> gettingAllTestimonial(){
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(testimonialService.gettingAll());
}

}
