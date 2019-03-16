package com.ssh.controller.dclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Dclass;
import com.ssh.service.dclass.DClassService;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;

@Controller
public class DClassController {

	@Autowired
	private DClassService dSer;
	/**
	 * 添加科室
	 * @param dclass
	 * @return
	 */
	@PostMapping("/insert_dclass")
	@ResponseBody
	public Errors insertDClass(Dclass d , long deptId){
		return dSer.insertDClass(d, deptId);
	}
	
	/**
	 * 查询所有科室
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_dclass")
	@ResponseBody
	public Map<String , Object> selectAllDClass(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<DClassVO> list = dSer.selectAllDept(page , rows);
		map.put("total", dSer.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询角色名是否存在
	 * @param dClassName
	 * @return
	 */
	@PostMapping("/regex_dclass_name")
	@ResponseBody
	public Errors regexDClassName(String dClassName){
		return dSer.regexDClassName(dClassName);
	}
	
	/**
	 * 科室名查询
	 * @param page
	 * @param rows
	 * @param dclassName
	 * @return
	 */
	@GetMapping("/select_dclass_where_dclassName")
	@ResponseBody
	public Map<String , Object> selectDclassWhereDclassName(int page , int rows , String dclassName){
		Map<String , Object> map = new HashMap<>();
		List<DClassVO> list = dSer.selectDclassWhereDclassName(page , rows , dclassName);
		map.put("total", dSer.whereDClassNameCount(page , rows , dclassName));
		map.put("rows", list);
		return map;
	}
	
	@GetMapping("/select_dclass_where_fuzeName")
	@ResponseBody
	public Map<String , Object> selectDclassWhereFuzeName(int page , int rows , String fuzeName){
		Map<String , Object> map = new HashMap<>();
		List<DClassVO> list = dSer.selectDclassWhereFuzeName(page , rows , fuzeName);
		map.put("total", dSer.whereFuzeNameCount(page , rows , fuzeName));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 条件查询科室
	 */
	@GetMapping("/where_select_dclass")
	@ResponseBody
	public List<DClassVO> whereSelectDClass(long deptId){
		return dSer.whereSelectDClass(deptId);
	}
	
	/**
	 * 条件查询科室
	 */
	@GetMapping("/where_select_dclass_zj")
	@ResponseBody
	public List<DClassVO> whereSelectDClassZj(long deptId){
		List<DClassVO> list =  dSer.whereSelectDClass(deptId);
		List<DClassVO> listT = new ArrayList<>();
		listT.add(new DClassVO(0, "全部"));
		for (DClassVO d : list) {
			listT.add(new DClassVO(d.getDclassId(), d.getDclassName()));
		}
		return listT;
	}
	
	
	
	/**
	 * 条件查询部门
	 */
	@GetMapping("/where_select_dept")
	@ResponseBody
	public DeptVO whereSelectDept(long dclassId){
		return dSer.whereSelectDept(dclassId);
	}
	
	
	/**
	 * 高级查询
	 */
	@GetMapping("/select_dclass_grade_where")
	@ResponseBody
	public Map<String , Object> selectDClassGradeWhere(String dclassName 
			,String dclassFuzeName , String dclassDept , int page , int rows ,
			String dclassState, String dclassGrade){
		Map<String , Object> map = new HashMap<>();
		map.put("rows", dSer.selectDClassGradeWhere(dclassName , dclassFuzeName , dclassDept 
				,dclassState,dclassGrade , page , rows));
		map.put("total", dSer.selectCountGrade());
		
		return map;
	}
}
