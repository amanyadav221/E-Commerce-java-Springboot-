package com.e_mart.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_mart.Entity.Setting;

@Repository
public interface SettingRepository extends JpaRepository<Setting, String>{
	List<Setting> findAll();
}
