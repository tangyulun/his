package com.ssh.controller.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.operation.KeshiClassService;
import com.ssh.service.operation.SugeryService;
import com.ssh.utils.Errors;

@Controller
public class KeshiClassController {
	@Autowired
	private KeshiClassService keshiclassservice;
	
	
	/**
	 * 添加分类
	 * @param jianyanTypeName
	 * @return
	 */
	@PostMapping("/regex_keshiclass_name")
	@ResponseBody
	public Errors regexKeshiclassName(String jianyanTypeName){
		return keshiclassservice.regexKeshiclassName(jianyanTypeName);
	}
	
}
