package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.ProductImage;

@Repository
public interface ProductImgRepo extends JpaRepository<ProductImage, Long>{
	public List<ProductImage> findByFileTypeAndFileData(String fileType,String fileData);

}
