package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxReturn;
import com.ssh.pojos.QxReturnqx;

public  interface HuanhuixqDAO extends CrudRepository<QxReturnqx, String>{
	@Query("select nvl(max(d.qxReturnqxId)+1,1) from QxReturnqx d")
	public long maxId();

}
