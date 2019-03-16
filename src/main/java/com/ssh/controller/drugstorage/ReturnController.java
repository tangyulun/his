package com.ssh.controller.drugstorage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugTuihuo;
import com.ssh.service.drugstorage.ReturnService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.TuihuoVo;
import com.ssh.vo.drugstorage.YanshouVo;

@Controller
public class ReturnController {
	@Autowired
	private ReturnService RService;
	
	
	@GetMapping("to_return")
	@ResponseBody
	public String WNumber(){
		return CommentOrder.commOrder(RService.RNumber(), "TH");
	}
	
	
	/**
	 * 退货详情
	 * @param drugAcceptanceId
	 * @return
	 */
	@GetMapping("/to_select_tuihou_xq")
	@ResponseBody
	public List<TuihuoVo> selectThxq(String drugAcceptanceId){
		return RService.selectThxq(drugAcceptanceId);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/to_find_tuihuo_xq")
	@ResponseBody
	public List<TuihuoVo> findAll(){
		return RService.FindAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/to_clear_tuihuo_xq")
	@ResponseBody
	public void clear(){
		RService.clear();
	}
	
	/**
	 * 退货处理
	 * @param dt
	 * @param empId
	 * @param supplierId
	 * @return
	 */
	@PostMapping("/to_insert_tuihuo_chuli")
	@ResponseBody
	public Errors insertTuihuoChuli(DrugTuihuo dt,Long empId,String supplierId,String drugAcceptanceId){
		return RService.insertTuihuoChuli(dt, empId, supplierId, drugAcceptanceId);
	}
	
	/**
	 * 计算退货金额
	 * @return
	 */
	@GetMapping("/to_jisuan_tuihuo_money")
	@ResponseBody
	public double JisuanMoney(){
		return RService.JisuanMoney();
	}
}
