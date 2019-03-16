package com.ssh.service.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.finance.IHospitailzationDao;
import com.ssh.utils.CommentOrder;

/**
 * 住院收费结算业务类
 * @author Administrator
 *
 */
@Service
@Transactional
public class HospitailzaService {
	
	@Autowired
	private IHospitailzationDao hospitailDao;
	
	public String HNumber(){
		return hospitailDao.hospitalSelect(CommentOrder.dateLike());
	}
	
}
