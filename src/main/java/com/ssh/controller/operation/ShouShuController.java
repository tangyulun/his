package com.ssh.controller.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.operation.ShoushuService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.operation.ShouShuTypeVo;
import com.ssh.vo.operation.ShouShuVo;
import com.ssh.vo.operation.SurgeryTypeVo;

@Controller
public class ShouShuController {
		@Autowired
		private ShoushuService ssservice;
		
		/**
		 * 根据日期模糊查询编号方法
		 * @return
		 */
		@GetMapping("/ss_number")
		@ResponseBody
		public String RNumber(){
			return CommentOrder.commOrder(ssservice.RNumber(),"SS");
		}
}
