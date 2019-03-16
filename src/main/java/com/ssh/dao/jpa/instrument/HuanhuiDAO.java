package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.ssh.pojos.QxReturn;
import com.ssh.vo.instrument.ThelibraryVo;

public interface HuanhuiDAO extends CrudRepository<QxReturn, String>{
	
	@Query("select max(o.qxReturnId) from QxReturn o where o.qxReturnId like ?1")
	
	public String selectLikeNumber(String dateLike);

	
	


}