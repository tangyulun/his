package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugPurchase;
import com.ssh.vo.drugstorage.DrugPurchaseVo;

public interface IPurchaseDao extends CrudRepository<DrugPurchase, String>{
	@Query("select max(p.drugPurchaseId) from DrugPurchase p where p.drugPurchaseId like ?1")
	public String selectDPNumber(String num);
	
	/**
	 * 分页查询药品采购信息
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugPurchaseVo(dp.drugPurchaseId, dp.drugPurchaseDhdate, "
			+ "dp.drugPurchaseGhdate, dp.drugPurchaseJhdz, dp.drugPurchaseMoney, dp.drugPurchaseZt) from DrugPurchase dp")
	public List<DrugPurchaseVo> selectDingdan(Pageable p);
	
	
	/**
	 * 根据订单号模糊查询
	 * @param drugPurchaseId
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugPurchaseVo(dp.drugPurchaseId, dp.drugPurchaseDhdate, "
			+ "dp.drugPurchaseGhdate, dp.drugPurchaseJhdz, dp.drugPurchaseMoney, dp.drugPurchaseZt)"
			+ " from DrugPurchase dp where dp.drugPurchaseId like ?1 order by dp.drugPurchaseId desc")
	public List<DrugPurchaseVo> mohufindDingdan(String drugPurchaseId, Pageable p);
	
	@Query("select count(dp.drugPurchaseId) from DrugPurchase dp where dp.drugPurchaseId =?1")
	public long mohuCount(String drugPurchaseId);
	
	/**
	 * 根据订单号或供应商查询
	 * @param drugPurchaseId
	 * @param supplierName
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugPurchaseVo(dp.drugPurchaseId, dp.drugPurchaseDhdate, "
			+ "dp.drugPurchaseGhdate, dp.drugPurchaseJhdz, dp.drugPurchaseMoney, dp.drugPurchaseZt)"
			+ " from DrugPurchase dp inner join dp.supplier s"
			+ " where dp.drugPurchaseId like ?1 or s.supplierName like ?2 order by dp.drugPurchaseId desc")
	public List<DrugPurchaseVo> mohufindByIdAndSup(String drugPurchaseId, String supplierName, Pageable p);
	
	/*@Query("select count(dp.drugPurchaseId , s.supplierName) from DrugPurchase dp "
			+ "inner join dp.supplier s where dp.drugPurchaseId =?1 or s.supplierName =?2")
	public long ByIdAndSupCount(String drugPurchaseId , String supplierName);*/
}
