package com.ssh.dao.jpa.outpatient;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ChargeManagement;

public interface IOutpatientChargesDAO extends CrudRepository<ChargeManagement, String>{

	/**
	 *根据日期模糊查询获取门诊收费号
	 */
	@Query("select max(c.chargeManagementId) from ChargeManagement c where c.chargeManagementId like ?1")
	public String selectLikeNumer(String dateLike);
}
