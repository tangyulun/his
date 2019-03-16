package com.ssh.controller.doctor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Prescription;
import com.ssh.service.doctor.ElectronicService;
import com.ssh.service.doctor.EletronicHospitalService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.DrugChuFangVO;
import com.ssh.vo.doctor.EletronicPrescriVo;
import com.ssh.vo.doctor.HospitalProjectVo;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.outpatient.OutRegistVo;

@Controller
public class EletronicPrescriController {

	@Autowired
	private EletronicHospitalService hospitalService;
	@Autowired
	private ElectronicService eletronicService;
	
	@GetMapping("/add_HospitalPresc")
	@ResponseBody
	public void addHospitalPresc(HospitalProjectVo project){
		hospitalService.addHospitalProject(project);
	}
	
	@GetMapping("/query_Hospital")
	@ResponseBody
	public List<HospitalProjectVo> queryHospital(){
		return hospitalService.queryHospital();
	}
	
	@GetMapping("/clear_Hospital")
	@ResponseBody
	public void clearHospital(){
		 hospitalService.clearHospital();
	}
	
	@GetMapping("/delete_code")
	@ResponseBody
	public void deleteGridCode(String idCode){
		hospitalService.deleteGridCode(CommentOrder.dealString(idCode));
	}
	
	//查询电子处方
	@GetMapping("/query_drug")
	@ResponseBody
	public Map<String,Object> queryDrug(int page,int rows){
		List<DrugChuFangVO> list = eletronicService.queryDrug(page, rows);
		Map<String,Object> map = new HashMap<>();
		map.put("total", eletronicService.queryDrugCount());
		map.put("rows", list);
		return map;
	}
	
	//通过药库类型id查询所有
	@GetMapping("/query_drug_typeId")
	@ResponseBody
	public Map<String, Object> queryDrugFindByTypeId(int page, int rows, Long drugTypeId){
		List<DrugChuFangVO> list = eletronicService.queryDrugFindByTypeId(page,rows,drugTypeId);
		Map<String,Object> map = new HashMap<>();
		map.put("total", eletronicService.queryDrugCounts(drugTypeId));
		map.put("rows", list);
		return map;
	}
	
	//添加处方开药记录
	@GetMapping("/add_drug_all")
	@ResponseBody
	public void addDrug(EletronicPrescriVo e){
		eletronicService.addDrugAll(e);
	}
	
	@GetMapping("/query_drug_all")
	@ResponseBody
	public List<EletronicPrescriVo> queryEleAll(){
		return eletronicService.queryEleAll();
	}
	
	@GetMapping("/clear_eletronic")
	@ResponseBody
	public void clear(){
		eletronicService.clear();
	}
	
	@GetMapping("/delete_drug")
	@ResponseBody
	public void deleteFindById(String ids){
		eletronicService.deleteDrug(CommentOrder.dealString(ids));
	}
	
	//修改记录
	@GetMapping("/update_drug_code")
	@ResponseBody
	public void updateDrugCode(EletronicPrescriVo ele,int id , BigDecimal num){
		eletronicService.updataDrugCodes(ele,id , num);
	}

	//查询总金额
	@GetMapping("/select_sum_money")
	@ResponseBody
	public double selectNumMoney(){
		
		double money =  eletronicService.sumMoney();
		double money2 = hospitalService.sumMoney();
		return money + money2;
	}
	
	
	/**
	 * 修改药品数量
	 */
	@GetMapping("/update_kucun_num")
	@ResponseBody
	public Errors updateKucunNum(int kucunNum , String drugId){
		return eletronicService.updateKucunNum(kucunNum , drugId);
	}
	
	/**
	 * 
	 * @param p
	 * @param outRegistId
	 * @param empId
	 * @param state
	 * @return
	 */
	@PostMapping("/add_prescription")
	@ResponseBody
	public Errors addEletronic(Prescription p,String outRegistId,Long empId , String eType , String hId){
		Errors e = eletronicService.insertEletronic(p, outRegistId,empId ,  eType , hId);
		hospitalService.saveSFJL(outRegistId , hId);
		eletronicService.addEletonic(p , hId);
		return e;
	}
	
	//根据门诊号查询处方号
	@GetMapping("/query_prescrition")
	@ResponseBody
	public Errors  queryPrescrition(String outpaitentRegistId){
		return eletronicService.queryPrescrition(outpaitentRegistId);
	}
	
	
}
