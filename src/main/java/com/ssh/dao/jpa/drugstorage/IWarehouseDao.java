package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugWarehouse;

public interface IWarehouseDao extends CrudRepository<DrugWarehouse, String>{
	@Query("select max(w.drugWarehouseId) from DrugWarehouse w where w.drugWarehouseId like ?1")
	public String selectWNumber(String num);
	
	
}
