package com.ssh.controller.nurse;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ZhuyuanFayao;
import com.ssh.service.nurse.ZhuyuanFayaoService;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.nurse.PrescriptionRecodeVo;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.nurse.ZhuyuanFaYaoVo;

@Controller
public class ZhuyuanFayaoController {
	@Autowired
	private ZhuyuanFayaoService fayao;
	
	/**
	 * 根据处方来查询药品信息
	 * @param prescriptionId
	 * @return
	 */
	@GetMapping("/select_all_prescriptionRecode")
	@ResponseBody
	public List<PrescriptionRecodeVo> selectPrescriptionRecode(String prescriptionId){
		return fayao.selectPrescriptionRecode(prescriptionId);
	}
	/**
	 * 查询处方
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_prescriptions")
	@ResponseBody
	public Map<String , Object> selectPrescription(int page, int rows){
		Map<String , Object> map = new HashMap<>();
		List<PrescriptionVo> list = fayao.selectPrescription(page, rows);
		map.put("total", fayao.count());
		map.put("rows", list);
		return map;
	}
	/**
	 * 根据处方号来查询
	 * @param page
	 * @param rows
	 * @param prescriptionId
	 * @return
	 */
	@GetMapping("/select_where_prescriptionId")
	@ResponseBody
	public Map<String , Object> selectPrescriptionByName(int page , int rows , String prescriptionId){
		Map<String , Object> map = new HashMap<>();
		List<PrescriptionVo> list = fayao.selectPrescriptionByName(page, rows, prescriptionId);
		map.put("total", fayao.findPrescriptionId(prescriptionId));
		map.put("rows", list);
		return map;
	}
	@GetMapping("/select_prescription_Date_start_end")
	@ResponseBody
	public Map<String , Object> selectPrescriptionStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String prescriptionId){
		Map<String , Object> map = new HashMap<>();
		List<PrescriptionVo> list1 = fayao.selectPrescriptionStartDateToEndDate(page, rows, startTime, endTime, prescriptionId);
		map.put("total", fayao.queryStartEndcount());
		map.put("rows", list1);
		return map;
	}
	/**
	 * 添加住院发药记录
	 * @param zhuyuanfayao
	 * @param hospitalRegistrationId
	 * @param empId
	 * @param prescriptionId
	 * @return
	 */
	@PostMapping("/add_Zhuyuanfayao")
	@ResponseBody
	public Errors addZhuyuanfayao(ZhuyuanFayao zhuyuanfayao,String hospitalRegistrationId,Long empId,String prescriptionId){
		return fayao.addZhuyuanfayao(zhuyuanfayao, hospitalRegistrationId, empId, prescriptionId);
	}
	@GetMapping("/select_zhuyuan_dengji")
	@ResponseBody
	public HospitalRegistrationVo selectZhuYuanDengji(String number) {
		return fayao.selectZhuYuanDengji(number);
	}
}
