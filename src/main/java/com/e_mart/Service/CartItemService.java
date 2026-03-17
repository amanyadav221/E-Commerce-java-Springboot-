package com.e_mart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.User.CartItem;
import com.e_mart.Repository.CartItemRepository;
import com.e_mart.Repository.CartRepository;
import com.e_mart.Repository.MyUserRepository;


@Service
public class CartItemService {
	@Autowired
	private CartItemRepository repo;

	@Autowired 
	private CartRepository cartRepo;
	@Autowired
	private MyUserRepository userRepo;
	
	public  CartItem addNewCartItem(CartItem item) {
		return repo.save(item);
	}


	public List<CartItem> getMyItem(Long id) {
		// TODO Auto-generated method stub
		System.out.println("CArt item   "+id+"  "+repo.findByCartId(id));
		
		return repo.findByCartId(id);
	}
	public void deleteCartItem(Long id) {
		repo.deleteById(id);
	}


	public Long deleteCartItemByPid(Long id, String username) {
		// TODO Auto-generated method stub
		Long userId=userRepo.findByUsername(username).getId();
		Long cartId=cartRepo.findByUser_Id(userId).getId();
		
		//Long cartId=repo.findByProduct_id(id).getItemId();
		repo.deleteByCart_idAndProduct_id(cartId,id);
		return cartId;
		
	}

}
