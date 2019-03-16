package com.ssh.controller.dean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.InstrumenthuizonCgService;
import com.ssh.vo.drugstorage.DrugPurchaseVo;
import com.ssh.vo.instrument.CaigoXianqingVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;

@Controller
public class InstrumenthuizonCgController {
	@Autowired
	public InstrumenthuizonCgService servicecaighuizon;
	
	//查询
		@GetMapping("/select_instrumentscaig_types_huizon")
		@ResponseBody	
		public Map<String , Object> selectallinstrumentcaighuizon(int page, int rows){
			Map<String , Object> map= new HashMap<>();
			List<InstrumentCaigouVo> list=servicecaighuizon.selectInstrumencaighuizon(page, rows);
			map.put("total", servicecaighuizon.count());
			map.put("rows", list);
			return map;
			
				
		}
		//查询
		@GetMapping("/select_instrumentscaigxq_types_huizon")
		@ResponseBody	
		public List<CaigoXianqingVo> selectByiinstrumentId(String instrumentCaigouId){
			return servicecaighuizon.selectByiinstrumentId(instrumentCaigouId);
			
		}
		//输入框查询
		@GetMapping("/select_instrumentcaigo_where_huizong")
		@ResponseBody
		public Map<String , Object> selecinstrumentWhere(int page , int rows ,String instrumentCaigouId){
			Map<String , Object> map = new HashMap<>();
			List<InstrumentCaigouVo> list =  servicecaighuizon.selectinstrumentcaigoWherehuizong(page, rows, instrumentCaigouId);
			map.put("total", servicecaighuizon.selectinstrumentcaigoWhereCounthuizong(instrumentCaigouId));
			map.put("rows", list);
			return map;
		}
		
		//高级查询
		@GetMapping("/to_gaoji_find_instrument")
		@ResponseBody
		public Map<String , Object> mohufind(int page,int rows,Date startTime,Date endTime ,
				String instrumentCaigouId,String instrumentCaigouState){
			Map<String , Object> map = new HashMap<>();
			List<InstrumentCaigouVo> list = servicecaighuizon.mohufind(page, rows, startTime, endTime, instrumentCaigouId, instrumentCaigouState);
			map.put("rows", list);
			map.put("total", servicecaighuizon.queryMohufindCount());
			return map;
		}
}
