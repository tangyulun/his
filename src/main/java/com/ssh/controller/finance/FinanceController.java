package com.ssh.controller.finance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.finance.HospitailzaService;
import com.ssh.service.finance.SupplierJiesuanService;
import com.ssh.utils.CommentOrder;
import com.ssh.vo.finance.FuKuanVo;
import com.ssh.vo.finance.ParentTypeVo;

@Controller
public class FinanceController {

	@Autowired
	private HospitailzaService hospitalService;
	@Autowired
	private SupplierJiesuanService supplierService;
	
	//סԺ��宿舍
	@GetMapping("/h_number")
	@ResponseBody
	public String HNumber(){
		return CommentOrder.commOrder(hospitalService.HNumber(), "HJ");
				
	}
	
	//��Ӧ�̱��
	@GetMapping("/s_number")
	@ResponseBody
	public String SNumber(){
		return CommentOrder.commOrder(supplierService.supplierNumber(), "SJ");
	}
	
	/**
	 * 查看所有应收款项
	 */
	@GetMapping("/select_all_shoukuan")
	@ResponseBody
	public List<ParentTypeVo> selectAllShoukuan(){
		return supplierService.selectAllYF();
	}
}
