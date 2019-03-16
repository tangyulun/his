package com.ssh.controller.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.behospitalized.BedTypeService;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedTypeTypeVo;

@Controller
public class BedTypeController {
	@Autowired
	private BedTypeService bedtypeservice;
	/**
	 * 添加病床分类
	 * @param bedTypeName
	 * @return
	 */
	@PostMapping("/add_bed_type")
	@ResponseBody
	public Errors addNewEmp(String bedTypeName,Long bedTypeTypeId) {
		return bedtypeservice.addBedType(bedTypeName,bedTypeTypeId);
	}
	/**
	 * 查询所有病床分类
	 * @return
	 */
	@GetMapping("/select_all_bed_type")
	@ResponseBody
	public List<BedTypeTypeVo> selectAllBedType(){
		return bedtypeservice.selectAllType();
	}
	/**
	 * 验证病床分类编号是否重名
	 * @param BedTypeName
	 * @return
	 */
	@PostMapping("/regex_bed_type_name")
	@ResponseBody
	public Errors regexBedTypeName(String BedTypeName){
		return bedtypeservice.regexBedTypeName(BedTypeName);
	}
	
}
