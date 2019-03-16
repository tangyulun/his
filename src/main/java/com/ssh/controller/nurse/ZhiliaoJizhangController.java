package com.ssh.controller.nurse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ZhiliaoJizhang;
import com.ssh.service.nurse.ZhiliaoJizhangService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.nurse.ZhuyuanZhiliaojizhangVo;

@Controller
public class ZhiliaoJizhangController {
	@Autowired
	private ZhiliaoJizhangService zhiliaojizhangservice;
	
	@GetMapping("/get_zhiliao_number")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(zhiliaojizhangservice.getNumber(),"ZL");
	}
	@PostMapping("/add_ZhiliaoJizhang")
	@ResponseBody
	public Errors addZhiliaoJizhang(String state,ZhiliaoJizhang zhiliaoJizhang ,Long empId,String hospitalRegistrationId){
		return zhiliaojizhangservice.addZhiliaoJizhang(state, zhiliaoJizhang, empId, hospitalRegistrationId);
	}
	@PostMapping("/add_ZhuyuanZhiliaojizhang")
	@ResponseBody
	public void addZhuyuanZhiliaojizhang(String financialId,String financialName,BigDecimal number,BigDecimal money,String state,String chufanhao,String shoufeileixing){
		zhiliaojizhangservice.addZhuyuanZhiliaojizhang(financialId, financialName, number, money, state, chufanhao,shoufeileixing);
	}
	@GetMapping("/select_ZhuyuanZhiliaojizhang")
	@ResponseBody
	public List<ZhuyuanZhiliaojizhangVo> selectAll(){
		return zhiliaojizhangservice.selectAll();
				
	}
	@GetMapping("/clear_all_ZhuyuanZhiliaojizhang")
	@ResponseBody
	public void clear(){
		zhiliaojizhangservice.clear();
	}
	@GetMapping("/delete_all_ZhuyuanZhiliaojizhang")
	@ResponseBody
	public Errors delete(String id){
		return zhiliaojizhangservice.delete(CommentOrder.dealString(id));
	}
}
