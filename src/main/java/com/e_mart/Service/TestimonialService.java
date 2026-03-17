package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.DTO.TestimonialDTO;
import com.e_mart.Entity.Testimonial;
import com.e_mart.Repository.CheckoutRepository;
import com.e_mart.Repository.MyUserRepository;
import com.e_mart.Repository.ProductRepository;
import com.e_mart.Repository.TestimonialRepository;
import com.e_mart.Response.TestimonialPublicResponse;

@Service
public class TestimonialService {
	@Autowired
	private TestimonialRepository repo;
	@Autowired
	MyUserRepository userRepo;
	@Autowired
	private CheckoutRepository checkoutRepo;
	@Autowired
	private ProductRepository pRepo;
	
	
	public List<TestimonialPublicResponse> gettingAll(){
		List<TestimonialPublicResponse> res= new ArrayList<>();
		List<Testimonial> t=repo.findAll();
		
		for(Testimonial z : t) {
			System.out.println(z.getUser().getUsername());
			System.out.println(z.getProduct().getId());
			System.out.println(z.getMessage());
			System.out.println(z.getRating());
			System.out.println(z.getCheckout().getId());
			TestimonialPublicResponse x=new TestimonialPublicResponse();
			x.setCheckoutId(z.getCheckout().getId());
			x.setFullName(z.getUser().getFullName());
			x.setUserId(z.getUser().getId());
			x.setUsername(z.getUser().getUsername());
			x.setMessage(z.getMessage());
			x.setProductId(z.getProduct().getId());
			x.setRating(z.getRating());
			res.add(x);
		}
		return res;
	}
	
	
	public String createService(TestimonialDTO dto,String username) {
		
		Testimonial t= new Testimonial();
//		if(t==null)
//			return "Review not found";
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		System.out.println(dto);
		t.setMessage(dto.getMessage());
		t.setProduct(pRepo.findById(dto.getPId()).get());
		t.setUser(userRepo.findByUsername(username));
		t.setRating(dto.getRating());
		t.setCheckout(checkoutRepo.findById(dto.getCheckoutId()).get());
		repo.save(t);
		return "Created";
	}
	public List<TestimonialDTO> getByUsername(String username){
		List<Testimonial> test=repo.findByUser_id(userRepo.findByUsername(username).getId());
		List<TestimonialDTO> list=new ArrayList<>();
		for(Testimonial t : test) {
			TestimonialDTO dto=new TestimonialDTO();
			dto.setMessage(t.getMessage());
			dto.setPId(t.getProduct().getId());
			dto.setRating(t.getRating());
			dto.setCheckoutId(t.getCheckout().getId());
			list.add(dto);
		}
		return list;
	}
	public String updateTestimonial(TestimonialDTO dto,String username) {
		
		Testimonial t=repo.findByUser_idAndProduct_id(userRepo.findByUsername(username).getId(), dto.getPId());
		System.out.println(dto);
		System.out.println(t);
		t.setMessage(dto.getMessage());
		t.setRating(dto.getRating());
		
		repo.save(t);
		return "Updated";
		
	}
	public String deleteTestimonial(Long pId,String username) {
		
		Testimonial t=repo.findByUser_idAndProduct_id(userRepo.findByUsername(username).getId(), pId);
		repo.deleteById(t.getId());
		return "Deleted";
	}
	public List<TestimonialDTO> getByPid(Long id) {
		// TODO Auto-generated method stub
		List<Testimonial> s=repo.findByProduct_id(id);
	
		List<TestimonialDTO> dto=new ArrayList<>();
		for(Testimonial t : s) {
			TestimonialDTO d=new TestimonialDTO();
			d.setMessage(t.getMessage());
			d.setPId(t.getProduct().getId());
			d.setRating(t.getRating());
			d.setUserId(t.getUser().getId());
			d.setCheckoutId(t.getCheckout().getId());
			dto.add(d);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(dto.size());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		return dto;
	}

}
