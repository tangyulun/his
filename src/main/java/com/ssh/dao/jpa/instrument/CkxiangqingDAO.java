package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxThelibraryqx;

public interface CkxiangqingDAO extends CrudRepository<QxThelibraryqx, Long>{

	@Query("select nvl(max(d.qxThelibraryqxId)+1,1) from QxThelibraryqx d")
	public long maxId();
}
