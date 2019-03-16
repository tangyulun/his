package com.ssh.controller.dean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.HospitalZongService;
import com.ssh.vo.dean.HospitalZongTongJiVO;
import com.ssh.vo.dean.ShouFeiOrDrugVO;
import com.ssh.vo.dean.ZheXianTuVO;

@Controller
public class HospitalZongController {
	
	@Autowired
	private HospitalZongService hSer;
	
	@GetMapping("/select_all_menzhen_zong")
	@ResponseBody
	public List<ShouFeiOrDrugVO> selectAllMenzhenZong(){
		return hSer.selectAllMen();
	}
	
	
	@GetMapping("/select_all_zhuyuan_zong")
	@ResponseBody
	public List<ShouFeiOrDrugVO> selectAllZhuyuanZong(){
		return hSer.selectAllZhu();
	}
	
	@GetMapping("/select_all_menzhen_drug_zong")
	@ResponseBody
	public List<ShouFeiOrDrugVO> selectAllMenzhenDrugZong(){
		return hSer.selectMenDrug();
	}
	
	@GetMapping("/select_all_zhuyuan_drug_zong")
	@ResponseBody
	public List<ShouFeiOrDrugVO> selectAllZhuyuanDrugZong(){
		return hSer.selectZhuDrug();
	}
	
	@GetMapping("/select_zong_tong_ji_sxt")
	@ResponseBody
	public List<HospitalZongTongJiVO> selectAllShanXingTu(){
		return	hSer.selectAllShanXingTu();
	}
	
	@GetMapping("/select_zhe_xian_tu")
	@ResponseBody
	public List<ZheXianTuVO> selectZheXainTU(){
		return hSer.selectZheXian();
	}
	
	@GetMapping("/select_zhe_xian_tu_where")
	@ResponseBody
	public List<ZheXianTuVO> selectZheXainTUWhere(int index){
		return hSer.selectZheXianWhere(index);
	}
	

	@GetMapping("/select_zhu_xing_tu_all")
	@ResponseBody
	public List<ZheXianTuVO> selectZhuXingTuAll(){
		return hSer.selectZhuXiang2();
	}
	
	@GetMapping("/ji_suan_zong_cheng_ben")
	@ResponseBody
	public double jisuanZongCHengBen(){
		return hSer.jisuanZongChengBen();
	}
}
