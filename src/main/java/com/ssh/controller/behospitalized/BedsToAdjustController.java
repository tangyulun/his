package com.ssh.controller.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Bed;
import com.ssh.pojos.BedTiaozheng;
import com.ssh.service.behospitalized.BedsToAdjustService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Controller
public class BedsToAdjustController {
	@Autowired
	private BedsToAdjustService bedtoadjustservice;
	/**
	 * 获取床位调整号
	 * @return
	 */
	@GetMapping("/get_number1")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(bedtoadjustservice.getNumber(),"BJ");
	}
	/**
	 * 添加床位调整记录
	 * @param state
	 * @param bedTiaozheng
	 * @param bedId
	 * @param empId
	 * @param hospitalRegistrationId
	 * @return
	 */
	@PostMapping("/add_bedTiaozheng")
	@ResponseBody
	public Errors addBedTiaozheng(BedTiaozheng bedTiaozheng, String bedId, Long empId,String hospitalRegistrationId){
		Errors bed=  bedtoadjustservice.addBedTiaozheng(bedTiaozheng, bedId, empId, hospitalRegistrationId);
		return bed;
	}

}
