package com.ssh.service.staff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.dclass.IDClassDAO;
import com.ssh.dao.jpa.menu.IFunctionTypeDAO;
import com.ssh.dao.jpa.menu.IFunctionsDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.dao.jpa.staff.IRoleDAO;
import com.ssh.dao.mybatis.staff.IRolesDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Function;
import com.ssh.pojos.Role;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.staff.EmpVO;
import com.ssh.vo.staff.GrantFunctionTypeVO;
import com.ssh.vo.staff.GrantFunctionsVO;
import com.ssh.vo.staff.GrantFunctionsVO2;
import com.ssh.vo.staff.RoleVO;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private IRoleDAO IRDAO;
	@Autowired
	private IRolesDAO MIRDAO;
	
	@Autowired
	private IFunctionTypeDAO ITDAO;
	
	@Autowired
	private IFunctionsDAO IFDAO;
	
	@Autowired
	private IEmpDAO IEDAO;
	
	@Autowired
	private IDClassDAO ICDAO;
	
	/**
	 * 查询所有用户，给属于该角色的用户选中
	 * @param rolesId
	 * @return
	 */
	public List<EmpVO> selectGrantUser(long rolesId){
		List<EmpVO> list = IEDAO.selectGrantUser();
		for (EmpVO e : list) {
			e.setDclass(ICDAO.selectDlassToEmp(IEDAO.findOne(e.getEmpId())));
		}
		Role role = IRDAO.findOne(rolesId);
		for (Emp e : role.getEmps()) {
			for (EmpVO empVO : list) {
				if(e.getEmpId() == empVO.getEmpId()){
					empVO.setFrag(true);
				}
			}
		}
		return list;
	}
	
	/**
	 * 查询出所有的功能，给该角色的功能选中
	 * @param rolesId
	 * @return
	 */
	public List<GrantFunctionTypeVO> findByAllGrantType(long rolesId){
		List<GrantFunctionTypeVO> list = ITDAO.findGrantAllType();
		for (GrantFunctionTypeVO t : list) {
			List<GrantFunctionsVO> listF = IFDAO.findByChildren(t.getFunctionTypeId());
			Role role = IRDAO.findOne(rolesId);
			for (Function f : role.getFunctions()) {
				for (GrantFunctionsVO gV : listF) {
					if(f.getFunctionsId() == gV.getFunctionsId()){
						gV.setFrag(true);
					}
				}
			}
			t.setFunctions(listF);
		}
		return list;
	}
	
	/**
	 * 查询所有角色
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<RoleVO> findByAllRoles(int page, int rows){
		PageRequest pages = new PageRequest(page-1, rows);
		return IRDAO.findByAllRole(pages);
	}
	
	/**
	 * 总记录数
	 */
	public long roleCount(){
		return IRDAO.count();
	}
	
	/**
	 * 查询最大编号
	 * @return
	 */
	public long roleMaxId(){
		return IRDAO.findByMaxId();
	}
	
	
	/**
	 * 判断角色名是否存在
	 * @param rolesName
	 * @param yRolesName
	 * @return
	 */
	public Errors findByName(String rolesName, String yRolesName){
		
		Role role = null;
		if("".equals(yRolesName)){
			role = IRDAO.findByName(rolesName);
		}else{
			role = IRDAO.findByUpdateName(rolesName , yRolesName);
		}
		return role == null ? new Errors(true) : new Errors();
	}
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	public Errors insertRoles(Role role){
		Errors e = new Errors();
		try {
			role.setRolesId(roleMaxId());
			IRDAO.save(role);
			e.setError(true);
		} catch (Exception e2) {
			e2.printStackTrace();
			e.seteMessage("操作失败！"+e2.getMessage());
		}
		return e;
		
	}

	/**
	 * 给角色授权
	 * @param functionsId
	 * @param rolesId
	 * @return
	 */
	public Errors grantFunctions(List<Long> functionsId, long rolesId) {
		try {
			Role role = IRDAO.findOne(rolesId);
			if(role.getFunctions() != null){
				role.getFunctions().clear();
			}
			if(functionsId != null){
				for (Long l : functionsId) {
					if(l > 20){
						role.getFunctions().add(IFDAO.findOne(l));
					}
				}
			}
			return new Errors(true , "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors("操作失败："+e.getMessage());
		}
	}
	
	/**
	 * 给角色分配用户
	 * @param empIds
	 * @param rolesId
	 * @return
	 */
	public Errors grantUsers(List<Long> dealString, long rolesId) {
		try {
			Role role = IRDAO.findOne(rolesId);
			if(role.getEmps() !=null){
				for(Emp e : role.getEmps()){
					e.getRoles().remove(role);
				}
			}
			if(dealString != null){
				//再重新为角色分配用户
                for(Long userId: dealString){
                    Emp user = IEDAO.findOne(userId);
                    if(user.getRoles() == null){
                        user.setRoles(new ArrayList<Role>());
                    }
                    user.getRoles().add(role);
                }
			}
			return new Errors(true , "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors("操作失败："+e.getMessage());
		}
	}

	
	/**
	 * 查询角色的信息
	 * @param rolesId
	 * @return
	 */
	public List<RoleVO> selectRolesXq(long rolesId) {
		Role role = IRDAO.findOne(rolesId);
		List<RoleVO> list = new ArrayList<>();
		list.add(new RoleVO("角色编号", role.getRolesId()));
		list.add(new RoleVO("角色名称", role.getRolesName()));
		list.add(new RoleVO("角色作用", role.getRolesEffect()));
		list.add(new RoleVO("创建时间", role.getRolesDate()+""));
		return list;
	}

	/**
	 * 查询角色对应的所有用户
	 * @param rolesId
	 * @return
	 */
	public List<EmpVO> selectRolesUsers(long rolesId) {
		Role role = IRDAO.findOne(rolesId);
		 List<EmpVO> list = new ArrayList<>();
		if(role.getEmps() != null){
			for(Emp emp : role.getEmps()){
				list.add(new EmpVO(emp.getEmpId(), emp.getEmpLoginName(),
						emp.getEmpName(), new DClassVO(emp.getDclass().getDclassId(),emp.getDclass().getDclassName())));
			}
		}
		return list;
	}
	
	/**
	 * 查询角色对应的功能列表
	 * @param rolesId
	 * @return
	 */
	public List<FunctionsVo> selectFunctionsMessage(long rolesId) {
		Role role = IRDAO.findOne(rolesId);
		 List<FunctionsVo> list = new ArrayList<>();
		 if(role.getFunctions() != null){
			 for(Function f : role.getFunctions()){
				 list.add(new FunctionsVo(f.getFunctionsId() , f.getFunctionsName()));
			 }
		 }
		 TreeSet<Long> tree = new TreeSet<>();
			for (FunctionsVo f : list) {
				tree.add(f.getFunctionsId());
			}
			list.clear();
			for (Long l : tree) {
				Function fun = IFDAO.findOne(l);
				list.add(new FunctionsVo(fun.getFunctionsId(), fun.getFunctionsName()));
			}
		return list;
	}

	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public Errors updateRoles(Role role) {
		try {
			Role r = IRDAO.findOne(role.getRolesId());
			r.setRolesDate(role.getRolesDate());
			r.setRolesEffect(role.getRolesEffect());
			r.setRolesName(role.getRolesName());
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors("操作失败:"+e.getMessage());
		}
	}

	/**
	 * 删除角色
	 * @param rolesId
	 * @return
	 */
	public Errors deletesRoles(long rolesId) {
		try{
			Role role = IRDAO.findOne(rolesId);
            //如果已经有用户与该角色关联，则要先解除关联
            List<Emp> list = role.getEmps();
            if(list != null){
                for(Emp user: list){
                    if(user.getRoles() != null){
                        user.getRoles().remove(role);
                    }
                }
            }
            if(role.getFunctions() != null){
            	role.getFunctions().clear();
            }
			IRDAO.delete(role);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors("操作失败:"+e.getMessage());
		}
	}

	/**
	 * 根据名称查询角色
	 * @param page
	 * @param rows
	 * @param key
	 * @return
	 */
	public List<RoleVO> selectWhereRoles(int page, int rows, String key) {
		PageRequest pages = new PageRequest(page - 1 , rows);
		return IRDAO.findByWhereRoles("%"+key+"%" , pages);
	}

	/**
	 * 名字查询记录数
	 * @param key
	 * @return
	 */
	public long roleCount(String key) {
		return IRDAO.findWhereCount("%"+key+"%");
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
	Page<?> pages;
	public List<RoleVO> selectGradeWhereRoles(int page, int rows, String key, Date startDate, Date endDate) {
		pages = PageHelper.startPage(page, rows);
		List<RoleVO> list = MIRDAO.findGradeWhereRoles("".equals(key) ? null : "%"+key+"%", startDate ,  endDate);
		return list;
	}

	/**
	 * 高级查询记录数
	 * @param page
	 * @param rows
	 * @param key
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public long roleCount2() {
		return pages.getTotal();
	}

	public List<RoleVO> selectAllRoleToUser(long empId) {
		Emp emp = IEDAO.findOne(empId);
		List<RoleVO> listRole = IRDAO.findByAllRoleTo();
		if(emp != null){
			if(emp.getRoles() == null){
				emp.setRoles(new ArrayList<>());
			}
			for (Role r2 : emp.getRoles()) {
				for (RoleVO r : listRole) {
					if(r.getRolesId() == r2.getRolesId()){
						r.setFrag(true);
					}
				}
			}
		}
		return listRole;
	}
	
}
