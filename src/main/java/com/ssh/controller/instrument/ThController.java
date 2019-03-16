package com.ssh.controller.instrument;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.QxReturngoo;
import com.ssh.service.instrument.ThSevrice;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo;
import com.ssh.vo.instrument.ThxiangqingVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;
@Controller
public class ThController {
	@Autowired
	public ThSevrice servi;
	
	/**
	 * 
	 * 退货单号
	 */
	@RequestMapping("/thdanhao")
	@ResponseBody	
	public String thdanhao(){
		return CommentOrder.commOrder(servi.taig(),"QT");
		
	}
	
	//下方table显示
	@GetMapping("/th_dao_table")
	@ResponseBody	
	public List<InstrumentYanshoxiangqiangVo> selectyanshoo(String qxReturngoosId){
		return servi.selecttuihuo(qxReturngoosId);
		
	}
	//处理
	@PostMapping("/to_instrument_tuihuo_chuli")
	@ResponseBody
	public Errors instrumentTuihuoChuli(QxReturngoo dt,String supplierId,String instrumentYsId){
		return servi.instrumentTuihuoChuli(dt, supplierId, instrumentYsId);
	}
	//清除
	@GetMapping("/clear_instrument_th")
	@ResponseBody
	public void qingc(){
		servi.qingc();
	}
}
