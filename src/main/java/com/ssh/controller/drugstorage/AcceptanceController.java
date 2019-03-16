package com.ssh.controller.drugstorage;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugAcceptance;
import com.ssh.service.drugstorage.AcceptanceService; 
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.drugstorage.YanshouVo;

@Controller
public class AcceptanceController {
	
	@Autowired 
	private AcceptanceService ASerivce;
	
	@GetMapping("to_acceptance")
	@ResponseBody 
	public String ANumber(){
		return CommentOrder.commOrder(ASerivce.ANumber(),"DA");
	}
	
	/**
	 * 根据采购订单查询验收详情
	 * @param drugPurchaseId
	 * @return
	 */
	@GetMapping("/to_select_Yanshou")
	@ResponseBody
	public List<YanshouVo> selectYanshouXq(String drugPurchaseId){
		return ASerivce.selectYanshouXq(drugPurchaseId);
	}
	
	/**
	 * 挂单和处理
	 * @param da
	 * @param drugPurchaseId
	 * @param state
	 * @return
	 */
	@PostMapping("/to_insert_guadan_and_chuli")
	@ResponseBody
	public Errors insertGuadanAndChuli(DrugAcceptance da,String drugPurchaseId){
		return ASerivce.insertGuadanAndChuli(da, drugPurchaseId);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/to_findAll")
	@ResponseBody
	public List<YanshouVo> findAll(){
		return ASerivce.FindAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/to_clear")
	@ResponseBody
	public void clear(){
		ASerivce.clear();
	}
	
	@GetMapping("/update_table_ys")
	@ResponseBody
	public void update(int id , BigDecimal hgnum){
		ASerivce.update(id , hgnum);
	}
	
	/**
	 * 查询验收记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_find_yanshou_jilu")
	@ResponseBody
	public Map selectJilu(int page,int rows){
		List<AcceptanceVo> list=ASerivce.selectJilu(page, rows);
		Map map=new HashMap<>();
		map.put("total",ASerivce.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询不合格记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/to_find_Nohege_jilu")
	@ResponseBody
	public Map selectNohegeJilu(int page,int rows){
		List<AcceptanceVo> list=ASerivce.selectNohegeJilu(page, rows);
		Map map=new HashMap<>();
		map.put("total", ASerivce.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询总金额
	 * @return
	 */
	@GetMapping("/to_select_money")
	@ResponseBody
	public double selectMoney(){
		return ASerivce.selectZMoney();
	}
	
	/**
	 * 获取系统当前时间
	 */
	@GetMapping("/huoqu-time")
	@ResponseBody
	public String  currentTime(){
		return new SimpleDateFormat("hh:mm:ss").format(new Date());
	}
	
	/**
	 * 模糊查询根据采购订单号
	 * @param drugAcceptanceId
	 * @param page
	 * @param rows
	 * @return
	 */
	/*@RequestMapping("/to_mohufind_By_drugAcceptanceId_a")
	@ResponseBody
	public Map<String,Object> mohufindById(String drugAcceptanceId , int page ,int rows){
		List<AcceptanceVo> list = ASerivce.mohufindById(drugAcceptanceId, page, rows);
		Map<String , Object> map = new HashMap<>();
		System.out.println(drugAcceptanceId);
		map.put("total", ASerivce.mohufindByIdCount(drugAcceptanceId));
		map.put("rows", list);
		return map;
	}*/
	
	@GetMapping("/to_mohufind_By_drugAcceptanceId_abc")
	@ResponseBody
	public Map<String,Object> mohufindById(String drugAcceptanceId,int page,int rows){
		List<AcceptanceVo> dv=ASerivce.mohufindById(drugAcceptanceId,page, rows);
		Map<String,Object> map=new HashMap<>();
		map.put("total", ASerivce.mohufindByIdCount(drugAcceptanceId));
		map.put("rows", dv);
		return map;
	}
}


