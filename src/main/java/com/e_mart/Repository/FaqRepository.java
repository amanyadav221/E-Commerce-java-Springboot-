package com.e_mart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>{
	public List<Faq> findByQuestion(String question);
	public List<Faq> deleteByQuestion(String question);

}
