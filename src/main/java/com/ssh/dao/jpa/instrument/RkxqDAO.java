package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentRk;
import com.ssh.pojos.InstrumentRkXq;

public  interface RkxqDAO extends CrudRepository<InstrumentRkXq, Long>{
	@Query("select nvl(max(d.instrumentRkXqid)+1,1) from InstrumentRkXq d")
	public long maxId();
}
