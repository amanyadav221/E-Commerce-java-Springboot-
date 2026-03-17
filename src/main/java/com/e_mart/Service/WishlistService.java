package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.DTO.WishlistDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.User.Cart;
import com.e_mart.Entity.User.CartItem;
import com.e_mart.Entity.User.Wishlist;
import com.e_mart.Entity.User.WishlistItem;
import com.e_mart.Repository.WishlistRepository;

@Service
public class WishlistService {
	
	@Autowired
	private WishlistRepository repo;
	@Autowired
	private MyUserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private WishlistItemService wishlistItemService;
	
	
	public String addToWishlist(String username,WishlistDTO item) {
		
		 Wishlist myWishlist = userService.getMyWishlist(username);
		 Product product = productService.getById(item.getProductId());
		 if (myWishlist == null) {
		        myWishlist = new Wishlist();
		        myWishlist.setUser(userService.getUserByUsername(username));
		        myWishlist.setItems(new ArrayList<>());
		    }
		
		    WishlistItem oldItem = myWishlist.getItems().stream()
		            .filter(i -> i.getProduct().getId().equals(item.getProductId()))
		            .findFirst()
		            .orElse(null);
		    if(oldItem != null){
		    		return "Item is already added to Wishlist!!!";
		    	//oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
		    } else {
		        WishlistItem newItem = new WishlistItem();
		        newItem.setProduct(product);
		        //newItem.setQuantity(item.getQuantity());
		        newItem.setWishlist(myWishlist);
		        myWishlist.getItems().add(newItem);
		    }
		    
		   repo.save(myWishlist);
		   return "Added to wishlst!!!";
	}


	public List<Long> getMyWishlist(String username) {
		// TODO Auto-generated method stub
		Wishlist list=repo.findByUserUsername(username);
		List<Long> pId = new ArrayList<>();
		List<WishlistItem> products=list.getItems();
		for(WishlistItem p:products) {
			pId.add(p.getProduct().getId());
		}
		return pId;
		
	}


	public void deleteWishlist(String username, Long id) {
		// TODO Auto-generated method stub
		Wishlist list=repo.findByUserUsername(username);
		//System.out.println(list);
		Long wishlistId=list.getId();
		System.out.println("=========");
		//WishlistItem item=wishlistItemService.getByProductId(id);
		wishlistItemService.deleteItem(wishlistId,id);
		
	}

}
