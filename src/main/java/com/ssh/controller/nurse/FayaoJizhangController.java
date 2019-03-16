package com.ssh.controller.nurse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.FayaoJizhang;
import com.ssh.service.nurse.FayaoJizhangService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.nurse.ZhuyuanFayaoXqVo;

@Controller
public class FayaoJizhangController {
	@Autowired
	private FayaoJizhangService fayaojizhangservice;
	/**
	 * 获取住院发药记账号
	 * @return
	 */
	@GetMapping("/get_fayao_number")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(fayaojizhangservice.getNumber(),"FY");
	}
	/**
	 * 添加住院发药记账
	 * @param state
	 * @param fayaoJizhang
	 * @param empId
	 * @param hospitalRegistrationId
	 * @return
	 */
	@PostMapping("/add_FayaoJizhang")
	@ResponseBody
	public Errors addFayaoJizhang(String state,FayaoJizhang fayaoJizhang,Long empId,String hospitalRegistrationId){
		return fayaojizhangservice.addFayaoJizhang(state, fayaoJizhang, empId, hospitalRegistrationId);
	}
	/**
	 * 获取住院发药详情ID
	 * @return
	 */
	@GetMapping("/get_zhuyuanfayao_xqnumber")
	@ResponseBody
	public long getxqNumber(){
		return fayaojizhangservice.getxqNumber();
	}
	/**
	 * 添加发药记录
	 * @param drugId
	 * @param drugBname
	 * @param number
	 * @param money
	 * @param state
	 * @param pingzhengdaohao
	 */
	@PostMapping("add_ZhuyuanFayaoXq")
	@ResponseBody
	public void addZhuyuanFayaoXq(String drugId,String drugBname,BigDecimal number,BigDecimal jilian, BigDecimal money,String state,String pingzhengdaohao, Date shoufeiDate, String shoufeiTime){
		fayaojizhangservice.addZhuyuanFayaoXq(drugId, drugBname, number,jilian, money, state, pingzhengdaohao,shoufeiDate,shoufeiTime);
		
	}
	/**
	 * 查询发药记录
	 * @return
	 */
	@GetMapping("/select_all_zhuyuanyaoping")
	@ResponseBody
	public List<ZhuyuanFayaoXqVo> selectAll(){
		return fayaojizhangservice.selectAll();
	}
	/**
	 * 清除发药记录
	 */
	@GetMapping("/clear_all_zhuyuanyaoping")
	@ResponseBody
	public void clear(){
		fayaojizhangservice.clear();
	}
	/**
	 * 删除发药记录
	 * @param id
	 * @return
	 */
	@GetMapping("/delete_all_zhuyuanyaoping")
	@ResponseBody
	public Errors delete(String id){
		return fayaojizhangservice.delete(CommentOrder.dealString(id));
	}
	@GetMapping("/select_all_prescription")
	@ResponseBody
	public List<PrescriptionVo> selectAllPrescription(){
		return fayaojizhangservice.selectAllPrescription();
	}
}
