package com.ssh.controller.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.behospitalized.HouseTypeService;
import com.ssh.utils.Errors;

@Controller
public class HouseTypeController {
	@Autowired
	private HouseTypeService housetypeservice;
	/**
	 * 添加病床
	 * @param bedTypeName
	 * @return
	 */
	@PostMapping("/add_house_type")
	@ResponseBody
	public Errors addNewEmp(String bedTypeName) {
		return housetypeservice.addHouseType(bedTypeName);
	}
}
