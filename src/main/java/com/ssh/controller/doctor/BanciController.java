package com.ssh.controller.doctor;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Bclass;
import com.ssh.service.doctor.BanciService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.BanciVO;
import com.ssh.vo.staff.Other;

@Controller
public class BanciController {
	@Autowired
	private BanciService bser;
	
	@GetMapping("/select_all_banci")
	@ResponseBody
	public Map<String , Object> selectAll(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		map.put("total", selectAll());
		map.put("rows",  bser.selectAll(page, rows));
		return map;
	}
	
	
	@GetMapping("/select_all_banci_to_plan")
	@ResponseBody
	public List<BanciVO> selectAllPlan(int page , int rows){
		return bser.selectAll(page, rows);
	}
	
	@GetMapping("/select_banci_count")
	@ResponseBody
	public long selectAll(){
		return bser.count();
	}
	
	@PostMapping("/insert_banci")
	@ResponseBody
	public Errors insert(Bclass b , String bclassesBetTimeEnd){
		return bser.insert(b , bclassesBetTimeEnd);
	}
	
	@PostMapping("/update_banci")
	@ResponseBody
	public Errors update(Bclass b , String bclassesBetTimeEnd){
		return bser.update(b , bclassesBetTimeEnd);
	}
	
	@GetMapping("/delete_banci")
	@ResponseBody
	public Errors delete(long bclassId){
		return bser.delete(bclassId);
	}
	
	@GetMapping("/find_monday_sunday")
	@ResponseBody
	public Other findMondaySunday(){
		return new Other(CommentOrder.week(GregorianCalendar.MONDAY), CommentOrder.week(GregorianCalendar.SUNDAY));
	}
	
	@GetMapping("/find_everyday")
	@ResponseBody
	public List<String> findEveryDay(Date monday){
		return CommentOrder.everyDay(monday , 0 , 7);
	}
	
	@GetMapping("/select_date_to_money")
	@ResponseBody
	public Date selectDateMoney(Date date){
		return CommentOrder.getMonDayToDate(date);
	}
	
	@GetMapping("/next_week")
	@ResponseBody
	public Other nextWeek(Date monday){
		return CommentOrder.lNWeek(monday , 7 , 6);
	}
	
	@GetMapping("/last_week")
	@ResponseBody
	public Other lastWeek(Date monday){
		return CommentOrder.lNWeek(monday , -7 , 6 );
	}
	
	
	@GetMapping("/next_week_tow")
	@ResponseBody
	public List<String> nextWeekTow(Date monday){
		return CommentOrder.everyDay(monday, 7, 14);
	}
	@GetMapping("/last_week_tow")
	@ResponseBody
	public List<String> lastWeekTow(Date monday){
		return CommentOrder.everyDay(monday, -7, 0);
	}

}
