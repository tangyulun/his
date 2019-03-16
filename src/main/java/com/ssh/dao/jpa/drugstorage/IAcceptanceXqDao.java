package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugAcceptanceXq;

public interface IAcceptanceXqDao extends CrudRepository<DrugAcceptanceXq,Long>{
	
	@Query("select nvl(max(xq.drugAcceptanceXq)+1,1) from DrugAcceptanceXq xq")
	public long maxId();
}
