package com.e_mart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.User.Address;
import com.e_mart.Repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repo;
	
	public Address addAddress(Address address) {
		return repo.save(address);
	}
	public List<Address> getAllAddressByUsername(String username){
		return repo.findByUserUsername(username);
	}
	public void deleteAddressByid(Long id) {
		System.out.println("deleting address");
		 repo.deleteById(id);
	}
	public Address getById(Long id) {
		Optional<Address> addr=repo.findById(id);
		return addr.get();
	}

}
