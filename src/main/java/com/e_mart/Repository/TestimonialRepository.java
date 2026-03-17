package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
	public List<Testimonial> findByUser_id(Long id);
	public Testimonial findByUser_idAndProduct_id(Long userId,Long productId);
	public List<Testimonial> findByProduct_id(Long productId);
}
