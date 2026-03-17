package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.e_mart.DTO.MyUserDTO;
import com.e_mart.DTO.UpdateUserByAdminDTO;
import com.e_mart.Entity.User.Cart;
import com.e_mart.Entity.User.MyUser;
import com.e_mart.Entity.User.USER_ROLE;
import com.e_mart.Entity.User.Wishlist;
import com.e_mart.Repository.MyUserRepository;
import com.e_mart.Response.UserResp;

@Service
public class MyUserService {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private MyUserRepository repo;
	public MyUser getUserByUsername(String username) {
		return repo.findByUsername(username);
	}
	public MyUser getUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	public MyUser addNewUser(MyUser oldUser) {
		//MyUser user=new MyUser(oldUser.getFullName(), oldUser.getUsername(), oldUser.getEmail(), oldUser.getPhone(),encoder.encode(oldUser.getPassword()));
		try {
			return repo.save(oldUser);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	public List<MyUser> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public List<UserResp> getAllUserForAdmin() {
		// TODO Auto-generated method stub
		List<MyUser> userList=repo.findAll();
		List<UserResp> res=new ArrayList<>();
		for(MyUser user: userList) {
			UserResp r=new UserResp();
				r.setFullName(user.getFullName());
				r.setUsername(user.getUsername());
				r.setEmail(user.getEmail());
				r.setPhone(user.getPhone());
				r.setRole(user.getRole().toString());
				r.setStatus(user.getStatus());
				r.setId(user.getId());
				//System.out.println(r.getStatus());
				res.add(r);
			
		}
		return res;
	}
	public MyUser deleteByUsername(String username) {
		return repo.deleteByUsername(username);
	}
	public Cart getMyCart(String username) {
		MyUser user=repo.findByUsername(username);
		
		return user.getCart();
}
	public Wishlist getMyWishlist(String username) {
		return repo.findByUsername(username).getWishlist();
	}
	public String updateUser(Long id, UpdateUserByAdminDTO dto) {
		// TODO Auto-generated method stub
		MyUser user=repo.findById(id).get();
		user.setStatus(dto.getStatus());
		if(dto.getRole().equals("ROLE_USER"))
			user.setRole(USER_ROLE.ROLE_USER);
		else
			user.setRole(USER_ROLE.ROLE_ADMIN);
		repo.save(user);
		return "Updated";
	}
	public String deleteByUsername(long id) {
		repo.deleteById(id);
		return "deleted";
	}
}
