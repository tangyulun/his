package com.ssh.controller.behospitalized;

import com.ssh.pojos.HospitalRegistration;
import com.ssh.service.behospitalized.HospitalRegistrationService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HospitalRegistrationController {
	
	@Autowired
	private HospitalRegistrationService hospitalservice;
	/**
	 * 获取住院登记号
	 */
	@GetMapping("/get_number")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(hospitalservice.getNumber(),"DJ");
	}
	/**
	 * 添加住院登记记录
	 * @param state
	 * @param hospitalRegistration
	 * @param bedId
	 * @param empId
	 * @param hospitalNotifyNumber
	 * @return
	 */
	@PostMapping("/add_hospitalRegistration")
	@ResponseBody
	public Errors addHospitalRegistration(String state,HospitalRegistration hospitalRegistration,String bedId,Long empId,String hospitalNotifyNumber){
		return hospitalservice.addHospitalRegistration(state,hospitalRegistration, bedId, empId, hospitalNotifyNumber);
	}
	/**
	 * 查询住院登记记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_hospitalRegistration")
	@ResponseBody
	public Map<String , Object> selectAllHospitalRegistration(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<HospitalRegistrationVo> list = hospitalservice.selectAllHospitalRegistration(page, rows);
		map.put("total", hospitalservice.count());
		map.put("rows", list);
		return map;
	}

}
