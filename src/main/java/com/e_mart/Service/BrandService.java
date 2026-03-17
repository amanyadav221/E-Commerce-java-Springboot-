package com.e_mart.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.Entity.Brand;
import com.e_mart.Repository.BrandRepository;

import jakarta.transaction.Transactional;
@Service
public class BrandService {
	@Autowired
	private BrandRepository repo;
	public String AddBrand(Brand brand, MultipartFile file) {
	try {
			if(file!=null) {
				brand.setFileName(file.getOriginalFilename());
				brand.setFileType(file.getContentType());
				brand.setFileData(file.getBytes());
			}
			repo.save(brand);
			return "Added";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception : "+e.getMessage();
		}
	}
	public String updateBrand(
	        String name,
	        Brand newData,
	        MultipartFile file
	) throws IOException {
		System.out.println("testing.........."+name);
		Optional<Brand> optionalCat=repo.findById(name);
		
		if(optionalCat.isPresent()) {
			Brand cat=optionalCat.get();
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
	public List<Brand> getAllData(){
		return repo.findAll();
	}
	public Brand getByName(String name){
		try {
			return repo.findByName(name).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"   from getByName method of Brand Service!!!!!!");
			return null;
		}
	}
	@Transactional
	public String delete(String name) {
		 repo.deleteByName(name);
		 return "";
	}
	public Long getNumberOfBrands() {
		return repo.count();
	}
}
