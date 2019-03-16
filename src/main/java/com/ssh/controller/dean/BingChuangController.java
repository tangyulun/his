package com.ssh.controller.dean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.BingChuangService;

@Controller
public class BingChuangController {

		@Autowired
		private BingChuangService bSer;
		
		@GetMapping("/select_all_beds")
		@ResponseBody
		public Map<String , Object> selectAllBeds(int page , int rows){
			Map<String ,Object> map = new HashMap<>();
			map.put("total", bSer.count());
			map.put("rows", bSer.selectAllBeds(page, rows));
			return map;
		}
		
		@GetMapping("/select_all_beds_where")
		@ResponseBody
		public Map<String , Object> selectAllBedsWhere(int page , int rows , String key){
			Map<String ,Object> map = new HashMap<>();
			map.put("rows", bSer.selectAllBedsWhere(page, rows , key));
			map.put("total", bSer.countWhere(key));
			return map;
		}
		
		@GetMapping("/select_all_beds_where_grade")
		@ResponseBody
		public Map<String , Object> selectAllBedsWhereGrade(int page , int rows , String key , String state , String sex){
			Map<String ,Object> map = new HashMap<>();
			map.put("rows", bSer.selectAllBedsWhereGrade(page, rows , key , state , sex));
			map.put("total", bSer.countWhereGrade(key , state , sex));
			return map;
		}
}
