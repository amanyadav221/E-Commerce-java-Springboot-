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
			dto.setSiteName(s.getSiteName());
			dto.setAddressOne(s.getAddressOne());
			dto.setAddressTwo(s.getAddressTwo());
			dto.setMapOne(s.getMapOne());
			dto.setMapTwo(s.getMapTwo());
			dto.setEmail(s.getEmail());
			dto.setPhone(s.getPhone());
			dto.setWhatsapp(s.getWhatsapp());
			dto.setLinkedIn(s.getLinkedIn());
			dto.setGitHub(s.getGitHub());
			dto.setInstagram(s.getInstagram());
			dto.setCustomer(s.getCustomer());
			dto.setRefund(s.getRefund());
		}

		return dto;
	}

}
