package com.ssh.controller.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.RushShouqu;
import com.ssh.pojos.Shoushu;
import com.ssh.service.behospitalized.RushShouquService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.behospitalized.RushShouquVo;

@Controller
public class RushShouquController {
	@Autowired
	private RushShouquService shouquservice;
	/**
	 * 获取押金收取号
	 * @return
	 */
	@GetMapping("/get_number_rush_shouqu")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(shouquservice.getNumber(),"SQ");
	}
	/**
	 * 添加押金收取记录
	 * @param state
	 * @param rushShouqu
	 * @param empId
	 * @param hospitalRegistrationId
	 * @param hospitalNotifyNumber
	 * @return
	 */
	@PostMapping("/add_rushShouqu")
	@ResponseBody
	public Errors addRushShouqu(String state,RushShouqu rushShouqu,Long empId,String hospitalRegistrationId,String hospitalNotifyNumber){
		return shouquservice.addRushShouqu(state, rushShouqu, empId, hospitalRegistrationId, hospitalNotifyNumber);
	}
	/**
	 * 根据住院通知号查询住院登记号
	 * @param number
	 * @return
	 */
	@GetMapping("/select_zhiyuan_dengji")
	@ResponseBody
	public HospitalRegistrationVo selectZhiYuanDengji(String number){
		return shouquservice.selectZhiYuanDengji(number);
	}
}
