package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.e_mart.Configuration.JwtProvider;
import com.e_mart.DTO.CheckoutDTO;
import com.e_mart.DTO.UpdateCheckoutDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.User.Checkout;
import com.e_mart.Entity.User.CheckoutItem;
import com.e_mart.Repository.AddressRepository;
import com.e_mart.Repository.CheckoutItemRepository;
import com.e_mart.Repository.CheckoutRepository;
import com.e_mart.Repository.MyUserRepository;
import com.e_mart.Repository.ProductRepository;
import com.e_mart.Response.CheckoutItemResponse;

import jakarta.transaction.Transactional;

@Service
public class CheckoutService {

	
	@Autowired
	private CheckoutRepository repo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private MyUserRepository userRepo;
	@Autowired
	private CheckoutItemRepository checkoutItemRepo;
//	public String addCheckout(CheckoutDTO dto) {
//		
//		Checkout checkout=new Checkout();
//		checkout.setUser(userRepo.findByUsername(dto.getUsername()));
//		checkout.setAddress(addressRepo.findById(dto.getAddressId()).get());
//		checkout.setDateOfOrder(dto.getDateOfOrder());
//		checkout.setOrderStatus(dto.getOrderStatus());
//		checkout.setPaymentMode(dto.getPaymentMode());
//		checkout.setPaymentStatus(dto.getPaymentStatus());
//		checkout.setShipping(dto.getShipping());
//		checkout.setSubTotal(dto.getSubTotal());
//		checkout.setTotal(dto.getTotal());
//		
//		
//		String[] colors=dto.getColor();
//		String[] size=dto.getSize();
//		Long[] ids=dto.getProductId();
//		int[] quantities=dto.getQuantities();
////		checkout.setProduct(dto.getProductList());
//		List<Product> products=new ArrayList<>();
//		for(int i=0; i<ids.length;i++) {
//			Product p=productRepo.findById(ids[i]).get();
//			System.out.println(p.getStockQuantity());
//			if(p.getStockQuantity()==0)
//				return "Out Of Stock";
//			p.setStockQuantity(p.getStockQuantity()-quantities[i]);
//			System.out.println(p.getStockQuantity());
//			//updating quantity
//			productRepo.save(p);
//			//setting color
//			List<String> clr=new ArrayList<>();
//			clr.add(colors[i]);
//			p.setColor(clr);
//			
//			//setting size
//		List<String> sz=new ArrayList<>();
//		sz.add(size[i]);
//		p.setSize(sz);
//			
//			//productRepo.deleteById(ids[0]);
//			
//			System.out.println(productRepo.findById(p.getId()));
//			products.add(p);
//		}
//		//checkout.setProduct(products);
//		
//		System.out.println(checkout);
//		
//		repo.save(checkout);
//		
//		return "success";
//		
//		
//	}
	@Transactional
	public String addCheckout(CheckoutDTO dto) {

	    Checkout checkout = new Checkout();
	    checkout.setUser(userRepo.findByUsername(dto.getUsername()));
	    checkout.setAddress(addressRepo.findById(dto.getAddressId()).get());
	    checkout.setDateOfOrder(dto.getDateOfOrder());
	    checkout.setOrderStatus(dto.getOrderStatus());
	    checkout.setPaymentMode(dto.getPaymentMode());
	    checkout.setPaymentStatus(dto.getPaymentStatus());
	    checkout.setShipping(dto.getShipping());
	    checkout.setSubTotal(dto.getSubTotal());
	    checkout.setTotal((dto.getTotal()==null?(dto.getShipping()==0?dto.getSubTotal():dto.getShipping()*dto.getSubTotal()):dto.getTotal()));

	    List<CheckoutItem> items = new ArrayList<>();

	    for(int i = 0; i < dto.getProductId().length; i++){

	        Product p = productRepo.findById(dto.getProductId()[i]).get();

	        if(p.getStockQuantity() < dto.getQuantities()[i])
	        	return "Out Of Stock";

	        // 🔒 Update stock safely
	        p.setStockQuantity(p.getStockQuantity() - dto.getQuantities()[i]);
	        productRepo.save(p);

	        CheckoutItem item = new CheckoutItem();
	        item.setCheckout(checkout);
	        item.setProduct(p);
	        item.setColor(dto.getColor()[i]);
	        item.setSize(dto.getSize()[i]);
	        item.setQuantity(dto.getQuantities()[i]);
	        item.setPrice(p.getFinalPrice());
	        item.setTotalPrice(p.getFinalPrice() * dto.getQuantities()[i]);

	        items.add(item);
	    }

	    checkout.setItems(items);     // 🔥 link order items
	    repo.save(checkout);          // cascades items save

	    return "success";
	}


//	public List<Checkout> getAllCheckout(String username) {
//		// TODO Auto-generated method stub
//		Long userId=userRepo.findByUsername(username).getId();
//		List<Checkout> checkouts= repo.findByUser_id(userId);
//		List<CheckoutDTO>dto=new ArrayList<>();
//		for(int i=0; i<checkouts.size(); i++) {
//			CheckoutDTO d=new CheckoutDTO();
//			d.setAddressId(checkouts[i].
//		}
//		return checkouts;
	 public List<CheckoutItemResponse> getAllCheckout(String username) {
	        Long userId = userRepo.findByUsername(username).getId();
	       // CheckoutDTO dto=new CheckoutDTO();
	        
	        
	        
	        List<Checkout> checkoutIdss=repo.findByUser_id(userId);
	        List <CheckoutItemResponse> finalRes=new ArrayList<>();
	        for(Checkout id : checkoutIdss) {
	        	CheckoutItemResponse res=new CheckoutItemResponse();
	        	
	        	System.out.println("Checckout ids   ===>>>>"+id.getId());
	        	
	        	res.setCheckoutId(id.getId());
	        	List<CheckoutItem> checkoutItems= checkoutItemRepo.findByCheckout_Id(id.getId());
	        	 List<Long> itemId=new ArrayList<>();
	        	
	        	 List<Long> productId=new ArrayList<>();
	        	
	        	 List<String> color=new ArrayList<>();
	        	
	        	 List<String> size=new ArrayList<>();
	        	
	        	 List<Integer> quantity=new ArrayList<>();
	        	
	        	 List<Double> price=new ArrayList<>();
	        	
	        	 List<Double> totalPrice=new ArrayList<>();
	        	
	        	for(CheckoutItem i : checkoutItems) {
	        		itemId.add(i.getId());
	        		productId.add(i.getProduct().getId());
	        		color.add(i.getColor());
	        		size.add(i.getSize());
	        		quantity.add(i.getQuantity());
	        		price.add(i.getPrice());
	        		totalPrice.add(i.getTotalPrice());
	        		
	        		//item id
	        		System.out.println(i.getId());
	        		//res.setItemId(checkoutIds);
	
	        	}
	        	
	        	res.setItemId(itemId);
	        	res.setProductId(productId);
	        	res.setColor(color);
	        	res.setSize(size);
	        	res.setQuantity(quantity);
	        	res.setPrice(price);
	        	res.setTotalPrice(totalPrice);
	        	res.setAddressId(id.getAddress().getId());
	        	res.setOrderStatus(id.getOrderStatus());
	        	res.setPaymentMode(id.getPaymentMode());
	        	res.setPaymentStatus(id.getPaymentStatus());
	        	res.setShipping(id.getShipping());
	        	res.setSubTotal(id.getSubTotal());
	        	res.setTotal(id.getTotal());
	        	res.setDateOfOrder(id.getDateOfOrder());
	        	
	        	finalRes.add(res);
	        	//checkoutIds.add(id.getId());
	        }
	        return finalRes;
	        
	        
	        
	        
	        
	        //List<Checkout> checkouts = repo.findByUser_id(userId);
	        
	       // List<CheckoutDTO> dtoList = new ArrayList<>();

//	        for (Checkout checkout : checkouts) {
//	            CheckoutDTO dto = new CheckoutDTO();
//
//	            // Set basic order info
//	            dto.setUsername(username);
//	            dto.setAddressId(checkout.getAddress().getId());
//	            dto.setDateOfOrder(checkout.getDateOfOrder());
//	            dto.setOrderStatus(checkout.getOrderStatus());
//	            dto.setPaymentMode(checkout.getPaymentMode());
//	            dto.setPaymentStatus(checkout.getPaymentStatus());
//	            dto.setSubTotal(checkout.getSubTotal());
//	            dto.setShipping(checkout.getShipping());
//	            dto.setTotal(checkout.getTotal());
//
//	            // Prepare arrays for products
//	            List<CheckoutItem> items = checkout.getItems();
//	            int n = items.size();
//	            Long[] productIds = new Long[n];
//	            int[] quantities = new int[n];
//	            String[] sizes = new String[n];
//	            String[] colors = new String[n];
//
//	            for (int i = 0; i < n; i++) {
//	                CheckoutItem item = items.get(i);
//	                productIds[i] = item.getProduct().getId();
//	                quantities[i] = item.getQuantity();
//	                sizes[i] = item.getSize();
//	                colors[i] = item.getColor();
//	            }
//
//	            dto.setProductIds(productIds);
//	            dto.setQuantities(quantities);
//	            dto.setSize(sizes);
//	            dto.setColor(colors);
//	            dto.setCheckoutIds(checkoutIds);
//
//	            dtoList.add(dto);
//	        }

	      //  return dtoList;
	}
	 public List<CheckoutItemResponse> admnGetAllCheckout() {
	        //Long userId = userRepo.findByUsername(username).getId();
	       // CheckoutDTO dto=new CheckoutDTO();
	        
	        
	        
	        List<Checkout> checkoutIdss=repo.findAll();
	        List <CheckoutItemResponse> finalRes=new ArrayList<>();
	        for(Checkout id : checkoutIdss) {
	        	CheckoutItemResponse res=new CheckoutItemResponse();
	        	
	        	System.out.println("Checckout ids   ===>>>>"+id.getId());
	        	
	        	res.setCheckoutId(id.getId());
	        	List<CheckoutItem> checkoutItems= checkoutItemRepo.findByCheckout_Id(id.getId());
	        	 List<Long> itemId=new ArrayList<>();
	        	
	        	 List<Long> productId=new ArrayList<>();
	        	
	        	 List<String> color=new ArrayList<>();
	        	
	        	 List<String> size=new ArrayList<>();
	        	
	        	 List<Integer> quantity=new ArrayList<>();
	        	
	        	 List<Double> price=new ArrayList<>();
	        	
	        	 List<Double> totalPrice=new ArrayList<>();
	        	
	        	for(CheckoutItem i : checkoutItems) {
	        		itemId.add(i.getId());
	        		productId.add(i.getProduct().getId());
	        		color.add(i.getColor());
	        		size.add(i.getSize());
	        		quantity.add(i.getQuantity());
	        		price.add(i.getPrice());
	        		totalPrice.add(i.getTotalPrice());
	        		
	        		//item id
	        		System.out.println(i.getId());
	        		//res.setItemId(checkoutIds);
	
	        	}
	        	
	        	res.setItemId(itemId);
	        	res.setProductId(productId);
	        	res.setColor(color);
	        	res.setSize(size);
	        	res.setQuantity(quantity);
	        	res.setPrice(price);
	        	res.setTotalPrice(totalPrice);
	        	res.setAddressId(id.getAddress().getId());
	        	res.setOrderStatus(id.getOrderStatus());
	        	res.setPaymentMode(id.getPaymentMode());
	        	res.setPaymentStatus(id.getPaymentStatus());
	        	res.setShipping(id.getShipping());
	        	res.setSubTotal(id.getSubTotal());
	        	res.setTotal(id.getTotal());
	        	res.setDateOfOrder(id.getDateOfOrder());
	        	
	        	finalRes.add(res);
	        	//checkoutIds.add(id.getId());
	        }
	        return finalRes;
	 }
	 public String update(Long id, UpdateCheckoutDTO dto) {
		 
		 try {
			 Checkout c=repo.findById(id).get();
			 System.out.println(c.getId());
			 System.out.println();
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			System.out.println(c.getOrderStatus());
			System.out.println(c.getPaymentStatus());
			System.out.println(dto);
			c.setOrderStatus(dto.getOrderStatus());
			c.setPaymentStatus(dto.getPaymentStatus());
			repo.save(c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
//		
//		
//		 System.out.println(c.get);
		 System.out.println(id);
		 System.out.println(id);
		 System.out.println(id);
		 System.out.println(id);
		 return "";
		 
		 
	 }
}
