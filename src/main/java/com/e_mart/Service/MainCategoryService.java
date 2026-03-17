package com.e_mart.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.Entity.MainCatagoryClass;
import com.e_mart.Repository.MainCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class MainCategoryService {
	@Autowired
	private MainCategoryRepository repo;
	public String addMainCategory(MainCatagoryClass mainCategory, MultipartFile file) {
	try {
			if(file!=null) {
				mainCategory.setFileName(file.getOriginalFilename());
				mainCategory.setFileType(file.getContentType());
				mainCategory.setFileData(file.getBytes());
			}
			repo.save(mainCategory);
			return "Added";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception : "+e.getMessage();
		}
	}
	public String updateMainCategory(
	        String name,
	        MainCatagoryClass newData,
	        MultipartFile file
	) throws IOException {
		System.out.println("testing.........."+name);
		Optional<MainCatagoryClass> optionalCat=repo.findById(name);
		
		if(optionalCat.isPresent()) {
			MainCatagoryClass cat=optionalCat.get();
			newData.setFileName(cat.getFileName());
			newData.setFileType(cat.getFileType());
			newData.setFileData(cat.getFileData());
		}else {
			newData.setFileName(file.getOriginalFilename());
			newData.setFileType(file.getContentType());
			newData.setFileData(file.getBytes());
		}
		repo.deleteById(name);
		repo.save(newData);
		return "updated......";
	}
	public List<MainCatagoryClass> getData(){
		return repo.findAll();
	}
	public MainCatagoryClass getByName(String name){
		try {
			return repo.findByName(name).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Transactional
	public String delete(String name) {
		 repo.deleteByName(name);
		 return "";
	}

}
