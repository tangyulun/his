package com.ssh.service.staff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.dclass.IDClassDAO;
import com.ssh.dao.jpa.dept.IDeptDAO;
import com.ssh.dao.jpa.menu.IFunctionsDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.dao.jpa.staff.IEmpMessage;
import com.ssh.dao.jpa.staff.IRoleDAO;
import com.ssh.dao.mybatis.staff.MyIStaffDAO;
import com.ssh.pojos.Dclass;
import com.ssh.pojos.Dept;
import com.ssh.pojos.Emp;
import com.ssh.pojos.EmpMessage;
import com.ssh.pojos.Function;
import com.ssh.pojos.Role;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.menu.FunctionsVo;
import com.ssh.vo.staff.EmpVO;
import com.ssh.vo.staff.Other;
import com.ssh.vo.staff.RoleVO;

@Service
@Transactional
public class EmpService {
	
	@Autowired
	private IEmpDAO IEDAO;
	
	@Autowired
	private IDeptDAO IDDAO;
	
	@Autowired
	private IDClassDAO ICDAO;
	
	@Autowired
	private IEmpMessage IEMDAO;
	
	@Autowired
	private MyIStaffDAO MDAO;
	
	@Autowired
	private IRoleDAO IRDAO;
	
	@Autowired
	private IFunctionsDAO IFDAO;
	
	public List<EmpVO> selectAll(){
		return IEDAO.selectAll();
	}

	public long selectEmpId() {
		return IEDAO.findByMaxId();
	}

	/**
	 * 注册
	 * @param emp
	 * @param deptId
	 * @param dclassId
	 * @param em 
	 * @return
	 */
	public Errors insertEmp(Emp emp, long deptId, long dclassId, EmpMessage em) {
		try {
			emp.setEmpState(new BigDecimal("1"));
			emp.setEmpPwd(CommentOrder.encode(emp.getEmpPwd()));
			Dept dept = IDDAO.findOne(deptId);
			Dclass dclass = ICDAO.findOne(dclassId);
			emp.setDept(dept);
			emp.setDclass(dclass);
			
			em.setEmpMessageId(IEMDAO.selectMaxId());
			em.setEmp(emp);
			IEDAO.save(emp);
			IEMDAO.save(em);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	public long count() {
		return IEDAO.count();
	}
	public long count2() {
		return IEDAO.selectEmpWhereCount2();
	}

	public List<EmpVO> selectAllEmp(int page, int rows) {
		PageRequest pages = new PageRequest(page - 1, rows);
		List<EmpVO>  list = IEDAO.selectAllEmp(pages);
		findByOther(list);
		return list;
	}
	
	public List<EmpVO> selectAllEmp2(int page, int rows) {
		Dept d = null;
		PageRequest pages = new PageRequest(page - 1, rows);
		List<EmpVO>  list = IEDAO.selectAllEmp2(pages);
		findByOther(list);
		return list;
	}
	/**
	 * 公共绑定关系
	 * @param list
	 */
	private void findByOther(List<EmpVO> list) {
		for (EmpVO e : list) {
			e.setDclass(ICDAO.selectDlassToEmp(IEDAO.findOne(e.getEmpId())));
			e.setDept(IDDAO.selectDlassToEmp(IEDAO.findOne(e.getEmpId())));
		}
	}

	public Errors regexLoginName(String loginName) {
		Emp emp = IEDAO.findByEmpLoginName(loginName);
		return emp == null ? new Errors(true) : new Errors();
	}

	/**
	 * 名称查询
	 */
	public List<EmpVO> selectEmpWhere(int page, int rows, String empName) {
		System.err.println(empName);
		PageRequest pages = new PageRequest(page - 1 , rows);
		List<EmpVO>  list = IEDAO.selectEmpWhere("%"+empName+"%" , pages);
		findByOther(list);
		return list;
	}

	/**
	 * 名称查询长度
	 */
	public long selectEmpWhereCount(String empName) {
		return IEDAO.selectEmpWhereCount("%"+empName+"%");
	}

	Page<?> pages = null;
	public List<EmpVO> selectAllEmpWhereGrade(int page, int rows, String empName, String empDeptId, String empDclassId,
			String empSex, String empState) {
		pages = PageHelper.startPage(page, rows);
		return  MDAO.selectAllEmpWhereGrade(
				"".equals(empName) ? null : "%"+empName+"%" ,
				"0".equals(empDeptId) ? null : empDeptId,
				"0".equals(empDclassId) ? null : empDclassId ,
				"全部".equals(empSex) ? null : empSex, 
				"全部".equals(empState) ? null : empState);
	}

	public Object selectAllEmpWhereGradeCount() {
		return pages.getTotal();
	}

	/**
	 * 停用
	 * @param empId
	 * @param state
	 * @return
	 */
	public Errors deleteEmp(Long empId, int state) {
		try {
			Emp emp = IEDAO.findOne(empId);
			emp.setEmpState(new BigDecimal(state));
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	/**
	 * 重置
	 * @param empId 
	 * @return
	 */
	public Errors resetPwd(Long empId) {
		try {
			Emp emp = IEDAO.findOne(empId);
			emp.setEmpPwd(CommentOrder.encode("123456"));
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	public Errors updatePassword(String newPwd, Emp emp) {
		try {
			Emp e = IEDAO.findOne(emp.getEmpId());
			e.setEmpPwd(CommentOrder.encode(newPwd));
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	public List<Other> empMessageXq(long empId) {
		Emp e = IEDAO.findOne(empId);
		List<Other> list = new ArrayList<>();
		List<EmpMessage> em = e.getEmpMessages();
		
		
		list.add(new Other("编号", e.getEmpId()));
		list.add(new Other("姓名", e.getEmpName()));
		list.add(new Other("登录名", e.getEmpLoginName()));
		list.add(new Other("性别", e.getEmpSex()));
		list.add(new Other("入职日期", e.getEmpDate() == null ?
				null : (""+e.getEmpDate()).substring(0, 10)));
		list.add(new Other("员工状态", e.getEmpState().intValue() == 0 ? "禁用" : "启用"));
		list.add(new Other("所属部门", e.getDept().getDeptName()));
		list.add(new Other("所属科室", e.getDclass().getDclassName()));
		if(em.size() != 0){
		list.add(new Other("手机号", em.get(0).getEmpMessagePhone()));
		list.add(new Other("住址", em.get(0).getEmpMessageAddress()));
		list.add(new Other("出生日期", em.get(0).getEmpMessageBirthday() == null ?
					null : (""+em.get(0).getEmpMessageBirthday()).substring(0, 10)));
		list.add(new Other("批准日期", em.get(0).getEmpMessageDisposeDate() == null ?
				null : (""+em.get(0).getEmpMessageDisposeDate()).substring(0, 10)));
		list.add(new Other("批准人", em.get(0).getEmpMessageDisposeName()));
		list.add(new Other("政治面貌", em.get(0).getEmpMessageFace()));
		list.add(new Other("身份证编号", em.get(0).getEmpMessageIdCard()));
		list.add(new Other("婚姻状态", em.get(0).getEmpMessageIsMarry()));
		list.add(new Other("专业", em.get(0).getEmpMessageMajor()));
		list.add(new Other("民族", em.get(0).getEmpMessageNation()));
		list.add(new Other("备注", em.get(0).getEmpMessageRemark()));
		}
		return list;
	}

	public List<RoleVO> selectEmpRoles(long empId) {
		Emp e = IEDAO.findOne(empId);
		List<RoleVO> listR = new ArrayList<>();
		if(e.getRoles() == null){
			e.setRoles(new ArrayList<>());
		}
		if(e != null){
			for(Role r : e.getRoles()){
				listR.add(new RoleVO(r.getRolesId(), r.getRolesDate(), r.getRolesName()));
			}
		}
		return listR;
	}

	public List<FunctionsVo> selectEmpFunctions(long empId) {
		Emp e = IEDAO.findOne(empId);
		List<FunctionsVo> listF = new ArrayList<>();
		if(e.getRoles() == null){
			e.setRoles(new ArrayList<>());
		}
		List<Role> listR = e.getRoles();
		for (Role r : listR) {
			if(r.getFunctions() == null){
				r.setFunctions(new ArrayList<>());
			}
			for(Function  f : r.getFunctions()){
				listF.add(new FunctionsVo(f.getFunctionsId(), f.getFunctionsName()));
			}
		}
		TreeSet<Long> tree = new TreeSet<>();
		for (FunctionsVo f : listF) {
			tree.add(f.getFunctionsId());
		}
		listF.clear();
		for (Long l : tree) {
			Function fun = IFDAO.findOne(l);
			listF.add(new FunctionsVo(fun.getFunctionsId(), fun.getFunctionsName()));
		}
		return listF;
	}

	public Errors grantToEmpRoles(List<Long> list, long empId) {
		try {
			Emp e = IEDAO.findOne(empId);
			if(list != null){
				if(e.getRoles() == null){
					e.setRoles(new ArrayList<>());
				}
				e.getRoles().clear();
				for (Long l : list) {
					e.getRoles().add(IRDAO.findOne(l));
				}
			}
			return new Errors(true , "操作成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}

	public Errors updateDeptToEmp(long empId, long newDept, long newDclass) {
		try {
			Emp e = IEDAO.findOne(empId);
			Dept dept = IDDAO.findOne(newDept);
			Dclass dclass = ICDAO.findOne(newDclass);
			e.setDept(dept);
			e.setDclass(dclass);
			return new Errors(true, "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

}
