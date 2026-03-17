package com.e_mart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.Setting;
import com.e_mart.Repository.SettingRepository;

@Service
public class SettingService {
	
	@Autowired
	private SettingRepository repo;
	
	public Setting update(Setting setting) {
//		try {
//			Setting s=repo.findAll().get(0);
//			repo.delete(s);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
		return repo.save(setting);
		
	}
	public Setting get() {
		Setting s=new Setting();
		try {
			s=repo.findAll().get(0);
			System.out.println("No of Setting  "+repo.count());
			System.out.println(s.getAddressOne());
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	public Setting del(Setting setting) {
		repo.delete(setting);
		return setting;
	}

}
