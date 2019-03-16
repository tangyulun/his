package com.ssh.controller.instrument;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.instrument.ChukuService;

@Controller
public class Instrumentcontroller {
	@Autowired
	private ChukuService ser;
	
	@GetMapping("/qixiebh_id")
	@ResponseBody
	public String qixieId(){
		return ser.maxid();
	}
}
