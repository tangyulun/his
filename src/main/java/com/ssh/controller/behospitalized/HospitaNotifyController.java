package com.ssh.controller.behospitalized;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.HospitaNotify;
import com.ssh.service.behospitalized.HospitaNotifyService;
import com.ssh.service.behospitalized.OutpaitentRegistService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;
import com.ssh.vo.outpatient.MedicalVo;
/**
 * 住院通知
 * @author 唐雨伦
 *
 */
@Controller
public class HospitaNotifyController {
	@Autowired
	private HospitaNotifyService hospitanotifyservice;
	
	@Autowired
	private OutpaitentRegistService outservice;
	/**
	 * 获取住院通知号
	 * @return
	 */
	@GetMapping("/get_number_notify")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(hospitanotifyservice.getNumber(),"HN");
	}
	/**
	 * 根据门诊号来查询所有的门诊挂号
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_regist")
	@ResponseBody
	public Map<String , Object> selectAllRegist(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<OutpaitentRegistVo> list = outservice.selectAllRegist(page, rows);
		map.put("total", outservice.count());
		map.put("rows", list);
		return map;
 	}
	/**
	 * 根据门诊号来查询门诊挂号
	 * @param page
	 * @param rows
	 * @param outpaitentRegistId
	 * @return
	 */
	@GetMapping("/select_type_regist")
	@ResponseBody
	public Map<String , Object> selectTypeRegist(int page , int rows , String outpaitentRegistId){
		Map<String , Object> map = new HashMap<>();
		List<OutpaitentRegistVo> list = outservice.selectOutpaitentRegistIdWhere(page, rows, outpaitentRegistId);
		map.put("total", outservice.selectOutpaitentRegistIdWhereCount(outpaitentRegistId));
		map.put("rows", list);
		return map;
	}
	/**
	 * 根据startDate到endDate来查询
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param outpaitentRegistId
	 * @return
	 */
	@GetMapping("/selectDate_start_end")
	@ResponseBody
	public Map<String , Object> selectStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String outpaitentRegistId){
		Map<String , Object> map = new HashMap<>();
		List<OutpaitentRegistVo> list1 = outservice.selectStartDateToEndDate(page, rows, startTime, endTime, outpaitentRegistId);
		map.put("total", outservice.queryStartEndcount());
		map.put("rows", list1);
		return map;
	}
	/**
	 * 添加住院通知记录
	 * @param hospitaNotify
	 * @param outpaitentRegistId
	 * @return
	 */
	@PostMapping("/add_hospitaNotify")
	@ResponseBody
	public Errors addHospitaNotify(String state , HospitaNotify hospitaNotify,String outpaitentRegistId){
		return hospitanotifyservice.addHospitaNotify(state,hospitaNotify, outpaitentRegistId);
	}
	/**
	 * 查询所有的住院通知记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_hospitalNotify")
	@ResponseBody
	public Map<String , Object> selectAllHospitaNotify(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<HospitaNotifyVo> list = hospitanotifyservice.selectAllHospitaNotify(page, rows);
		map.put("total", hospitanotifyservice.count());
		map.put("rows", list);
		return map;
	}
	/**
	 * 根据住院通知号来查询住院通知记录
	 * @param page
	 * @param rows
	 * @param hospitalNotifyNumber
	 * @return
	 */
	@GetMapping("/select_where_hospitalNotifyName")
	@ResponseBody
	public Map<String , Object> selectHospitaNotifyWhere(int page , int rows , String hospitalNotifyNumber){
		Map<String , Object> map = new HashMap<>();
		List<HospitaNotifyVo> list = hospitanotifyservice.selectHospitaNotifyWhere(page, rows, hospitalNotifyNumber);
		map.put("total", hospitanotifyservice.selectHospitalNotifyWhereCount(hospitalNotifyNumber));
		map.put("rows", list);
		return map;
	}
	/**
	 * 根据时间和住院通知号来查询住院通知记录
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param hospitalNotifyNumber
	 * @return
	 */
	@GetMapping("/select_hospita_Date_start_end")
	@ResponseBody
	public Map<String , Object> selectHosStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String hospitalNotifyNumber){
		Map<String , Object> map = new HashMap<>();
		List<HospitaNotifyVo> list1 = hospitanotifyservice.selectHosStartDateToEndDate(page, rows, startTime, endTime, hospitalNotifyNumber);
		map.put("total", hospitanotifyservice.queryStartEndcount());
		map.put("rows", list1);
		return map;
	}
}
