package com.ssh.controller.instrument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.QxUse;
import com.ssh.service.instrument.LingyongService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.LingyongXqVo;
import com.ssh.vo.instrument.PdxiangqingVo;

@Controller
public class LinyongController {
	@Autowired
	public LingyongService serviI;
	
	/**
	 * 
	 * 领用单号
	 */
	@RequestMapping("/lydanhao")
	@ResponseBody	
	public String lydanhao(){
		return CommentOrder.commOrder(serviI.Laig(),"LY");
		
	}
	//填进table
	@PostMapping("/get_andinstrument_ly")
	@ResponseBody
	public void sleleclyxxq(String instrumentId,String instrumentName,BigDecimal shuliang,String danwei,String instrumentRemark){
		serviI.sleleclyxxq(instrumentId, instrumentName, shuliang, danwei, instrumentRemark);
		}
	//清除
	@GetMapping("/cle_ruku_ly")
	@ResponseBody
	public void cle(){
		serviI.cle();
	}
	
	 //查询所有
	@GetMapping("/select_ruku_ly")
	@ResponseBody
	public  List<LingyongXqVo> selectAll(){
		return serviI.selectpdo();
		
		}
	//处理
	@PostMapping("/Post_andinstrument_ly")
	@ResponseBody
	public Errors instrumentpd(QxUse l ){
		return serviI.instrumentpd(l);
		
	}
	@GetMapping("/delect_instrument_ly")
	@ResponseBody
	//删除
	public Errors delectinstrument(String qx){
		return serviI.deletextinstrumently(CommentOrder.dealString(qx));
		
	}
	
	
}
