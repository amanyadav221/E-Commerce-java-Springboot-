package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_mart.DTO.CartDTO;
import com.e_mart.DTO.CartItemDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.User.Cart;
import com.e_mart.Entity.User.CartItem;
import com.e_mart.Entity.User.MyUser;
import com.e_mart.Repository.CartItemRepository;
import com.e_mart.Repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private CartItemService itemService;
	@Autowired
	private MyUserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartItemRepository cartItemRepo;
	
	public Cart addCart(Cart cart) {
		return	cartRepo.save(cart);
	}
	public List<Cart>  getAllCart(){
		return cartRepo.findAll();
	}
//	 public Cart getMyCart(String username) {
//	        //String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		// Cart cart=cartRepo.findByUser_Id(username);
//		 //Cart cart=cartRepo.findMyCart(username);
//		 Long id=userService.getUserByUsername(username).getId();
//		 Cart cart=cartRepo.findByUser_Id(id);
//		 System.out.println(cart);
//		 List<CartItem> items=itemService.getMyItem(cart.getId());
//		 cart.setItems(items);
//		 System.out.println(cart);
//	        return cart;
//	    }
	public List<CartItemDTO> getMyCart(String username) {
	    Long id = userService.getUserByUsername(username).getId();
	    Cart cart = cartRepo.findByUser_Id(id);
	    
	    

	    if (cart == null) {
	        // Optionally, create a new cart for the user
	        cart = new Cart();
	        cart.setUser(userService.getUserByUsername(username));
	        cartRepo.save(cart);
	    }

	    List<CartItem> items = itemService.getMyItem(cart.getId());
//	    System.out.println(items.size());
//	    for(CartItem item:items)
//	    	System.out.println(item);
	    
//	    cart.setItems(items);
	    List<CartItemDTO> dto=new ArrayList<>();
	    for(CartItem item:items) {
	    	CartItemDTO newDto=new CartItemDTO();
	    	newDto.setProductId(item.getProduct().getId());
	    	newDto.setColor(item.getColor());
	    	newDto.setSize(item.getSize());
	    	newDto.setQuantity(item.getQuantity());
	    	newDto.setSubTotal(item.getTotalPrice());
	    	newDto.setPrice(item.getProduct().getBasePrice());
	    	newDto.setId(item.getItemId());
	    	dto.add(newDto);
	    }
	    
	    return dto;
	}

	 public Long getMyCartId(String username) {
		 Long id=userService.getUserByUsername(username).getId();
		 return cartRepo.findByUser_Id(id).getId();
	 }
	 @Transactional
	 public String addToCart(String username, CartDTO dto) {

	     Cart cart = cartRepo.findByUsernameWithItems(username)
	             .orElseThrow();

	     Product product = productService.getById(dto.getProductId());

	     Optional<CartItem> existing = cart.getItems().stream()
	         .filter(i -> i.getProduct().getId().equals(dto.getProductId())
	                   && i.getColor().equals(dto.getColor())
	                   && i.getSize().equals(dto.getSize()))
	         .findFirst();

	     if (existing.isPresent()) {
	         CartItem item = existing.get();
	         item.setQuantity(item.getQuantity() + dto.getQuantity());
	     } else {
	         CartItem item = new CartItem();
	         item.setCart(cart);
	         item.setProduct(product);
	         item.setColor(dto.getColor());
	         item.setSize(dto.getSize());
	         item.setQuantity(dto.getQuantity());
	         item.setTotalPrice(product.getFinalPrice());

	         cart.getItems().add(item);
	     }

	     return "Added to cart";
	 }

	 
	 
	 @Transactional
	 public void updateCartItem(Long itemId, CartDTO dto, String username) {

	     CartItem item = cartItemRepo.findById(itemId).orElseThrow();

	     if (!item.getCart().getUser().getUsername().equals(username))
	         throw new RuntimeException("Forbidden");

	     item.setQuantity(dto.getQuantity());
	     item.setColor(dto.getColor());
	     item.setSize(dto.getSize());
	 }

	 
	 
//	 @Transactional
//	 public String addToCart(String username, CartDTO item) {
//		 Cart myCArt = userService.getMyCart(username);
//		 Product product = productService.getById(item.getProductId());
//		 
//		    CartItem oldItem = myCArt.getItems().stream()
//		            .filter(i -> i.getProduct().getId().equals(item.getProductId()))
//		            .findFirst()
//		            .orElse(null);
//		    
//		    
//		    if(oldItem != null){
////		    	if(oldItem.getQuantity()==item.getQuantity()) {
////		    		return "Item is already added to cart!!!";
////		    	}
////		    	oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
////		    } else {
//		    	if(oldItem.getItemId()!=null)
//		    		
//		    		System.out.println();
//		    	System.out.println();
//		    	System.out.println();
//		    	System.out.println();
//		    	System.out.println(oldItem.getItemId());
//		    	System.out.println();
//		    	System.out.println();
//		    	System.out.println();
//		    	System.out.println();
//		    	System.out.println();
//		    	itemService.deleteCartItem(oldItem.getItemId());
//		    }
//		    	
//		        CartItem newItem = new CartItem();
//		        newItem.setProduct(product);
//		        newItem.setQuantity(item.getQuantity());
//		        newItem.setCart(myCArt);
//		        newItem.setColor(item.getColor());
//		        newItem.setSize(item.getSize());
//		        myCArt.getItems().add(newItem);
//		   // }
//		    
//		   cartRepo.save(myCArt);
//		   return "Added to cart!!!";
//		 
//	 }
}
