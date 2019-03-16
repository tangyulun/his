package com.ssh.controller.instrument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.QxLnventory;
import com.ssh.service.instrument.PandianSevrice;

import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.CKxiangqingVo;
import com.ssh.vo.instrument.PdxiangqingVo;

@Controller
public class PandianController {
	@Autowired
	public PandianSevrice serviee;
	
	/**
	 * 
	 * 盘点单号
	 */
	@RequestMapping("/pddanhao")
	@ResponseBody	
	public String thdanhao(){
		return CommentOrder.commOrder(serviee.pdaig(),"QP");
		
	}
	//填进table
	@PostMapping("/get_andinstrument_pd")
	@ResponseBody
	public void slelectqxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		serviee.slelectqxxq(instrumentId, instrumentName, shuliang, danwei, instrumentRemark);
	}
	
	
	 //查询所有
	@GetMapping("/select_ruku_pd")
	@ResponseBody
	public  List<PdxiangqingVo> selectAll(){
		return serviee.selectpdo();
	
	}
	//清除
	@GetMapping("/cle_ruku_pd")
	@ResponseBody
	public void cle(){
		serviee.cle();
	}
	
	@GetMapping("/delect_instrument_pd")
	@ResponseBody
	//删除
	public Errors delectinstrument(String qx){
		return serviee.deletextinstrument(CommentOrder.dealString(qx));
		
	}
	//处理
	@PostMapping("/chuli_andinstrument_pd")
	@ResponseBody
	public Errors instrumentpd(QxLnventory a ){
		return serviee.instrumentpd(a);
		
	}
}
