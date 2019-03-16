package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentCaigouXq;

public  interface InstrumentzzDAO extends CrudRepository<InstrumentCaigouXq, Long>{
	@Query("select nvl(max(dax.instrumentCaigouXqId) + 1 , 1) from InstrumentCaigouXq dax")
	public long findinstrument();

}
