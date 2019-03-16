package com.ssh.controller.dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Dept;
import com.ssh.service.dept.DeptService;
import com.ssh.utils.Errors;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.staff.EmpVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService dSer;
	
	@GetMapping("/select_all_dept_to_dclass")
	@ResponseBody
	public List<DeptVO> selectAllDeptToDClass(){
		return dSer.selectAllDeptToDClass();
	}
	@GetMapping("/select_all_dept_to_dclass_select")
	@ResponseBody
	public List<DeptVO> selectAllDeptToDClassSelect(){
		 List<DeptVO> list =  dSer.selectAllDeptToDClass();
		 List<DeptVO> listT = new ArrayList<>();
		 listT.add(new DeptVO(0, "全部"));
		 for (DeptVO d : list) {
			 listT.add(new DeptVO(d.getDeptId(), d.getDeptName()));
		}
		 return listT;
	}
	/**
	 * 查询所有部门
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_dept")
	@ResponseBody
	public Map<String, Object> findByAllDept(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		List<DeptVO> list = dSer.findByAllDept(page, rows);
		map.put("total", dSer.count());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	@PostMapping("/insert_new_dept")
	@ResponseBody
	public Errors insertNewDept(Dept dept){
		return dSer.insertNewDept(dept);
	}
	
	/**
	 * 查询所有员工
	 */
	@GetMapping("/select_emp_to_dept")
	@ResponseBody
	public List<EmpVO> selectEmpToDept(){
		return dSer.selectEmpToDept();
	}
	
	/**
	 * 验证部门名
	 * @param deptName
	 * @return
	 */
	@PostMapping("/regex_dept_name")
	@ResponseBody
	public Errors regexDeptName(String deptName){
		return dSer.regexDeptName(deptName);
	}
	
	/**
	 * 根据部门名查询
	 * @param page
	 * @param rows
	 * @param deptName
	 * @return
	 */
	@GetMapping("/select_dept_where")
	@ResponseBody
	public Map<String , Object> selectDeptWhere(int page , int rows ,String deptName){
		Map<String , Object> map = new HashMap<>();
		List<DeptVO> list =  dSer.selectDeptWhere(page , rows , deptName);
		map.put("total", dSer.selectDeptWhereCount(deptName));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 根据负责人查询
	 * @param page
	 * @param rows
	 * @param deptFuzeName
	 * @return
	 */
	@GetMapping("/select_deptFuzeName_where")
	@ResponseBody
	public Map<String , Object> selectDeptFuzeNameWhere(int page , int rows , String deptFuzeName){
		Map<String , Object> map = new HashMap<>();
		List<DeptVO> list = dSer.selectDeptFuzeWhere(page , rows , deptFuzeName);
		map.put("total", dSer.selectDeptFuzeWhereCount(deptFuzeName));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 高级查询
	 * @param page
	 * @param rows
	 * @param deptName
	 * @param deptFuzeName
	 * @param state
	 * @param grade
	 * @return
	 */
	@GetMapping("/select_grade_where")
	@ResponseBody
	public Map<String , Object> selectGradeWhere(int page , int rows , String deptName ,
			String deptFuzeName , String state , String grade){
		Map<String , Object> map = new HashMap<>();
		List<DeptVO> list = dSer.selectGradeWhere(page , rows , deptName  , deptFuzeName , state , grade);
		map.put("total", dSer.selectGradeWhereCount());
		map.put("rows", list);
		return map;
	}
}
