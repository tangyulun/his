package com.ssh.controller.doctor;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.BeOnDutyPlan;
import com.ssh.service.doctor.ZhiBanService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.BeOnDutyPlanVO;

@Controller
public class ZhiBanController {
	
	@Autowired
	private ZhiBanService zbSer;
	
	@PostMapping("/insert_paiban_plan")
	@ResponseBody
	public Errors insertPaiBan(BeOnDutyPlan be , String mess){
		return zbSer.insertPaiBanPlan(be , mess);
	}
	
	@GetMapping("/select_all_paiban")
	@ResponseBody
	public List<BeOnDutyPlanVO> selectAllPaiBan(){
		return zbSer.selectAll();
	}
	
	@GetMapping("/select_all_paiban2")
	@ResponseBody
	public List<BeOnDutyPlanVO> selectAllUpdateCopy(){
		return zbSer.selectAllUpdateCopy();
	}
	@PostMapping("/update_paiban_message")
	@ResponseBody
	public Errors updatePaiBanMessage(String planId , String mess){
		System.err.println(planId);
		return zbSer.updatePaiBanMessage(planId , mess);
	}
	
	
	@GetMapping("/select_today_id")
	@ResponseBody
	public Errors selectTodayId(){
		return  zbSer.selectTodayId(CommentOrder.week(GregorianCalendar.MONDAY));
	}
}
