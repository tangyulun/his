package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugInventory;

public interface IInventoryDao extends CrudRepository<DrugInventory, String>{
	@Query("select max(i.drugInventoryId) from DrugInventory i where i.drugInventoryId like ?1")
	public String INumber(String num);
}
