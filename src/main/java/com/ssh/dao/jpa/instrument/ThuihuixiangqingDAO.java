package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugTuihuoXq;
import com.ssh.pojos.QxReturngoosqx;

public interface ThuihuixiangqingDAO extends CrudRepository<QxReturngoosqx, Long>{

	@Query("select nvl(max(d.qxReturngoosqxId)+1,1) from QxReturngoosqx d")
	public long selectmaxId();
}
