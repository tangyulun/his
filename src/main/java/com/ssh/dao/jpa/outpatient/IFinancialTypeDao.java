package com.ssh.dao.jpa.outpatient;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialType;
import com.ssh.vo.outpatient.FinacialVo;
import com.ssh.vo.outpatient.FinancialTypeVo;

public interface IFinancialTypeDao extends CrudRepository<FinancialType, String>{
 
	@Query("select new com.ssh.vo.outpatient.FinancialTypeVo(f.financialTypeId,f.financialTypeName) from FinancialType f")
	public List<FinancialTypeVo> queryFunanType();
	
	/*
	//通过id查询分类
	@Query("select new com.ssh.vo.outpatient.FinancialTypeVo(f.financialTypeId,f.financialTypeName) from FinancialType f where f.id like ?1")
	public List<FinancialTypeVo> queryFunanTypeWhere(String financialTypeId);*/
	
	//连表查询收费类型
	@Query("select new com.ssh.vo.outpatient.FinancialTypeVo(f.financialTypeId,f.financialTypeName) from FinancialType f inner join f.financials ft where ft=?1")
	public FinancialTypeVo queryFinancialTypeName(Financial financial);
	
	@Query("select nvl(max(f.id) + 1 , 1) from FinancialType f ")
	public long selectMaxId();
	
	@Query("select f from FinancialType f where f.financialTypeName=?1")
	public FinancialType regexFTypaName(String finanTypeName);
}
