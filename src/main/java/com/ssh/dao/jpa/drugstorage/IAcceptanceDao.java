package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugAcceptance;
import com.ssh.vo.drugstorage.AcceptanceVo;

public interface IAcceptanceDao extends CrudRepository<DrugAcceptance, String>{
	
	@Query("select max(a.drugAcceptanceId) from DrugAcceptance a where a.drugAcceptanceId like ?1")
	public String selectNumber(String num);
	
	/**
	 * 查询验收记录
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.AcceptanceVo(da.drugAcceptanceId,"
			+ " da.drugAcceptancePzdh, da.drugAcceptanceShdate, da.drugAcceptanceZt) from DrugAcceptance da")
	public List<AcceptanceVo> selectJilu(Pageable p);
	
	/**
	 * 查询不合格的验收记录
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.AcceptanceVo(da.drugAcceptanceId,"
			+ " da.drugAcceptancePzdh, da.drugAcceptanceShdate, da.drugAcceptanceZt) from DrugAcceptance da"
			+ " inner join da.drugAcceptanceXqs dax where dax.drugAcceptanceXqBuhegeNum >0")
	public List<AcceptanceVo> selectNohegeJilu(Pageable p);
	
	
	/**
	 * 根据凭证单号查询
	 * @param drugAcceptancePzdh
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.AcceptanceVo(da.drugAcceptanceId, da.drugAcceptancePzdh, "
			+ "da.drugAcceptanceShdate, da.drugAcceptanceZt) from DrugAcceptance da where da.drugAcceptancePzdh =?1")
	public List<AcceptanceVo> select(String drugAcceptancePzdh);
	
	@Query("select da from DrugAcceptance da where da.drugAcceptancePzdh =?1")
	public DrugAcceptance selectByPzdh(String drugAcceptancePzdh);
	
	/**
	 * 模糊查询根据采购订单号
	 * @param drugAcceptanceId
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.AcceptanceVo(da.drugAcceptanceId, da.drugAcceptancePzdh, "
			+ "da.drugAcceptanceShdate, da.drugAcceptanceZt) from DrugAcceptance da where da.drugAcceptanceId like ?1")
	public List<AcceptanceVo> mohufindById(String drugAcceptanceId, Pageable p);
	
	@Query("select nvl(max(da.drugAcceptanceId)) from DrugAcceptance da where da.drugAcceptanceId like ?1")
	public long mohufindByIdCount(String drugAcceptanceId);
	
}


