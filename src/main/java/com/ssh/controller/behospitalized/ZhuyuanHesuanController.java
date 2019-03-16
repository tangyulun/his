package com.ssh.controller.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.ZhuyuanHesuan;
import com.ssh.service.behospitalized.ZhuyuanHesuanService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.ChufangVo;
import com.ssh.vo.behospitalized.FeiYongHeSuanVo;

@Controller
public class ZhuyuanHesuanController {
	@Autowired
	private ZhuyuanHesuanService zhuyuanhesuanservice;
	/**
	 * 获取住院费用核算号
	 * @return
	 */
	@GetMapping("/get_number_hesuan")
	@ResponseBody
	public String getNumber(){
		return CommentOrder.commOrder(zhuyuanhesuanservice.getNumber(),"HS");
	}
	/**
	 * 添加住院费用核算记录
	 * @param zhuyuanHesuan
	 * @param hospitalRegistrationId
	 * @return
	 */
	@PostMapping("/add_zhuyuanHesuan")
	@ResponseBody
	public Errors addZhuyuanHesuan(ZhuyuanHesuan zhuyuanHesuan,String hospitalRegistrationId){
		return zhuyuanhesuanservice.addZhuyuanHesuan(zhuyuanHesuan, hospitalRegistrationId);
	}
	
	/**
	 * 查询费用核算
	 * @param hospitalRegistrationId
	 * @return
	 */
	@GetMapping("/select_all_feiyonghesuan")
	@ResponseBody
	public List<FeiYongHeSuanVo> selectAll(String hospitalRegistrationId){
		return zhuyuanhesuanservice.selectAll(hospitalRegistrationId);
				
	}
	/**
	 * 查询医疗
	 * @param hospitalRegistrationId
	 * @return
	 */
	@GetMapping("/select_all_yiliao")
	@ResponseBody
	public List<FeiYongHeSuanVo> selectAllyiliao(String hospitalRegistrationId){
		return zhuyuanhesuanservice.selectAllyiliao(hospitalRegistrationId);
				
	}
	/**
	 * 查询药品
	 * @param hospitalRegistrationId
	 * @return
	 */
	@GetMapping("/select_all_yaoping")
	@ResponseBody
	public List<FeiYongHeSuanVo> selectAllyaoping(String hospitalRegistrationId){
		return zhuyuanhesuanservice.selectAllyaoping(hospitalRegistrationId);
				
	}
	/**
	 * 查询处方
	 * @param hospitalRegistrationId
	 * @return
	 */
	@GetMapping("/select_all_chufang")
	@ResponseBody
	public List<ChufangVo> selectAllChufang(String hospitalRegistrationId){
		return zhuyuanhesuanservice.selectAllChufang(hospitalRegistrationId);
	}


}
