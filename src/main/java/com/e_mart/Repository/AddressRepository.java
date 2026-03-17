package com.e_mart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByUserUsername(String userId);
	

}
