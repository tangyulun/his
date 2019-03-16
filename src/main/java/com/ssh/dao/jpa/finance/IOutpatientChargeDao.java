package com.ssh.dao.jpa.finance;

import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ChargeJiesuan;

/**
 * 门诊收费结算Dao类
 * @author Administrator
 *
 */
public interface IOutpatientChargeDao extends CrudRepository<ChargeJiesuan, String>{
	
}
