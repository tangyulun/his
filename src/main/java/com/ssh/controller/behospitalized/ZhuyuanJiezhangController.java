package com.ssh.controller.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ZhuyuanJiezhang;
import com.ssh.service.behospitalized.ZhuyuanJiezhangService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.RushShouquVo;

@Controller
public class ZhuyuanJiezhangController {
	@Autowired
	private ZhuyuanJiezhangService zhuyuanjiezhangservice;
	/**
	 * 获取住院费用结账号
	 * @return
	 */
	@GetMapping("/get_number_jiezhang")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(zhuyuanjiezhangservice.getNumber(),"JZ");
	}
	/**
	 * 添加住院费用结账记录
	 * @param zhuyuanJiezhang
	 * @param hospitalRegistrationId
	 * @return
	 */
	@PostMapping("/add_zhuyuanjiezhang")
	@ResponseBody
	public Errors addZhuyuanJiezhang(ZhuyuanJiezhang zhuyuanJiezhang, String hospitalRegistrationId){
		return zhuyuanjiezhangservice.addZhuyuanJiezhang(zhuyuanJiezhang, hospitalRegistrationId);
	}
	/**
	 * 根据住院号来查询rushShouquYushouMoney
	 * @param number
	 * @return
	 */
	@GetMapping("/select_shouqu_money")
	@ResponseBody
	public List<RushShouquVo> selectrushShouquYushouMoney(String number){
		return zhuyuanjiezhangservice.selectrushShouquYushouMoney(number);
	}
}
