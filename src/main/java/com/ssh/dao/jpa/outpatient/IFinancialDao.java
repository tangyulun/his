package com.ssh.dao.jpa.outpatient;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialType;
import com.ssh.vo.outpatient.FinacialVo;

public interface IFinancialDao extends CrudRepository<Financial, String>{

	@Query("select new com.ssh.vo.outpatient.FinacialVo(f.financialId,f.financialExplain,f.financialMoney,f.financialPrice,"
			+ "f.financialName,f.financialType,f.financialZhekoujia) from Financial f order by f.id desc")
	public List<FinacialVo> queryFinacialAll(Pageable page);
	
	@Query("select count(f.financialId) from Financial f where f.id like ?1")
	public long queryFinancial(String financialId);
	
	//查询收费项目编号
	@Query("select max(f.financialId) from Financial f")
	public String queryFinancialWhere();

	@Query("select new com.ssh.vo.outpatient.FinacialVo(f.financialId,f.financialExplain,f.financialMoney,f.financialPrice,"
			+ "f.financialName,f.financialType,f.financialZhekoujia) from Financial f where f.financialTypeBean =?1 order by f.id desc")
	public List<FinacialVo> finByTypeFinancial(FinancialType ft, Pageable pageRequest);
	
	@Query("select count(f.id) from Financial f  where f.financialTypeBean =?1")
	public long finByTypeFinancialCount(FinancialType ft);
	
	//通过收费项目查询
	@Query("select new com.ssh.vo.outpatient.FinacialVo(f.financialId,f.financialExplain,f.financialMoney,f.financialPrice,"
			+ "f.financialName,f.financialType,f.financialZhekoujia) from Financial f where f.financialName like ?1 order by f.id desc")
	public List<FinacialVo> queryFinancialNameWhere(String financialName, Pageable page);
	
	@Query("select count(f.financialName) from Financial f where f.financialName like ?1")
	public long financialTypeNameCount(String financialName);
	
	@Query("select new com.ssh.vo.outpatient.FinacialVo(f.financialId, f.financialName) from Financial f where f.financialTypeBean.financialTypeId=1 order by f.id desc")
	public List<FinacialVo> queryFinacialXM(Pageable page);
	
	@Query("select count(f.financialName) from Financial f where f.financialTypeBean.financialTypeId=1")
	public long financialNameCount();
	
	@Query("select new com.ssh.vo.outpatient.FinacialVo(f.financialId) from Financial f")
	public List<FinacialVo> queryFinancialId();
}
