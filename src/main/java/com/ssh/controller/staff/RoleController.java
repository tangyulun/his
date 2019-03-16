package com.ssh.controller.staff;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Role;
import com.ssh.service.staff.RoleService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.staff.EmpVO;
import com.ssh.vo.staff.GrantFunctionTypeVO;
import com.ssh.vo.staff.RoleVO;

@Controller
public class RoleController {
	@Autowired
	private RoleService rSer;
	
	/**
	 * 查询角色对应的功能列表
	 * @param rolesId
	 * @return
	 */
	@GetMapping("/select_functions_message")
	@ResponseBody
	public List<FunctionsVo> selectFunctionsMessage(long rolesId){
		return rSer.selectFunctionsMessage(rolesId);
	}
	
	/**
	 * 查询角色对应的所有用户
	 * @param rolesId
	 * @return
	 */
	@GetMapping("/select_roles_users")
	@ResponseBody
	public List<EmpVO> selectRolesUsers(long rolesId){
		return rSer.selectRolesUsers(rolesId);
	}
	
	/**
	 * 查询角色的信息
	 * @param rolesId
	 * @return
	 */
	@GetMapping("/select_roles_xq")
	@ResponseBody
	public List<RoleVO> selectRolesXq(long rolesId){
		return rSer.selectRolesXq(rolesId);
	}
	
	/**
	 * 给角色分配用户
	 * @param empIds
	 * @param rolesId
	 * @return
	 */
	@PostMapping("/grant_users")
	@ResponseBody
	public Errors grantUsers(String empIds , long rolesId){
		return rSer.grantUsers(CommentOrder.dealString(empIds) , rolesId);
	}
	
	/**
	 * 查询所有用户
	 * @param rolesId
	 * @return
	 */
	@GetMapping("/select_grant_user")
	@ResponseBody
	public List<EmpVO> selectGrantUser(long rolesId){
		return rSer.selectGrantUser(rolesId);
	}
	
	/**
	 * 给角色授权
	 * @param functionsId
	 * @param rolesId
	 * @return
	 */
	@PostMapping("/grant_functions")
	@ResponseBody
	public Errors grantFunctions(String functionsId , long rolesId){
		return rSer.grantFunctions(CommentOrder.dealString(functionsId),rolesId);
	}
	
	/**
	 * 查询出所有的功能
	 * @param rolesId
	 * @return
	 */
	@GetMapping("/select_all_functions")
	@ResponseBody
	public List<GrantFunctionTypeVO> selectAllFunctions(long rolesId){
		return rSer.findByAllGrantType(rolesId);
	}
	
	/**
	 * 查询所有角色
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/select_all_roles")
	@ResponseBody
	public Map<String, Object> selectAllRoles(int page , int rows){
		Map<String,Object> map = new HashMap<>();
		List<RoleVO> list = rSer.findByAllRoles(page , rows);
		map.put("total" , rSer.roleCount());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 根据名称查询角色
	 * @param page
	 * @param rows
	 * @param key
	 * @return
	 */
	@GetMapping("/select_where_roles")
	@ResponseBody
	public Map<String , Object> selectWhereRoles(int page , int rows , String key){
		Map<String , Object> map = new HashMap<>();
		List<RoleVO> list = rSer.selectWhereRoles(page , rows , key);
		map.put("total", rSer.roleCount(key));
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 根据名字、日期范围高级查询
	 * @param page
	 * @param rows
	 * @param key
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/select_grade_where_roles")
	@ResponseBody
	public Map<String , Object> selectGradeWhereRoles(int page , int rows , String key , Date startDate , Date endDate){
		Map<String , Object> map = new HashMap<>();
		List<RoleVO> list = rSer.selectGradeWhereRoles(page , rows ,key , startDate , endDate);
		map.put("total", rSer.roleCount2());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	@PostMapping("/insert_roles")
	@ResponseBody
	public Errors insertRoles(Role role){
		return rSer.insertRoles(role);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@PostMapping("/update_roles")
	@ResponseBody
	public Errors updateRoles(Role role){
		return rSer.updateRoles(role);
	}
	
	/**
	 * 删除角色
	 * @param rolesId
	 * @return
	 */
	@PostMapping("/deletes_roles")
	@ResponseBody
	public Errors deletesRoles(long rolesId){
		return rSer.deletesRoles(rolesId);
	}
	
	/**
	 * 判断角色名是否存在
	 * @param rolesName
	 * @param yRolesName
	 * @return
	 */
	@PostMapping("/regex_roles_is_exist")
	@ResponseBody
	public Errors regexRolesIsExist(String rolesName , String yRolesName){
		return rSer.findByName(rolesName,yRolesName);
	}
	
	/**
	 * 查询所有角色
	 */
	@GetMapping("/select_all_role_to_user")
	@ResponseBody
	public List<RoleVO> selectAllRoleToUser(long empId){
		return rSer.selectAllRoleToUser(empId);
	}
}
