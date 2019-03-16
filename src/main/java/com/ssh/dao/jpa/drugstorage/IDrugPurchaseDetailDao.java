package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugPurchaseDetail;
import com.ssh.vo.drugstorage.DrugPurchaseDetaliVo;

public interface IDrugPurchaseDetailDao extends CrudRepository<DrugPurchaseDetail , Long>{
	
	@Query("select nvl(max(dpd.drugPurchaseDetailsId) + 1 , 1) from DrugPurchaseDetail dpd")
	public long findMaxId();
	
	/**
	 * 根据药品采购订单号查询采购详情
	 * @param drugPurchaseId
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugPurchaseDetaliVo(dpd.drugPurchaseDetailsId,"
			+ " dpd.drugPurchaseDetailsBz, dpd.drugPurchaseDetailsDj, dpd.drugPurchaseDetailsJe,"
			+ " dpd.drugPurchaseDetailsNum, dpd.drugPurchaseDetailsPh) from DrugPurchaseDetail dpd"
			+ " inner join dpd.drugPurchase dp where dp.drugPurchaseId =?1")
	public List<DrugPurchaseDetaliVo> selectByPurchaseId(String drugPurchaseId);
}	
