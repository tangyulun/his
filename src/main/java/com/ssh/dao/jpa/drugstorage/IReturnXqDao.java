package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugTuihuoXq;

public interface IReturnXqDao extends CrudRepository<DrugTuihuoXq, Long>{
	
	@Query("select nvl(max(d.drugTuihuoXqId)+1,1) from DrugTuihuoXq d")
	public long selectmaxId();
}
