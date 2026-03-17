package com.e_mart.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.Entity.SubCategory;
import com.e_mart.Repository.SubCategoryRepository;

import jakarta.transaction.Transactional;
@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryRepository repo;
	public String addSubCategory(SubCategory subCat, MultipartFile file) {
	try {
			if(file!=null) {
				subCat.setFileName(file.getOriginalFilename());
				subCat.setFileType(file.getContentType());
				subCat.setFileData(file.getBytes());
			}
			repo.save(subCat);
			return "Added";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception : "+e.getMessage();
		}
	}
	public String updateSubCategory(
	        String name,
	        SubCategory newData,
	        MultipartFile file
	) throws IOException {
		System.out.println("testing.........."+name);
		Optional<SubCategory> optionalCat=repo.findById(name);
		
		if(optionalCat.isPresent()) {
			SubCategory cat=optionalCat.get();
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
	public List<SubCategory> getData(){
		return repo.findAll();
	}
	public SubCategory getByName(String name){
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
