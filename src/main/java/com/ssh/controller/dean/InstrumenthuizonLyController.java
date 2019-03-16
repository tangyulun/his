package com.ssh.controller.dean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.InstrumenthuizonLyService;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.LingyongHuizonXqVo;
import com.ssh.vo.instrument.LingyongVo;
import com.ssh.vo.instrument.LingyongXqVo;

@Controller
public class InstrumenthuizonLyController {
	@Autowired
	public InstrumenthuizonLyService instrumentlyseveral;
	
	

	//查询
	@GetMapping("/select_instrumentsly_types_huizon")
	@ResponseBody	
	public Map<String , Object> selectallinstrumentcaighuizon(int page, int rows){
		Map<String , Object> map= new HashMap<>();
		List<LingyongVo> list=instrumentlyseveral.selectInstrumenlyhuizon(page, rows);
			map.put("total", instrumentlyseveral.count());
			map.put("rows", list);
			return map;
				
					
			}
	//详情
	@GetMapping("/select_instrumentslyxq_types_huizon")
	@ResponseBody	
	public List<LingyongHuizonXqVo> selectByiinstrumentId(String qxUseId){
		return instrumentlyseveral.selectByiinstrumentId(qxUseId);
		
	}
	
	//输入框查询
	@GetMapping("/select_instrumently_where_huizong")
	@ResponseBody
	public Map<String , Object> selecinstrumentWhere(int page , int rows ,String qxUseId){
		Map<String , Object> map = new HashMap<>();
		List<LingyongVo> list =  instrumentlyseveral.selectinstrumentcaigoWherehuizong(page, rows, qxUseId);
		map.put("total", instrumentlyseveral.selectinstrumentlyWhereCounthuizong(qxUseId));
		map.put("rows", list);
		return map;
	}
	
	//高级查询
			@GetMapping("/to_gaoji_find_instrument_ly")
			@ResponseBody
			public Map<String , Object> mohufindly(int page,int rows,Date startTime,Date endTime ,
					String qxUseId,String qxUseState){
				Map<String , Object> map = new HashMap<>();
				List<LingyongVo> list = instrumentlyseveral.mohufind(page, rows, startTime, endTime, qxUseId, qxUseState);
				map.put("rows", list);
				map.put("total", instrumentlyseveral.queryMohufindCountly());
				return map;
			}
	
}
