package com.e_mart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long>{

}
