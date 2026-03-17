package com.e_mart.Service;

import com.e_mart.DTO.ProductDTO;
import com.e_mart.Entity.Product;
import com.e_mart.Entity.ProductImage;
import com.e_mart.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;
	
	public Product addProduct(Product p) {
		try {
			return productRepository.save(p);
		} catch (Exception e) {
			System.out.println(e.getMessage()+" from add Product method of Product service!!!!!");
		return null;
		}
	}

	public Product getById(Long id) {
		try {
			return productRepository.findById(id).get();
		} catch (Exception e) {
		// TODO: handle exception
			System.out.println(e.getMessage()+" at getById method product Service!!!!!!");
			return null;
		}
	}
	
	
    /* ===================== GET ALL PRODUCTS ===================== */

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /* ===================== ENTITY → DTO ===================== */

    private ProductDTO convertToDTO(Product product) {

        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());

        dto.setMainCategory(
                new ProductDTO.SimpleNameDTO(
                        product.getMainCategory().getName()
                )
        );

        dto.setSubCategory(
                new ProductDTO.SimpleNameDTO(
                        product.getSubCategory().getName()
                )
        );

        dto.setBrand(
                new ProductDTO.SimpleNameDTO(
                        product.getBrand().getName()
                )
        );

        dto.setColor(product.getColor());
        dto.setSize(product.getSize());
        dto.setDescription(product.getDescription());
        dto.setBasePrice(product.getBasePrice());
        dto.setDiscount(product.getDiscount());
        dto.setFinalPrice(product.getFinalPrice());

        dto.setStock(product.getStock());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setStatus(product.getStatus());

        /* ===== IMAGE MAPPING (ACTUAL FILE DATA) ===== */

        List<ProductDTO.ImageDTO> images =
                product.getPics().stream()
                        .map(this::convertImage)
                        .collect(Collectors.toList());

        dto.setPics(images);

        return dto;
    }

    private ProductDTO.ImageDTO convertImage(ProductImage image) {

        String base64 = Base64.getEncoder()
                .encodeToString(image.getFileData());

        return new ProductDTO.ImageDTO(
                image.getId(),           // ✅ return image id
                image.getFileType(),
                base64
        );
    }
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    
    
    
    public Long getNumberOfProduct() {
    
    	return productRepository.count();
    }
}
