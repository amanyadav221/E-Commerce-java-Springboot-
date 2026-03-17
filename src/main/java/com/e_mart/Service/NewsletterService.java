package com.e_mart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.User.MyUser;
import com.e_mart.Entity.User.Newsletter;
import com.e_mart.Repository.MyUserRepository;
import com.e_mart.Repository.NewsletterRepository;

@Service
public class NewsletterService {
	
	@Autowired
	private NewsletterRepository newsRepo;
	@Autowired
	private MyUserRepository userRepo;
	
	public List<Newsletter> getNewsLetter(String username){
		Long userId=userRepo.findByUsername(username).getId();
		return newsRepo.findByUser_id(userId);
		
	}
	
	public String createNewsletter(String username,String email) {
		
		 email = email.trim().toLowerCase();
		 if(newsRepo.existsByEmail(email)){
		        return ("Email already exists");
		    }
		 MyUser user=userRepo.findByUsername(username);
		Newsletter n=new Newsletter();
		n.setEmail(email);
		n.setUser(user);
		n.setStatus("true");
		newsRepo.save(n);
		return "Saved";
		
		
	}
	public List<Newsletter> getAll(){
		return newsRepo.findAll();
	}
	public String update(Long id) {
		Newsletter l=newsRepo.findById(id).get();
		if(l.getStatus().equals("true"))
			l.setStatus("false");
		else
			l.setStatus("true");
		newsRepo.save(l);
		return "Updated";
		
	}
	public String deleteNewsletter(Long id) {
		newsRepo.deleteById(id);

		return "Deleted";
	}

}
