package com.ssh.controller.instrument;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.InstrumentRk;
import com.ssh.service.instrument.ThelibrayService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.RKinstrumentVo;
import com.ssh.vo.instrument.ThelibraryVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
import com.ssh.vo.instrument.ZyanshoxqVo;



@Controller
public class ThelibraryController { 
	@Autowired
	public ThelibrayService servicee;
	@RequestMapping("/b")
	@ResponseBody
	public List<ThelibraryVo> ojbk(){
		return servicee.selectALL();
	}
	/**
	 * 
	 * 入库单号
	 */
	@RequestMapping("/rkdanhao")
	@ResponseBody	
	public String danhao(){
		return CommentOrder.commOrder(servicee.ruku(),"QR");
		
	}
	
	//到table
	@GetMapping("/ruku_dao_table")
	@ResponseBody	
	public List<RKinstrumentVo> slelectqxxq(String instrumentYsId){
		return servicee.sleleqxrk(instrumentYsId);
		
	}
	//入库处理
	@PostMapping("/instrument_ruku_chuli")
	@ResponseBody
	public Errors instrumentRK(InstrumentRk a,String instrumentYsId,Long EmpId){
		return servicee.instrumentRK(a, instrumentYsId, EmpId);
		
	}
	
	//清楚
	@GetMapping("/cleare_ruku_xq")
	@ResponseBody
	public void clear(){
		servicee.clear();
	}

}
