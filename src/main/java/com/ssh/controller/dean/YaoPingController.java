package com.ssh.controller.dean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.service.dean.YaoPinService;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.DrugVo;

@Controller
public class YaoPingController {
	
	@Autowired
	private YaoPinService ySer;
	
	@GetMapping("/select_all_drug_dean")
	@ResponseBody
	public Map<String , Object> selectAllDurg(int page , int rows){
		Map<String ,Object> map = new HashMap<>();
		map.put("rows", ySer.findAllDrug(page, rows));
		map.put("total", ySer.count());
		return map;
	}
	
	@PostMapping("/select_all_drug_type_dean")
	@ResponseBody
	public List<DrugTypeVo> selectAllDrugTypeDean(){
		return ySer.selectDrugTypeName();
	}
	
	@GetMapping("/select_all_drug_dean_where")
	@ResponseBody
	public Map<String , Object> selectAllDurg(int page , int rows , String key){
		Map<String ,Object> map = new HashMap<>();
		map.put("rows", ySer.findAllDrugWhere(page, rows , key));
		map.put("total", ySer.countWhere(key));
		return map;
	}
	
	@GetMapping("/select_all_drug_dean_grade_where")
	@ResponseBody
	public Map<String , Object> selectAllDrugDeanGradeWhere(int page , int rows , String key ,
			String type , String ku , String fang){
		Map<String ,Object> map = new HashMap<>();
		map.put("rows", ySer.selectAllDrugDeanGradeWhere(page, rows , key , type , ku ,fang));
		map.put("total", ySer.countGradeWhere(key, type , ku ,fang));
		return map;
	}
}
