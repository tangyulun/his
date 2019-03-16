package com.ssh.controller.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.YajinTuifei;
import com.ssh.service.behospitalized.YajinTuifeiServiec;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.ZhuyuanJiezhangVo;

@Controller
public class YajinTuifeiController {
	@Autowired
	private YajinTuifeiServiec yajin;
	
	@GetMapping("/get_yajintuifei_number")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(yajin.getNumber(),"TF");
	}
	/**
	 * 查询已结金额
	 * @param number
	 * @return
	 */
	@GetMapping("/select_yijie_money")
	@ResponseBody
	public List<ZhuyuanJiezhangVo> selectZhuyuanJiezhang(String number){
		return yajin.selectZhuyuanJiezhang(number);
	}
	@PostMapping("/add_yajinTuifei")
	@ResponseBody
	public Errors addYajinTuifei(String state,YajinTuifei yajinTuifei,Long empId,String chuyuanInformId){
		return yajin.addYajinTuifei(state, yajinTuifei, empId, chuyuanInformId);
	}
}
