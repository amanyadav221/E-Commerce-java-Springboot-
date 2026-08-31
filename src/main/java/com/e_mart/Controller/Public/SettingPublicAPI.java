package com.e_mart.Controller.Public;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.SettingDTO;
import com.e_mart.Entity.Setting;
import com.e_mart.Service.BrandService;
import com.e_mart.Service.ProductService;
import com.e_mart.Service.SettingService;

@RestController
@RequestMapping("/public/setting")
public class SettingPublicAPI {
	@Autowired
	private SettingService service;
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;

	@GetMapping("/get-all")
	public SettingDTO get() {
		Setting s = service.get();
		SettingDTO dto = new SettingDTO();
		
		dto.setProducts(productService.getNumberOfProduct());
		dto.setBrands(brandService.getNumberOfBrands());

		if (s != null) {
			dto.setSiteName(s.getSiteName() != null ? s.getSiteName() : "");
			dto.setAddressOne(s.getAddressOne() != null ? s.getAddressOne() : "");
			dto.setAddressTwo(s.getAddressTwo() != null ? s.getAddressTwo() : "");
			dto.setMapOne(s.getMapOne() != null ? s.getMapOne() : "");
			dto.setMapTwo(s.getMapTwo() != null ? s.getMapTwo() : "");
			dto.setEmail(s.getEmail() != null ? s.getEmail() : "");
			dto.setPhone(s.getPhone() != null ? s.getPhone() : "");
			dto.setWhatsapp(s.getWhatsapp() != null ? s.getWhatsapp() : "");
			dto.setLinkedIn(s.getLinkedIn() != null ? s.getLinkedIn() : "");
			dto.setGitHub(s.getGitHub() != null ? s.getGitHub() : "");
			dto.setInstagram(s.getInstagram() != null ? s.getInstagram() : "");
			dto.setCustomer(s.getCustomer());
			dto.setRefund(s.getRefund());
		} else {
			dto.setSiteName("");
			dto.setAddressOne("");
			dto.setAddressTwo("");
			dto.setMapOne("");
			dto.setMapTwo("");
			dto.setEmail("");
			dto.setPhone("");
			dto.setWhatsapp("");
			dto.setLinkedIn("");
			dto.setGitHub("");
			dto.setInstagram("");
		}

		return dto;
	}

}
