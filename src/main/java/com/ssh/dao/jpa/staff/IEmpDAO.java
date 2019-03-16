package com.ssh.dao.jpa.staff;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Dept;
import com.ssh.pojos.Emp;
import com.ssh.vo.staff.EmpVO;

public interface IEmpDAO extends CrudRepository<Emp, Long> {
	
	@Query("select new com.ssh.vo.staff.EmpVO(e.empId) from Emp e")
	public List<EmpVO> selectAll();
	
	@Query("select new com.ssh.vo.staff.EmpVO(e.empId, e.empLoginName) from Emp e")
	public List<EmpVO> selectEmpToDept();

	@Query("select nvl(max(e.empId) + 1 , 10001) from Emp e")
	public long findByMaxId();
	
	@Query("select new com.ssh.vo.staff.EmpVO(e.empId , e.empDate "
			+ ", e.empLoginName , e.empName , e.empPwd , e.empState , e.empSex) from Emp e order by e.id desc")
	public List<EmpVO> selectAllEmp(Pageable pages);

	public Emp findByEmpLoginName(String loginName);

	@Query("select new com.ssh.vo.staff.EmpVO(e.empId , e.empDate "
			+ ", e.empLoginName , e.empName , e.empPwd , e.empState , e.empSex) from Emp e where e.empName like ?1  order by e.id desc")
	public List<EmpVO> selectEmpWhere(String empName, Pageable pages);
	
	@Query("select count(e.id) from Emp e where e.empName  like ?1  order by e.id desc")
	public long selectEmpWhereCount(String empName);
	
	@Query("select count(e.id) from Emp e  order by e.id desc")
	public long selectEmpWhereCount2();
	/**
	 * 查询员工
	 * @return
	 */
	@Query("select new com.ssh.vo.staff.EmpVO(e.empId , e.empLoginName , e.empName) from Emp e")
	public List<EmpVO> selectGrantUser();
	@Query("select new com.ssh.vo.staff.EmpVO(e.empId , e.empDate "
			+ ", e.empLoginName , e.empName , e.empPwd , e.empState , e.empSex) from Emp e order by e.id desc")
	public List<EmpVO> selectAllEmp2(Pageable pages);
	
	
}
