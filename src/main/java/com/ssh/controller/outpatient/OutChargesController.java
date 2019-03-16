package com.ssh.controller.outpatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ChargeManagement;
import com.ssh.pojos.DrugYaofang;
import com.ssh.service.outpatient.OutpatientChargeService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.EletronicPrescriVo;
import com.ssh.vo.outpatient.OutRegistChargesVo;

@Controller
public class OutChargesController {

	@Autowired
	private OutpatientChargeService outPatientService;
	
	@GetMapping("/query_outchargeswei_all")
	@ResponseBody
	public List<OutRegistChargesVo> queryOutRegistCharges(String outpaitentRegistId){
		return outPatientService.queryOutRegistCharges(outpaitentRegistId);
		
	}

	@PostMapping("/add_outpatientcharges")
	@ResponseBody
	public Errors addOutPatientCharges(ChargeManagement c,String outpaitentRegistId,String prescriptionId){
		return outPatientService.addPatientCharges(c,outpaitentRegistId,prescriptionId);
	}
	
	@GetMapping("/update_chargresZt")
	@ResponseBody
	public Errors updateCharges(String id , String typeName){
		return outPatientService.updateYiShouChargeZT(id,typeName);
	}
	
	@GetMapping("/query_regist_fayao")
	@ResponseBody
	public List<EletronicPrescriVo> queryOutRegistFaYao(String outpaitentRegistId){
		return outPatientService.queryEleRegistFaYao(outpaitentRegistId);
	}
	
	@PostMapping("/add_outpatient_pills")
	@ResponseBody
	public Errors addOutPatientFaYao(String id, DrugYaofang drug,String outpaitentRegistId,String prescriptionId,Long empId){
		return outPatientService.addPatientPills(CommentOrder.dealString(id), drug,outpaitentRegistId,prescriptionId,empId);
	}
	
	@GetMapping("/query_outpatientpills_state")
	@ResponseBody
	public Errors queryOutPatientState(String outpaitentRegistId){
		return outPatientService.queryOutPatientState(outpaitentRegistId);
	}
}
