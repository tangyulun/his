package com.ssh.controller.pharmacy;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.PharmacyInventory;
import com.ssh.service.pharmacy.PInventoryService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.pharmacy.YaopingPandianVo;

@Controller
public class PInventoryController {

	@Autowired
	private PInventoryService PIService;
	
	/**
	 * 点击加入将form的值传入datagrid中
	 * @param drugId
	 * @param drugBname
	 * @param jcnum
	 * @param jcdw
	 * @param drugLsprice
	 * @param kyje
	 * @param kynum
	 * @param ph
	 */
	@PostMapping("/insert_pharmacy_pandian_xq")
	@ResponseBody
	public void selectPandianXq(String drugId,String drugBname,BigDecimal jcnum , 
			String jcdw, BigDecimal drugLsprice , BigDecimal kyje , BigDecimal kynum , String ph, BigDecimal kcnum){
		PIService.selectPandianXq(drugId, drugBname, jcnum, jcdw, drugLsprice, kyje, kynum, ph , kcnum);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/select_pharmacy_pandain_xq")
	@ResponseBody
	public List<YaopingPandianVo> selectAll(){
		return PIService.selectAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/to_clear_pandian_xq_all")
	@ResponseBody
	public void clear(){
		PIService.clear();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@GetMapping("/to_delete_pandian_xq_all")
	@ResponseBody
	public Errors delete(String id){
		return PIService.delete(CommentOrder.dealString(id));
	}
	
	/**
	 * 添加药房盘点处理
	 * @param pi
	 * @return
	 */
	@PostMapping("/to_insert_yaofan_xq")
	@ResponseBody
	public Errors insertPandianXq(PharmacyInventory pi){
		return PIService.insertYaofanPd(pi);
	}
}
