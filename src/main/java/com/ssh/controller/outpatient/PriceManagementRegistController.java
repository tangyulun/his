package com.ssh.controller.outpatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.outpatient.OutpatientChargeService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.EletronicPrescriVo;
import com.ssh.vo.doctor.HospitalProjectVo;
import com.ssh.vo.outpatient.OutRegistChargesVo;

/**
 * 门诊划价收费类
 * @author Administrator
 *
 */
@Controller
public class PriceManagementRegistController {

	@Autowired
	private OutpatientChargeService chargeService;
	
	//查询划价管理的药品表格
	@GetMapping("/query_eletronic_perscri")
	@ResponseBody
	public List<EletronicPrescriVo> queryEletronicPrescri(String outpaitentRegistId){
		return chargeService.queryEletronicPrescri(outpaitentRegistId);
	}
	
	//查询检验，治疗，治疗等选项卡
	@GetMapping("/query_hospital_typename")
	@ResponseBody
	public List<HospitalProjectVo> queryJianYan(String outpaitentRegistId,String typeName){
		return chargeService.queryJianYan(outpaitentRegistId, typeName);
	}
	
	@GetMapping("/update_pricemanagement_all")
	@ResponseBody
	public Errors queryCharges(String id,String financialHistoryShoufeilx,String outpaitentRegistId){
		return chargeService.updateChargeZT(id , financialHistoryShoufeilx, outpaitentRegistId);
	}
	
	
}
