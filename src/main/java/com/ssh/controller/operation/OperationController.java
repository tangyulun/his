package com.ssh.controller.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.operation.OperationService;
import com.ssh.service.operation.ShoushuService;
import com.ssh.utils.CommentOrder;

@Controller
public class OperationController {
	@Autowired
	private OperationService tjervice;
	
	
	@GetMapping("to_operation")
	public String tologin(){
		return "/to_operation";
		
	}
	@GetMapping("surgery_operation")
	public String surgerylogin(){
		return "/surgery_operation";
		
	}
}