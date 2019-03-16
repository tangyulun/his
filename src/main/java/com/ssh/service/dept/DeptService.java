package com.ssh.service.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.dept.IDeptDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.dao.mybatis.dept.MyIDeptDAO;
import com.ssh.pojos.Dept;
import com.ssh.utils.Errors;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.staff.EmpVO;

@Service
@Transactional
public class DeptService {
	
	@Autowired
	private IDeptDAO IDDAO;
	
	@Autowired
	private MyIDeptDAO MYIDDAO;
	
	@Autowired 
	private IEmpDAO IEDAO;
	
	/**
	 * 查询所有部门给科室选择
	 * @return
	 */
	public List<DeptVO> selectAllDeptToDClass(){
		return IDDAO.findByAllDeptToDClass();
	}
	/**
	 * 查询所有员工给部门选择
	 * @return
	 */
	public List<EmpVO> selectEmpToDept(){
		return IEDAO.selectEmpToDept();
	}
	
	
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<DeptVO> findByAllDept(int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		return IDDAO.findByAllDept(pages);
	}

	/**
	 * 查询总记录数
	 * @return
	 */
	public long count() {
		return IDDAO.count();
	}
	
	/**
	 * 创建新部门
	 * @param dept
	 * @return
	 */
	public Errors insertNewDept(Dept dept) {
		try{
		    dept.setDeptState("on".equals(dept.getDeptState()) ? "运行" : "不运行");
		    dept.setDeptId(findByMaxId());
			IDDAO.save(dept);
			return new Errors(true);
		}catch (Exception e) {
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 查询编号
	 */
	public long findByMaxId(){
		return IDDAO.fingByMaxId();
	}

	/**
	 * 验证角色名
	 * @param deptName
	 * @return
	 */
	public Errors regexDeptName(String deptName) {
		 return  IDDAO.regexDeptName(deptName) == null ? new Errors(true) : new Errors();
	}


	/**
	 * 查询记录数
	 * @param deptName
	 * @return
	 */
	public long selectDeptWhereCount(String deptName) {
		return IDDAO.selectDeptWhereCount("%"+deptName+"%");
	}

	/**
	 * 部门名查询
	 * @param page
	 * @param rows
	 * @param deptName
	 * @return
	 */
	public List<DeptVO> selectDeptWhere(int page, int rows, String deptName) {
		PageRequest pages = new PageRequest(page - 1, rows);
		return IDDAO.selectDeptNameWhere("%"+deptName+"%" , pages);
	}

	/**
	 * 负责人查询
	 * @param page
	 * @param rows
	 * @param deptFuzeName
	 * @return
	 */
	public List<DeptVO> selectDeptFuzeWhere(int page, int rows, String deptFuzeName) {
		PageRequest pages = new PageRequest(page - 1, rows);
		return IDDAO.selectDeptFuzeWhere("%"+deptFuzeName+"%" , pages);
	}


	/**
	 * 负责人查询记录数
	 * @param deptFuzeName
	 * @return
	 */
	public long selectDeptFuzeWhereCount(String deptFuzeName) {
		return IDDAO.DeptFuzeWhereCount("%"+deptFuzeName+"%");
	}

	
	Page<?> pages;	
	/**
	 * 根据查询
	 * @param page
	 * @param rows
	 * @param deptName
	 * @param deptFuzeName
	 * @param state
	 * @param grade
	 * @return
	 */
	public List<DeptVO> selectGradeWhere(int page, int rows, String deptName, String deptFuzeName, String state,
			String grade) {
		pages = PageHelper.startPage(page, rows);
		return MYIDDAO.selectGradeWhere("".equals(deptName) ? null : "%"+deptName+"%" ,
				"".equals(deptFuzeName) ? null : "%"+deptFuzeName+"%" , "全部".equals(state) ? null : state , "全部".equals(grade) ? null : grade);
	}

	/**
	 * 高级查询总记录数
	 * @return
	 */
	public long selectGradeWhereCount() {
		return pages.getTotal();
	}
}
