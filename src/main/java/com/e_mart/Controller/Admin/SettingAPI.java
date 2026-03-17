package com.e_mart.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.Entity.Setting;

import com.e_mart.Service.SettingService;

@RestController
@RequestMapping("/admin/setting")
public class SettingAPI {
	@Autowired
	private SettingService service;
	
	@PostMapping("/add")
	public Setting add(@RequestBody Setting setting) {
		System.out.println("In /add");
		return service.update(setting);
		
	}
	@PatchMapping("/update")
	public Setting update(@RequestBody Setting newSetting) {
		System.out.println(service.get());
		Setting old=service.del(service.get());
		System.out.println(old);
		return service.update(newSetting);
		
	}
	
}
