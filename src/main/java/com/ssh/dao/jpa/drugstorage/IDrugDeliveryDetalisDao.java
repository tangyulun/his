package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugDeliveryDetali;

public interface IDrugDeliveryDetalisDao extends CrudRepository<DrugDeliveryDetali, Long>{
	
	@Query("select nvl(max(d.drugDeliveryDetalisId)+1,1) from DrugDeliveryDetali d")
	public long maxId();
}
