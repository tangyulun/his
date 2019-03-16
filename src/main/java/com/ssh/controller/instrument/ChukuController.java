package com.ssh.controller.instrument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.QxThelibrary;
import com.ssh.service.instrument.ChukuService;

import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.CKxiangqingVo;

@Controller
public class ChukuController {
	@Autowired
	public ChukuService serviu;
	
	/**
	 * 
	 * 出库单号
	 */
	@RequestMapping("/ckdanhao")
	@ResponseBody	
	public String cgdanhao(){
		return CommentOrder.commOrder(serviu.ckuku(),"QC");
		
	}
	//填进table
	@PostMapping("/get_andinstrument_ck")
	@ResponseBody
	public void slelectqxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		serviu.slelectqxxq(instrumentId, instrumentName, shuliang, danwei, instrumentRemark);
		
	}
	//显示
	@GetMapping("/select_dao_ddddd")
	@ResponseBody	
	public List<CKxiangqingVo> selectyanshoo(){
		return serviu.selectyanshoo();
		
	}
	//删除
	@GetMapping("/delect_instrument_chuku")
	@ResponseBody
	//删除采购记录
	public Errors delectinstrument(String qx){
		return serviu.deletextinstrument(CommentOrder.dealString(qx));
		
	}
	//出库处理
	@PostMapping("/chuli_andinstrument_ck")
	@ResponseBody
	public Errors instrumentck(QxThelibrary a , Long empId){
		return serviu.instrumentck(a, empId);
		
	}
	
	 //查询所有
	@GetMapping("/select_ruku_xq")
	@ResponseBody
	public  List<CKxiangqingVo> selectAll(){
		return serviu.selectAll();
		
	}
	//清楚
	@GetMapping("/update_ruku_xq")
	@ResponseBody
	public void clear(){
		serviu.clear();
	}
	
	
	
	}
