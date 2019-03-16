package com.ssh.controller.dean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.DrugHairService;
import com.ssh.vo.dean.DrugHairVo;
import com.ssh.vo.dean.DrugHairXqVo;

@Controller
public class DrugHairController {

	@Autowired
	private DrugHairService dService;
	
	/**
	 * 查询所有发药记录
	 * @return
	 */
	@GetMapping("/to_select_all_fayao")
	@ResponseBody
	public List<DrugHairVo> selectFayao(){
		return dService.selectFayao();
	}
	
	@GetMapping("/to_select_all_by_id")
	@ResponseBody
	public List<DrugHairXqVo> selectXqById(String drugYaofangId,String zhuyuanFayaoType){
		System.out.println(drugYaofangId+zhuyuanFayaoType);
		return dService.selectXqById(drugYaofangId,zhuyuanFayaoType);
	}
	
	@GetMapping("/to_select_fayao_By_Id")
	@ResponseBody
	public List<DrugHairVo> mohuFayao(String drugYaofangId){
		return dService.mohuFindFayao(drugYaofangId);
	}
	
	@GetMapping("/to_gaoji_find_all_by_idAndType")
	@ResponseBody
	public List<DrugHairVo> gaojifind(String drugYaofangId , String zhuyuanFayaoType){
		System.out.println(drugYaofangId+zhuyuanFayaoType);
		return dService.gaojifind(drugYaofangId, zhuyuanFayaoType);
	}
}
