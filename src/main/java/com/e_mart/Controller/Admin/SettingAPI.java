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
		Setting existing = service.get();
		if (existing == null) {
			return service.update(newSetting);
		}

		if (newSetting.getSiteName() != null && !newSetting.getSiteName().trim().isEmpty()) {
			existing.setSiteName(newSetting.getSiteName());
		}
		if (newSetting.getAddressOne() != null && !newSetting.getAddressOne().trim().isEmpty()) {
			existing.setAddressOne(newSetting.getAddressOne());
		}
		if (newSetting.getAddressTwo() != null && !newSetting.getAddressTwo().trim().isEmpty()) {
			existing.setAddressTwo(newSetting.getAddressTwo());
		}
		if (newSetting.getMapOne() != null && !newSetting.getMapOne().trim().isEmpty()) {
			existing.setMapOne(newSetting.getMapOne());
		}
		if (newSetting.getMapTwo() != null && !newSetting.getMapTwo().trim().isEmpty()) {
			existing.setMapTwo(newSetting.getMapTwo());
		}
		if (newSetting.getEmail() != null && !newSetting.getEmail().trim().isEmpty()) {
			existing.setEmail(newSetting.getEmail());
		}
		if (newSetting.getPhone() != null && !newSetting.getPhone().trim().isEmpty()) {
			existing.setPhone(newSetting.getPhone());
		}
		if (newSetting.getWhatsapp() != null && !newSetting.getWhatsapp().trim().isEmpty()) {
			existing.setWhatsapp(newSetting.getWhatsapp());
		}
		if (newSetting.getLinkedIn() != null && !newSetting.getLinkedIn().trim().isEmpty()) {
			existing.setLinkedIn(newSetting.getLinkedIn());
		}
		if (newSetting.getGitHub() != null && !newSetting.getGitHub().trim().isEmpty()) {
			existing.setGitHub(newSetting.getGitHub());
		}
		if (newSetting.getInstagram() != null && !newSetting.getInstagram().trim().isEmpty()) {
			existing.setInstagram(newSetting.getInstagram());
		}
		if (newSetting.getCustomer() > 0) {
			existing.setCustomer(newSetting.getCustomer());
		}
		if (newSetting.getRefund() > 0) {
			existing.setRefund(newSetting.getRefund());
		}

		return service.update(existing);
	}
}
