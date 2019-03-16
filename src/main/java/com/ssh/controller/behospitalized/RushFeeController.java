package com.ssh.controller.behospitalized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.RushFee;
import com.ssh.service.behospitalized.RushFeeService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.RushFeeVo;

@Controller
public class RushFeeController {
	@Autowired
	private RushFeeService rushfeeservice;
	/**
	 * 获取押金催费号
	 * @return
	 */
	@GetMapping("/get_number_rush")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(rushfeeservice.getNumber(),"CF");
	}
	/**
	 * 添加押金催费记录
	 * @param state
	 * @param rushFee
	 * @param hospitalRegistrationId
	 * @return
	 */
	@PostMapping("/add_rushFee")
	@ResponseBody
	public Errors addRushFee(String state,RushFee rushFee,String hospitalRegistrationId){
		return rushfeeservice.addRushFee(state, rushFee, hospitalRegistrationId);
	}
	/**
	 * 查询押金催费记录
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_RushFee")
	@ResponseBody
	public Map<String , Object> selectAllRushFee(int page, int rows){
		Map<String , Object> map = new HashMap<>();
		List<RushFeeVo> list = rushfeeservice.selectAllRushFee(page, rows);
		map.put("total", rushfeeservice.count());
		map.put("rows", list);
		return map;
	}
}
