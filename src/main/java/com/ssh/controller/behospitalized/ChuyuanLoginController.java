package com.ssh.controller.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ChuyuanLogin;
import com.ssh.service.behospitalized.ChuyuanLoginService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.ChuyuanInformVo;

@Controller
public class ChuyuanLoginController {
	@Autowired
	private ChuyuanLoginService chuyuanloginservice;
	/**
	 * 获取出院登记号
	 * @return
	 */
	@GetMapping("/get_number_chuyuan")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(chuyuanloginservice.getNumber(),"CD");
	}
	/**
	 * 查询出院通知
	 * @param number
	 * @return
	 */
	@GetMapping("/select_chuyuan_tongzhi")
	@ResponseBody
	public ChuyuanInformVo selectZhiYuanDengji(String number){
		return chuyuanloginservice.selectChuYuanTongzhi(number);
	}
	/**
	 * 添加出院登记记录
	 * @param state
	 * @param chuyuanLogin
	 * @param chuyuanInformId
	 * @return
	 */
	@PostMapping("/add_chuyuanLongin")
	@ResponseBody
	public Errors addChuyuanLogin(String state , ChuyuanLogin chuyuanLogin,String chuyuanInformId){
		return chuyuanloginservice.addChuyuanLogin(state, chuyuanLogin, chuyuanInformId);
	}
}
