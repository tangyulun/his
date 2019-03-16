package com.ssh.dao.jpa.dept;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Dclass;
import com.ssh.pojos.Dept;
import com.ssh.pojos.Emp;
import com.ssh.vo.dept.DeptVO;

public interface IDeptDAO extends CrudRepository<Dept, Long> {
	/** 
	 * 查询所有部门
	 */
	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId, d.deptAddress, d.deptCreateDate, d.deptExplain, "
			+ "d.deptFuzeName,d.deptGrade, d.deptName, d.deptPizhunDate, d.deptPizhunName, d.deptRemark,"
			+ "d.deptShenheDate,d.deptShenheName,d.deptState) from Dept d order by d.id desc")
	public List<DeptVO> findByAllDept(Pageable pages);
	
	/**
	 * 查询最大编号
	 */
	@Query("select nvl(max(d.deptId) + 1 , 1) from Dept d")
	public long fingByMaxId();
	
	/**
	 * 验证部门
	 * @param deptName
	 * @return
	 */
	@Query("select d from Dept d where d.deptName =?1")
	public Dept regexDeptName(String deptName);

	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId, d.deptAddress, d.deptCreateDate, d.deptExplain, "
			+ "d.deptFuzeName,d.deptGrade, d.deptName, d.deptPizhunDate, d.deptPizhunName, d.deptRemark,"
			+ "d.deptShenheDate,d.deptShenheName,d.deptState) from Dept d where d.deptName like ?1 order by d.id desc")
	public List<DeptVO> selectDeptNameWhere(String deptName, Pageable pages);

	@Query("select count(d.deptId) from Dept d where d.deptName like ?1")
	public long selectDeptWhereCount(String deptName);

	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId, d.deptAddress, d.deptCreateDate, d.deptExplain, "
			+ "d.deptFuzeName,d.deptGrade, d.deptName, d.deptPizhunDate, d.deptPizhunName, d.deptRemark,"
			+ "d.deptShenheDate,d.deptShenheName,d.deptState) from Dept d where d.deptFuzeName like ?1 order by d.id desc")
	public List<DeptVO> selectDeptFuzeWhere(String deptFuzeName, Pageable pages);

	@Query("select count(d.deptId) from Dept d where d.deptFuzeName like ?1")
	public long DeptFuzeWhereCount(String deptFuzeName);

	/**
	 * 查询部门
	 * @param dclass
	 * 
	 */
	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId , d.deptName) from Dept d inner join d.dclasses dc where dc=?1")
	public DeptVO findByDClassToDept(Dclass dclass);
	
	/**
	 * 查询所有部门
	 * @return
	 */
	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId, d.deptAddress, d.deptCreateDate, d.deptExplain, "
			+ "d.deptFuzeName,d.deptGrade, d.deptName, d.deptPizhunDate, d.deptPizhunName, d.deptRemark,"
			+ "d.deptShenheDate,d.deptShenheName,d.deptState) from Dept d order by d.id desc")
	public List<DeptVO> findByAllDeptToDClass();

	@Query("select new com.ssh.vo.dept.DeptVO(d.deptId, d.deptAddress, d.deptCreateDate, d.deptExplain, "
			+ "d.deptFuzeName,d.deptGrade, d.deptName, d.deptPizhunDate, d.deptPizhunName, d.deptRemark,"
			+ "d.deptShenheDate,d.deptShenheName,d.deptState) from Dept d inner join d.emps de where de =?1 order by d.id desc")
	public DeptVO selectDlassToEmp(Emp emp);
	
}
