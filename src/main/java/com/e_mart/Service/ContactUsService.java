package com.e_mart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.DTO.ContactUsDTO;
import com.e_mart.Entity.ContactUs;
import com.e_mart.Repository.ContactUsRepository;
import com.e_mart.Repository.MyUserRepository;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepository repo;
	@Autowired
	private MyUserRepository userRepo;
	
	public String create(String username,ContactUsDTO dto) {
		ContactUs c=new ContactUs();
		c.setUser(userRepo.findByUsername(username));
		c.setDate(dto.getDate());
		c.setEmail(dto.getEmail());
		c.setMessage(dto.getMessage());
		c.setName(dto.getName());
		c.setPhone(dto.getPhone());
		c.setStatus(dto.getStatus());
		c.setSubject(dto.getSubject());
		try {
			repo.save(c);
			return "Saved";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "Not saved";
		}
	}
	public List<ContactUs> gettingAll(){
		return repo.findAll();
	}
	public String update(Long id) {
		ContactUs c=repo.findById(id).get();
		if(c.getStatus().equals("true"))
			c.setStatus("false");
		else
			c.setStatus("true");
		repo.save(c);
		return "updated";
	}
	public String delete(Long id) {
		repo.deleteById(id);
		return "Deleted";
	}

}
