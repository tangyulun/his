package com.ssh.controller.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.pharmacy.PharmacyService;
import com.ssh.utils.CommentOrder;

@Controller
public class PharmacyController {
	@Autowired
	private PharmacyService PService;
	
	/**
	 * 门诊发药
	 * @return
	 */
	@GetMapping("to_outpatientpills")
	@ResponseBody
	public String OPNumber(){
		return CommentOrder.commOrder(PService.OPNumber(), "MZ");
	}
	
	/**
	 * 住院发药
	 * @return
	 */
	@GetMapping("to_hospitalpills")
	@ResponseBody
	public String HPNumber(){
		return CommentOrder.commOrder(PService.HPNumber(), "ZY");
	}
	
	/**
	 * 药房盘点
	 * @return
	 */
	@GetMapping("to_pharmacyinventory")
	@ResponseBody
	public String PINumber(){
		return CommentOrder.commOrder(PService.PINumber(), "PD");
	}
}
