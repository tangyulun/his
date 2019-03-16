package com.ssh.controller.drugstorage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugWarehouse;
import com.ssh.service.drugstorage.RukuVo;
import com.ssh.service.drugstorage.WarehouseService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Controller
public class WarehouseController {
	@Autowired
	private WarehouseService WService;
	
	@GetMapping("to_warehouse")
	@ResponseBody
	public String WNumber(){
		return CommentOrder.commOrder(WService.WNumber(), "RK");
	}
	
	/**
	 * 根据验收id查询验收详情
	 * @param drugAcceptanceId
	 * @return
	 */
	@GetMapping("/to_findruku_byAccId")
	@ResponseBody
	public List<RukuVo> selectRukuXq(String drugAcceptanceId){
		return WService.selectRukuXq(drugAcceptanceId);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/to_findAll_yanshou")
	@ResponseBody
	public List<RukuVo> selectAll(){
		return WService.findAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("to_clear_yanshou_all")
	@ResponseBody
	public void clear(){
		WService.clear();
	}
	
	/**
	 * 入库处理
	 * @param dw
	 * @param drugAcceptanceId
	 * @param state
	 * @return
	 */
	@PostMapping("/to_insert_ware_chuli")
	@ResponseBody
	public Errors insertchuli(DrugWarehouse dw,String drugAcceptanceId){
		return WService.insertChuli(dw, drugAcceptanceId);
	}
	
}
