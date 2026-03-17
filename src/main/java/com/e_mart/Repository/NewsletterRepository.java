package com.e_mart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.Newsletter;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long>{
	public List<Newsletter> findByUser_id(Long id);
	public  boolean existsByEmail(String email);
}
