package com.ssh.controller.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Financial;
import com.ssh.pojos.Instrument;
import com.ssh.service.instrument.IinstrumenttypeService;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HouseTypeVo;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.instrument.InstrumentTypeVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.instrument.ParentTypeVo;

@Controller
public class TypeController {
	
	@Autowired
	public IinstrumenttypeService see;
	//添加分类
	
	@RequestMapping("/add_instrument_types")
	@ResponseBody	
	public Errors addnew(String instrumentTypeName){
		return see.addType(instrumentTypeName);
	}

	//查询分类
	@GetMapping("/select_instrument_types")
	@ResponseBody	
	public List<ParentTypeVo> selectins(){
		return see.selectALL();
		
	}
	
	//查询分类
	@GetMapping("/select_instrument_types2")
	@ResponseBody	
	public List<InstrumentTypeVo> selectins2(){
		return see.selectALL2();
		
	}
	//查询是否存在
	@PostMapping("/regex_instrument_types")
	@ResponseBody	
	public Errors regexiTypeName(String instrumentTypeName){
		return see.regexiTypeName(instrumentTypeName);
	}
	//查询器械名是否存在
	@PostMapping("/regex_instrument_names")
	@ResponseBody	
	public Errors regexiName(String instrumentName){
		return see.regexiName(instrumentName);
	}
	
	//查询器械
	@GetMapping("/select_instruments_types")
	@ResponseBody	
	public Map<String , Object> selectallinstrument(int page, int rows){
		Map<String , Object> map= new HashMap<>();
		List<InstrumentVo> list=see.selectInstrumen(page, rows);
		map.put("total", see.count());
		map.put("rows", list);
		return map;
		
	}
	//点击ul查询
	@GetMapping("/select_instruments_typess")
	@ResponseBody	
	public Map<String , Object> selectallinstruments(int page, int rows,Long instrumentTypeId){
		Map<String , Object> map= new HashMap<>();
		List<InstrumentVo> list=see.queryInstrument(page, rows ,instrumentTypeId);
		map.put("total", see.queryInCount(instrumentTypeId));
		map.put("rows", list);
		return map;
		
	}
	//添加器械
	@PostMapping("/add_instrument")
	@ResponseBody
	public Errors addNewInstrument(long instrumentTypeId, Instrument ins , long empId , long unitId) {
		System.err.println(instrumentTypeId+""+empId);
		return see.addinstrument(ins,instrumentTypeId,empId , unitId);
	}
	
	//根据器械查询
	@GetMapping("/select_instrument_where")
	@ResponseBody
	public Map<String , Object> selecinstrumentWhere(int page , int rows ,String instrumentName){
		Map<String , Object> map = new HashMap<>();
		List<InstrumentVo> list =  see.selectinstrumentWhere(page , rows , instrumentName);
		map.put("total", see.selectinstrumentWhereCount(instrumentName));
		map.put("rows", list);
		return map;
	}
	
	//修改收费项目
		@PostMapping("/update_instrument")
		@ResponseBody
		public Errors update_instrument(Instrument instrument,String instrumentId,long instrumentTypeId,long empId ){
			return see.updateinstrument(instrument, instrumentId, instrumentTypeId, empId);
		}
	//修改分类名
		@GetMapping("/update_instrumentinstrument")
		@ResponseBody
		public Errors updatainstrumentTypeName(long instrumentTypeId,String instrumentTypeName){
			return see.updataInstrumentTypeName(instrumentTypeId, instrumentTypeName);
		}
		
		//查询分类
		@PostMapping("/get_Instrument_type")
		@ResponseBody
		public List<InstrumentTypeVo> getBedType(){
			return see.getInstrumentType();
		}
	
}