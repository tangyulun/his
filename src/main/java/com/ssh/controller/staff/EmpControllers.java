package com.ssh.controller.staff;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Emp;
import com.ssh.pojos.EmpMessage;
import com.ssh.service.staff.EmpService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.staff.EmpVO;
import com.ssh.vo.staff.Other;
import com.ssh.vo.staff.RoleVO;

@Controller
public class EmpControllers {
	@Autowired
	private EmpService eser;
	
	/**
	 * 查询员工编号
	 */
	@GetMapping("/select_emp_id")
	@ResponseBody
	public long selectEmpId(){
		return eser.selectEmpId();
	}
	
	/**
	 * 添加用户
	 */
	@PostMapping("/insert_emp")
	@ResponseBody
	public Errors insert_emp(Emp emp , long deptId , long dclassId , EmpMessage em){
		return eser.insertEmp(emp , deptId , dclassId , em);
	}
	
	/**
	 * 查询所有用户
	 */
	@GetMapping("/select_all_emp")
	@ResponseBody
	public Map<String , Object> selectAllEmp(int page , int rows){
		Map<String , Object> map = new HashMap<>();
		map.put("total", eser.count());
		map.put("rows", eser.selectAllEmp(page , rows));
		return map;
	}
	@GetMapping("/select_all_emp2")
	@ResponseBody
	public List<EmpVO> selectAllEmp2(int page , int rows){
		return eser.selectAllEmp2(page , rows);
	}
	/**
	 * 检测使用户名是否存在
	 */
	@PostMapping("regex_login_name")
	@ResponseBody
	public Errors regexLoginName(String loginName){
		return eser.regexLoginName(loginName);
	}
	
	/**
	 * 名称查询
	 */
	@GetMapping("/select_emp_where")
	@ResponseBody
	public Map<String , Object> selectEmpWhere(int page , int rows , String empName){
		Map<String , Object> map = new HashMap<>();
		map.put("rows", eser.selectEmpWhere(page , rows , empName));
		map.put("total", eser.selectEmpWhereCount(empName));
		return map;
	}
	
	/**
	 * 高级查询
	 */
	@GetMapping("/select_all_emp_where_grade")
	@ResponseBody
	public Map<String , Object> selectAllEmpWhereGrade(int page , int rows , 
					String empName ,
					String empDeptId,
					String empDclassId,
					String empSex,
					String empState){
		Map<String , Object> map = new HashMap<>();
		map.put("rows", eser.selectAllEmpWhereGrade(page , rows , empName , empDeptId ,
				empDclassId , empSex , empState));
		map.put("total", eser.selectAllEmpWhereGradeCount());
		return map; 
	}
	
	/**
	 * 停用和启用
	 */
	@GetMapping("/deletes_emp")
	@ResponseBody
	public Errors deletesEmp(Long empId , int state){
		return eser.deleteEmp(empId , state);
	}
	
	/**
	 * 重置
	 */
	@GetMapping("/reset_pwd")
	@ResponseBody
	public Errors resetPwd(Long empId){
		return eser.resetPwd(empId);
	}
	
	/**
	 * 修改用户密码
	 */
	@PostMapping("/update_password")
	@ResponseBody
	public Errors updatePassword(String newPwd , HttpSession session){
		return eser.updatePassword(newPwd , (Emp)session.getAttribute("empMessage"));
	}
	
	/**
	 * 查询原密码是否正确
	 */
	@PostMapping("/regex_pwd_true")
	@ResponseBody
	public Errors regexPwdTrue(String oldPwd,HttpSession session){
		return CommentOrder.encode(oldPwd).equals(((Emp)session.getAttribute("empMessage")).getEmpPwd()) ? new Errors(true) : new Errors();
	}
	
	/**
	 * 查看用户基本信息
	 */
	@GetMapping("/emp_message_xq")
	@ResponseBody
	public List<Other> empMessageXq(long empId){
		return eser.empMessageXq(empId);
	}
	
	
	/**
	 * 查看用户的所有角色
	 */
	@GetMapping("/select_emp_roles")
	@ResponseBody
	public List<RoleVO> selectEmpRoles(long empId){
		return eser.selectEmpRoles(empId);
	}
	
	/**
	 * 查看功能列表
	 */
	@GetMapping("/select_emp_functions")
	@ResponseBody
	public List<FunctionsVo> selectEmpFunctions(long empId){
		List<FunctionsVo> list =  eser.selectEmpFunctions(empId);
		return list;
	}
	/**
	 * 分配角色
	 */
	@PostMapping("/grant_to_emp_roles")
	@ResponseBody
	public Errors grantToEmpRoles(String rolesIds , long empId){
		return eser.grantToEmpRoles(CommentOrder.dealString(rolesIds) , empId);
	}
	
	/**
	 * 调换部门
	 */
	@PostMapping("/update_dept_to_emp")
	@ResponseBody
	public Errors updateDeptToEmp(long empId , long newDept , long newDclass){
		return eser.updateDeptToEmp(empId , newDept , newDclass);
	}
}
