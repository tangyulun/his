package com.ssh.service.dclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.dclass.IDClassDAO;
import com.ssh.dao.jpa.dept.IDeptDAO;
import com.ssh.dao.mybatis.dclass.MyIDClassDAO;
import com.ssh.pojos.Dclass;
import com.ssh.pojos.Dept;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.dept.DeptVO;

@Service
@Transactional
public class DClassService {
	@Autowired
	private IDClassDAO IDDAO;
	
	@Autowired
	private IDeptDAO IDeDAO;
	
	@Autowired
	private MyIDClassDAO MYCDAO;
	
	/**
	 * 查询所有部门
	 * @param rows 
	 * @param page 
	 * @return
	 */
	public List<DClassVO> selectAllDept(int page, int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DClassVO> list = IDDAO.selectAllDClass(pages);
		for (DClassVO d : list) {
			d.setDept(IDeDAO.findByDClassToDept(IDDAO.findOne(d.getDclassId())));
		}
		return list;
	}

	/**
	 * 查询记录数
	 * @return
	 */
	public long count() {
		return IDDAO.count();
	}
	
	/**
	 * 添加科室
	 * @param d
	 * @param deptId
	 * @return
	 */
	public Errors insertDClass(Dclass d , long deptId){
		try {
			Dept dept = IDeDAO.findOne(deptId);
			d.setDept(dept);
			d.setDclassState("on".equals(d.getDclassState()) ? "运行" : "不运行");
			d.setDclassId(IDDAO.selectMaxId());
			IDDAO.save(d);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	/**
	 * 验证科室名是否存在
	 * @param dClassName
	 * @return
	 */
	public Errors regexDClassName(String dClassName) {
		Dclass dclass = IDDAO.regexDClassName(dClassName);
		return dclass == null ? new Errors(true) : new Errors();
	}

	public List<DClassVO> selectDclassWhereDclassName(int page , int rows , String dclassName) {
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DClassVO> list = IDDAO.selectDclassWhereDclassName("%"+dclassName+"%" , pages);
		for (DClassVO d : list) {
			d.setDept(IDeDAO.findByDClassToDept(IDDAO.findOne(d.getDclassId())));
		}
		return list;
	}

	public long whereDClassNameCount(int page , int rows , String dclassName) {
		return IDDAO.whereDClassNameCount("%"+dclassName+"%");
	}

	public List<DClassVO> selectDclassWhereFuzeName(int page, int rows, String fuzeName) {
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DClassVO> list = IDDAO.selectDclassWhereFuzeName("%"+fuzeName+"%" , pages);
		for (DClassVO d : list) {
			d.setDept(IDeDAO.findByDClassToDept(IDDAO.findOne(d.getDclassId())));
		}
		return list;
	}

	public Object whereFuzeNameCount(int page, int rows, String fuzeName) {
		return IDDAO.whereFuzeNameCount("%"+fuzeName+"%");
	}

	public List<DClassVO> whereSelectDClass(long deptId) {
		Dept dept = IDeDAO.findOne(deptId);
		return IDDAO.whereSelectDClass(dept);
	}

	public DeptVO whereSelectDept(long dclassId) {
		Dclass d = IDDAO.findOne(dclassId);
		return  new DeptVO(d.getDclassId(), d.getDclassName());
	}

	public long selectCountGrade() {
		return pages.getTotal();
	}
	
	Page<?> pages ;
	public List<DClassVO> selectDClassGradeWhere(String dclassName, String dclassFuzeName, String dclassDept,
			String dclassState, String dclassGrade, int page, int rows) {
		pages = PageHelper.startPage(page, rows);
		List<DClassVO> list = MYCDAO.selectDClassGradeWhere(
			"".equals(dclassName) ? null : "%"+dclassName+"%" ,
			"".equals(dclassFuzeName) ? null : "%"+dclassFuzeName+"%" ,
			"0".equals(dclassDept) ? null : dclassDept ,
			"全部".equals(dclassState) ? null : dclassState ,
			"全部".equals(dclassGrade) ? null : dclassGrade);
		//单个查询部门
		
		return list;
	}
}
