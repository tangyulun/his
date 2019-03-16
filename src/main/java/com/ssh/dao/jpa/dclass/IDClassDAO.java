package com.ssh.dao.jpa.dclass;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Dclass;
import com.ssh.pojos.Dept;
import com.ssh.pojos.Emp;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.dclass.DClassVO;

public interface IDClassDAO extends CrudRepository<Dclass, Long>{
	/**
	 * 查询所有科室
	 * @param pages 
	 * @return
	 */
	@Query("select new com.ssh.vo.dclass.DClassVO(d.dclassId, d.dclassAddress , d.dclassCreateDate, "
			+ " d.dclassExplain , d.dclassGrade , d.dclassName, d.dclassRemark, d.dclassState , d.dclassFuzeName) from Dclass d order by d.id desc")
	public List<DClassVO> selectAllDClass(Pageable pages);
	
	/**
	 * 查询单号
	 */
	@Query("select nvl(max(d.dclassId) + 1 , 1) from Dclass d")
	public long selectMaxId();

	/**
	 * 查询科室名是否存在
	 * @param dClassName
	 * @return
	 */
	@Query("select d from Dclass d where d.dclassName=?1")
	public Dclass regexDClassName(String dClassName);

	@Query("select new com.ssh.vo.dclass.DClassVO(d.dclassId, d.dclassAddress , d.dclassCreateDate, "
			+ " d.dclassExplain , d.dclassGrade , d.dclassName, d.dclassRemark, d.dclassState , d.dclassFuzeName)"
			+ " from Dclass d  where d.dclassName like ?1 order by d.id desc")
	public List<DClassVO> selectDclassWhereDclassName(String dClassName, Pageable pages);

	@Query("select count(d.dclassId) from Dclass d where d.dclassName like ?1")
	public long whereDClassNameCount(String dClassName);

	@Query("select count(d.dclassId) from Dclass d where d.dclassFuzeName like ?1")
	public long whereFuzeNameCount(String dclassFuzeName);

	@Query("select new com.ssh.vo.dclass.DClassVO(d.dclassId, d.dclassAddress , d.dclassCreateDate, "
			+ " d.dclassExplain , d.dclassGrade , d.dclassName, d.dclassRemark, d.dclassState , d.dclassFuzeName)"
			+ " from Dclass d  where d.dclassFuzeName like ?1 order by d.id desc")
	public List<DClassVO> selectDclassWhereFuzeName(String dclassFuzeName, Pageable pages);

	@Query("select new com.ssh.vo.dclass.DClassVO(d.dclassId, d.dclassAddress , d.dclassCreateDate, "
			+ " d.dclassExplain , d.dclassGrade , d.dclassName, d.dclassRemark, d.dclassState , d.dclassFuzeName)"
			+ " from Dclass d  where d.dept =?1 order by d.id desc")
	public List<DClassVO> whereSelectDClass(Dept dept);

	@Query("select new com.ssh.vo.dclass.DClassVO(d.dclassId, d.dclassAddress , d.dclassCreateDate, "
			+ " d.dclassExplain , d.dclassGrade , d.dclassName, d.dclassRemark, d.dclassState , d.dclassFuzeName)"
			+ " from Dclass d inner join d.emps de where de=?1")
	public DClassVO selectDlassToEmp(Emp emp);

}
