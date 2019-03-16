package com.ssh.controller.drugstorage;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugInventory;
import com.ssh.service.drugstorage.InventoryService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.PandianVo;

@Controller
public class InventoryController {
	@Autowired
	private InventoryService IService;
	
	@GetMapping("to_inventory")
	@ResponseBody
	public String INumber(){
		return CommentOrder.commOrder(IService.INumber(), "PD");
	}
	
	/**
	 * 添加盘点详情
	 * @param drugId
	 * @param drugName
	 * @param drugPfprice
	 * @param jcnum
	 * @param jcdw
	 * @param kynum
	 * @param kyje
	 * @param ph
	 */
	@PostMapping("/to_add_pdXq")
	@ResponseBody
	public void addPdxq(String drugId,String drugName,BigDecimal drugPfprice,BigDecimal jcnum,
			String jcdw,BigDecimal kynum,BigDecimal kyje,String ph){
		IService.addPdXq(drugId, drugName, drugPfprice, jcnum, jcdw, kynum, kyje, ph);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/to_select_all")
	@ResponseBody
	public List<PandianVo> selectAll(){
		return IService.selectAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/to_clear_all")
	@ResponseBody
	public void clear(){
		IService.clear();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@GetMapping("/to_delete_all")
	@ResponseBody
	public Errors deleteAll(String id){
		return IService.delectAll(CommentOrder.dealString(id));
	}
	
	/**
	 * 添加盘点处理
	 * @param di
	 * @param empId
	 * @return
	 */
	@PostMapping("/to_insert_pandian_chuli")
	@ResponseBody
	public Errors insertPandianChuli(DrugInventory di,Long empId){
		return IService.insertPandianChuli(di, empId);
	}
}
