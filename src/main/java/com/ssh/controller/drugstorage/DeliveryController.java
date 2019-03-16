package com.ssh.controller.drugstorage;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.DrugDelivery;
import com.ssh.service.drugstorage.DeliveryService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.drugstorage.BuydingdanVo;
import com.ssh.vo.drugstorage.RukuXqVo;

@Controller
public class DeliveryController {
	@Autowired
	private DeliveryService DService;
	
	@GetMapping("to_delivery")
	@ResponseBody
	public String DNumber(){
		return CommentOrder.commOrder(DService.DNumber(), "CK");
	}
	
	/**
	 * 点击加入将值传到table中
	 * @param ypid
	 * @param ypname
	 * @param num
	 * @param ph
	 * @param bz
	 * @param dw
	 */
	@PostMapping("/to_add_ruku_xq_a")
	@ResponseBody
	public void addrukuxq(String drugId,String drugName,BigDecimal num,String ph,String bz){
		DService.addrukuxq(drugId, drugName, num, ph, bz);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@GetMapping("/select_ruku_xq_a")
	@ResponseBody
	public List<RukuXqVo> selectCaiGouXDAll(){
		return DService.selectAll();
	}
	
	/**
	 * 清除
	 */
	@GetMapping("/clear_ruku_xq_a")
	@ResponseBody
	public void clear(){
		DService.clear();
	}
	
	/**
	 * 删除
	 * @param xq
	 * @return
	 */
	@GetMapping("/delete_ruku_xq_a")
	@ResponseBody
	public Errors delete(String xq){
		return DService.deletexd(CommentOrder.dealString(xq));
	}
	
	/**
	 * 新增处理
	 * @param dd
	 * @param empId
	 * @param state
	 * @return
	 */
	@PostMapping("/to_insert_chuli_xq")
	@ResponseBody
	public Errors insertchuli(DrugDelivery dd,Long empId){
		return DService.insertchuli(dd, empId);
	}
	
	/**
	 * 修改table中的数据
	 * @param rk
	 * @param id
	 */
	@PostMapping("/update_chuku_xq")
	@ResponseBody
	public void updatechuku(RukuXqVo rk , int id,BigDecimal num , BigDecimal numC){
		DService.updatechuku(rk, id,num,numC);
	}
	
	@GetMapping("/update_kucun_num_")
	@ResponseBody
	public void updateKucunNum(Long kucunId , BigDecimal num){
		DService.updateKuCunNum(kucunId, num);
	}
}
