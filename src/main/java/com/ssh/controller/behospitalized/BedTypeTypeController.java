package com.ssh.controller.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.behospitalized.BedTypeTypeVoService;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedTypeTypeVo;


@Controller

public class BedTypeTypeController {
	@Autowired
	private BedTypeTypeVoService service;
	/**
	 * 获取病床分类
	 * @return
	 */
	@RequestMapping("/get_bed_type")
	@ResponseBody
	public List<BedTypeTypeVo> getBedType(){
		return service.getIBedType();
	}
	/**
	 * 添加病床的分类的分类
	 * @param bedTypeName
	 * @return
	 */
	@PostMapping("/add_bed_type_type")
	@ResponseBody
	public Errors addNewEmp(String bedTypeName) {
		return service.addBedTypeType(bedTypeName);
	}
	
}
