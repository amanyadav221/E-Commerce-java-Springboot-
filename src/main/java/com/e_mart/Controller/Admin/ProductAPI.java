package com.e_mart.Controller.Admin;

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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.e_mart.DTO.ProductDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.ProductImage;
import com.e_mart.Repository.ProductImgRepo;
import com.e_mart.Service.BrandService;
import com.e_mart.Service.MainCategoryService;
import com.e_mart.Service.ProductService;
import com.e_mart.Service.SubCategoryService;

@RestController
@RequestMapping("/admin/product")
public class ProductAPI {
	@Autowired
	private MainCategoryService mainService;
	@Autowired
	private SubCategoryService subService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	
	
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> createProduct(
            @RequestPart("product") ProductDTO dto,
            @RequestPart("files") List<MultipartFile> files
    ) throws Exception {

        Product product = new Product();

        product.setName(dto.getName());
        product.setBasePrice(dto.getBasePrice());
        product.setDiscount(dto.getDiscount());
        product.setFinalPrice(dto.getFinalPrice());
        product.setDescription(dto.getDescription());
        product.setStock(dto.getStock());
        product.setStockQuantity(dto.getStockQuantity());
        product.setColor(dto.getColor());
        product.setSize(dto.getSize());
        product.setStatus(dto.getStatus());

        product.setMainCategory(mainService.getByName(dto.getMainCategory().getName()));

        product.setSubCategory(
        		subService.getByName(dto.getSubCategory().getName()));

        product.setBrand(
        		brandService.getByName(dto.getBrand().getName()));

        List<ProductImage> images = new ArrayList<>();

        for (MultipartFile file : files) {
            ProductImage img = new ProductImage();
            img.setFileName(file.getOriginalFilename());
            img.setFileType(file.getContentType());
            img.setFileData(file.getBytes());
            img.setProduct(product);
            images.add(img);
        }
        

        product.setPics(images);
       // System.out.println("In create product  "+product);
        

        return ResponseEntity.ok(productService.addProduct(product));
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<List<ProductDTO>> gettingAllProduct(){
    	
    	
    	return new ResponseEntity<>(HttpStatus.OK).ok(productService.getAllProducts());
    }

    
    
    
    
    @PutMapping(
    	    value = "/update/{id}",
    	    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    	)
    	public ResponseEntity<Product> updateProduct(
    	        @PathVariable Long id,
    	        @RequestPart(value = "product", required = false) ProductDTO dto,
    	        @RequestPart(value = "files", required = false) List<MultipartFile> files
    	) throws Exception {
    		System.out.println("In Update product API");
    	    Product product = productService.getById(id);

    	    if (product == null) {
    	        return ResponseEntity.notFound().build();
    	    }

    	    // ================= BASIC FIELDS =================
    	    if (dto != null) {

    	        if (dto.getName() != null)
    	            product.setName(dto.getName());

    	        if (dto.getBasePrice() != null)
    	            product.setBasePrice(dto.getBasePrice());

    	        if (dto.getDiscount() != null)
    	            product.setDiscount(dto.getDiscount());

    	        if (dto.getFinalPrice() != null)
    	            product.setFinalPrice(dto.getFinalPrice());

    	        if (dto.getDescription() != null)
    	            product.setDescription(dto.getDescription());

    	        if (dto.getStock() != null)
    	            product.setStock(dto.getStock());

    	        if (dto.getStockQuantity() != null)
    	            product.setStockQuantity(dto.getStockQuantity());

    	        if (dto.getStatus() != null)
    	            product.setStatus(dto.getStatus());

    	        if (dto.getColor() != null && !dto.getColor().isEmpty())
    	            product.setColor(dto.getColor());

    	        if (dto.getSize() != null && !dto.getSize().isEmpty())
    	            product.setSize(dto.getSize());

    	        // ================= RELATIONS =================
    	        if (dto.getMainCategory() != null)
    	            product.setMainCategory(
    	                mainService.getByName(dto.getMainCategory().getName())
    	            );

    	        if (dto.getSubCategory() != null)
    	            product.setSubCategory(
    	                subService.getByName(dto.getSubCategory().getName())
    	            );

    	        if (dto.getBrand() != null)
    	            product.setBrand(
    	                brandService.getByName(dto.getBrand().getName())
    	            );
    	    }

    	    // ================= IMAGE CONCAT LOGIC =================
    	 // ================= IMAGE CONCAT LOGIC =================
    	    if (files != null && !files.isEmpty()) {

    	        List<ProductImage> existingImages = product.getPics();

    	        if (existingImages == null) {
    	            existingImages = new ArrayList<>();
    	        }

    	        for (MultipartFile file : files) {

    	            boolean exists = existingImages.stream()
    	                .anyMatch(img ->
    	                    img.getFileName().equalsIgnoreCase(file.getOriginalFilename()) &&
    	                    img.getFileType().equalsIgnoreCase(file.getContentType())
    	                );

    	            // ✅ ADD ONLY IF NOT EXISTS
    	            if (!exists) {
    	                ProductImage img = new ProductImage();
    	                img.setFileName(file.getOriginalFilename());
    	                img.setFileType(file.getContentType());
    	                img.setFileData(file.getBytes());
    	                img.setProduct(product);

    	                existingImages.add(img);
    	            }
    	        }

    	        product.setPics(existingImages);
    	    }


    	    return ResponseEntity.ok(productService.updateProduct(product));
    	}
    @Autowired
    private ProductImgRepo imgRepo;
    @DeleteMapping("/del-img/{id}")
    public ResponseEntity<?> deleteImg(@PathVariable Long id) {
    	System.out.println("Delete img product triggered "+id);
    	//Long imgId=Long.parseLong(id);
    	try {
    		imgRepo.deleteById(id);
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted!!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" "+e.getMessage()+"  from delete product img api");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(e.getMessage());
		}
    	
    }
      
    @GetMapping("/get/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
    	return ResponseEntity.ok(productService.getById(productId));
    }
    
    

}
