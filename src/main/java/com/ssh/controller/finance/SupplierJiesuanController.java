package com.ssh.controller.finance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.SupplierJiesuan;
import com.ssh.service.finance.SupplierJiesuanService;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.finance.JieZhangMingXiVo;
import com.ssh.vo.finance.SettleWayVo;

@Controller
public class SupplierJiesuanController {
	
	@Autowired
	private SupplierJiesuanService SJService;
	
	/**
	 * 查询所有支付方式
	 * @return
	 */
	@GetMapping("/to_select_sw_fs")
	@ResponseBody
	public List<SettleWayVo> selectSW(){
		return SJService.selectSW();
	}
	
	/**
	 * 根据凭证单号查询
	 * @param drugAcceptancePzdh
	 * @return
	 */
	@PostMapping("/to_select_xq_Bypzdh")
	@ResponseBody
	public List<AcceptanceVo> select(String drugAcceptancePzdh){
		return SJService.select(drugAcceptancePzdh);
	}
	
	/**
	 * 结账处理
	 * @param sj
	 * @param empId
	 * @param settleWayId
	 * @return
	 */
	@PostMapping("/to_insert_jiezhang_chuli")
	@ResponseBody
	public Errors insertChuli(SupplierJiesuan sj,Long empId,String settleWayId,String drugAcceptancePzdh){
		return SJService.insertChuli(sj, empId, settleWayId,drugAcceptancePzdh);
	}
	
	@PostMapping("/to_select_jiezhang_all")
	@ResponseBody
	public List<JieZhangMingXiVo> selectAll(){
		return SJService.selectAll();
	}
	
	@GetMapping("/to_clear_jiezhang_all")
	@ResponseBody
	public void clear(){
		SJService.clear();
	}
}
