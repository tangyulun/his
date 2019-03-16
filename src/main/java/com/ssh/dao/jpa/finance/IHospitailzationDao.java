package com.ssh.dao.jpa.finance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ChargeJiesuan;

/**
 * 住院收费结算Dao类
 * @author Administrator
 *
 */
public interface IHospitailzationDao extends CrudRepository<ChargeJiesuan, String>{

	@Query("select max(c.chargeJiesuanId) from ChargeJiesuan c where c.chargeJiesuanId like ?1")
	public String hospitalSelect(String datelike);
}
