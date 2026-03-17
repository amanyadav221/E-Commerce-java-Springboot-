package com.e_mart.Controller.Public;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.e_mart.DTO.ImageDeleteDTO;
import com.e_mart.DTO.ProductDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.ProductImage;
import com.e_mart.Repository.ProductImgRepo;
import com.e_mart.Service.BrandService;
import com.e_mart.Service.MainCategoryService;
import com.e_mart.Service.ProductService;
import com.e_mart.Service.SubCategoryService;

@RestController
@RequestMapping("/public/product")
public class ProductPublicAPI {
	
	@Autowired
	private MainCategoryService mainService;
	@Autowired
	private SubCategoryService subService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

    
    @GetMapping("/get-all")
    public ResponseEntity<List<ProductDTO>> gettingAllProduct(){
    	
    	
    	return new ResponseEntity<>(HttpStatus.OK).ok(productService.getAllProducts());
    }

    @Autowired
    private ProductImgRepo imgRepo;

      
    @GetMapping("/get/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
    	return ResponseEntity.ok(productService.getById(productId));
    }
    
    

}
