package com.ssh.controller.instrument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.QxReturn;
import com.ssh.service.instrument.HuanhuiService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.HhuixiangqingVo;

@Controller
public class HuanhuiContrroller {
	@Autowired
	public HuanhuiService serv;
	
	/**
	 * 
	 * 还回单号
	 */
	@RequestMapping("/hhdanhao")
	@ResponseBody	
	public String thdanhao(){
		return CommentOrder.commOrder(serv.haig(),"HH");
		
	}
	//填进table
	@PostMapping("/get_andinstrument_hh")
	@ResponseBody
	public void sleleclyxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		serv.sleleclyxxq(instrumentId, instrumentName, shuliang, danwei, instrumentRemark);
	}
	//查询所有
	@GetMapping("/select_hh_hh")
	@ResponseBody
	public List<HhuixiangqingVo> selecthh(){
		return serv.selecthh();
		
	}
	//清除
	@GetMapping("/cel_hh_hh")
	@ResponseBody
	public void qingc(){
		serv.qingc();
	}
	//还回处理
	@PostMapping("/post_andinstrument_hh")
	@ResponseBody
	public Errors instrumentpd(QxReturn i ){
		return serv.instrumentpd(i);
		
	}
	
	@GetMapping("/delect_instrument_hh")
	@ResponseBody
	public Errors deletextinstrument(String qx){
		return serv.deletextinstrument(CommentOrder.dealString(qx));
		
	}
	
}
