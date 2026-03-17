package com.e_mart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.User.WishlistItem;
import com.e_mart.Repository.WishlistItemRepository;

import jakarta.transaction.Transactional;

@Service
public class WishlistItemService {
	@Autowired
	private WishlistItemRepository repo;
	@Transactional
	public void deleteItem(Long id,Long productId) {
//		System.out.println("========="+id+"  "+productId);
//		try {
//			WishlistItem myItem= repo.findByProductIdAndWishlistId(id,productId);
//			System.out.println("Item to be deleted "+myItem);
//			repo.deleteById(myItem.getId());
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
		
		 int rows = repo.deleteByWishlistAndProduct(id, productId);
	        if(rows == 0){
	            throw new RuntimeException("Wishlist item not found or already deleted");
	        }
		System.out.println("return ");
	}
	public WishlistItem getByProductId(Long id) {
		System.out.println("=========");
		return repo.findByProductId(id);
	}

}
