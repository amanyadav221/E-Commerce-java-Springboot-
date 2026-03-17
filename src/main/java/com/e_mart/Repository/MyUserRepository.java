package com.e_mart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.User.MyUser;
@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
	
	public MyUser findByUsername(String username);

	public MyUser findByEmail(String email);

	public MyUser deleteByUsername(String username);
}
