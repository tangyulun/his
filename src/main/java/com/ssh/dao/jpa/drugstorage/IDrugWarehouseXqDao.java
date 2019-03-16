package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugWarehouseXq;

public interface IDrugWarehouseXqDao extends CrudRepository<DrugWarehouseXq, Long>{
	
	@Query("select nvl(max(dw.drugWarehouseXqId)+1,1) from DrugWarehouseXq dw")
	public long maxId();
}
