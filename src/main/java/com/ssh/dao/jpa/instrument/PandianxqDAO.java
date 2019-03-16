package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxLnventoryqx;


public interface PandianxqDAO extends CrudRepository<QxLnventoryqx, Long>{
	@Query("select nvl(max(d.qxLnventoryqxId)+1,1) from QxLnventoryqx d")
	public long maxId();

}
