package com.e_mart.Controller.Public;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.e_mart.DTO.MainCatagoryDTO;
import com.e_mart.Entity.MainCatagoryClass;
import com.e_mart.Entity.SubCategory;
import com.e_mart.Service.MainCategoryService;
import com.e_mart.Service.SubCategoryService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController 
@RequestMapping("/public/main-cat")
public class MainCatPublicAPI {

	@Autowired
	private MainCategoryService service;
	
	//return only name
	@GetMapping("/get-main-cat")
	private ResponseEntity<List<String>> getData(){
		List<MainCatagoryClass> cat=service.getData();
		List<String> str=new ArrayList<>();
		for(MainCatagoryClass c :cat) {
			str.add(c.getName());
			System.out.println("Name : "+c.getName());
			System.out.println("Name : "+c.getStatus());
			System.out.println("Name : "+c.getFileName());
			System.out.println("Name : "+c.getFileType());
			System.out.println("Name : "+c.getFileData());
		}
		return ResponseEntity.ok(str);
	}
	
	
	
	@GetMapping("/get-all")
	private ResponseEntity<List<MainCatagoryDTO>> getAll(){
		List<MainCatagoryClass> cat=service.getData();
		List<MainCatagoryDTO> response = cat.stream().map(c -> {
	        MainCatagoryDTO dto = new MainCatagoryDTO();
 
	        dto.setName(c.getName());
	        dto.setStatus(c.getStatus());
	        dto.setFileName(c.getFileName());
	        dto.setFileType(c.getFileType());

	        dto.setFile(
	            Base64.getEncoder().encodeToString(c.getFileData())
	        );

	        return dto;
	    }).toList();
		return ResponseEntity.ok(response);
	}
//	@GetMapping("/get/{name}")
//	private ResponseEntity<List<String>> getCat(@PathVariable String name){
//		System.out.println("Get By Name Triggered!!!!!!!!");
//		List<MainCatagoryClass> cat=service.getByName(name);
//		List<String> catName=new ArrayList<>();
//		for(MainCatagoryClass c :cat) {
//			catName.add(c.getName());
//			System.out.println("Name : "+c.getName());
//			System.out.println("Name : "+c.getStatus());
//			System.out.println("Name : "+c.getFileName());
//			System.out.println("Name : "+c.getFileType());
//			System.out.println("Name : "+c.getFileData());
//		}
//		return ResponseEntity.ok(catName);
//	}
//	
	
	@GetMapping("/get/{name}")
	private ResponseEntity<MainCatagoryClass> getUniques(@PathVariable String name){
		MainCatagoryClass cat=service.getByName(name);
		//System.out.println("Get By Name Triggered!!!!!!!!   in   get/name"+name+cat);
//		List<String> catName=new ArrayList<>();
//		for(MainCatagoryClass c :cat) {
//			catName.add(c.getName());
//			System.out.println("Name : "+c.getName());
//			System.out.println("Name : "+c.getStatus());
//			System.out.println("Name : "+c.getFileName());
//			System.out.println("Name : "+c.getFileType());
//			System.out.println("Name : "+c.getFileData());
//		}
		return ResponseEntity.ok(cat);
	}
	
}
