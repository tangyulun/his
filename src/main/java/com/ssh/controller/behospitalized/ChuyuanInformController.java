package com.ssh.controller.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ChuyuanInform;
import com.ssh.service.behospitalized.ChuyuanInformService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Controller
public class ChuyuanInformController {
	@Autowired
	private ChuyuanInformService chuyuaninformservice;
	/**
	 * 获取出院通知号
	 * @return
	 */
	@GetMapping("/get_number_inform")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(chuyuaninformservice.getNumber(),"CI");
	}
	/**
	 * 添加出院通知记录
	 * @param state
	 * @param chuyuanInform
	 * @param hospitalRegistrationId
	 * @param empId
	 * @return
	 */
	@PostMapping("/add_chuyuanInform")
	@ResponseBody
	public Errors addChuyuanInform(String state,ChuyuanInform chuyuanInform,String hospitalRegistrationId,Long empId){
		return chuyuaninformservice.addChuyuanInform(state, chuyuanInform, hospitalRegistrationId, empId);
		
	}
}
