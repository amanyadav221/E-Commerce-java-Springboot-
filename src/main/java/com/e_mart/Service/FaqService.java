package com.e_mart.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.Faq;
import com.e_mart.Repository.FaqRepository;

import jakarta.transaction.Transactional;
 
@Service
public class FaqService {
	@Autowired
	private FaqRepository repo;
	public String AddFaq(Faq faq) {
	try {
			repo.save(faq);
			return "Added";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception : "+e.getMessage();
		}
	}
	public String updateFaq(
	        Long id,
	        Faq newData
	) throws IOException {
		System.out.println("testing.........."+id);
		Faq f=repo.findById(id).get();
		f.setQuestion(newData.getQuestion());
		f.setAnswer(newData.getAnswer());
		f.setStatus(newData.getStatus());
		repo.save(f);
		return "updated......";
	}
	public List<Faq> getAllData(){
		return repo.findAll();
	}
	public List<Faq> getByName(String question){
		return repo.findByQuestion(question);
	}
	@Transactional
	public String delete(String question) {
		 repo.deleteByQuestion(question);
		 return "";
	}

}
