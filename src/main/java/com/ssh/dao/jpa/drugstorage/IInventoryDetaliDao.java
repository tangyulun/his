package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugInventoryDetali;

public interface IInventoryDetaliDao extends CrudRepository<DrugInventoryDetali, Long>{

	@Query("select nvl(max(d.drugInventoryDetalisId)+1,1) from DrugInventoryDetali d")
	public long maxId();
}
