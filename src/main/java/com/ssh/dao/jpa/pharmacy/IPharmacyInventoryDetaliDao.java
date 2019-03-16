package com.ssh.dao.jpa.pharmacy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.PharmacyInventoryDetali;

public interface IPharmacyInventoryDetaliDao extends CrudRepository<PharmacyInventoryDetali, Long>{

	@Query("select nvl(max(p.pharmacyInventoryDetalisId)+1,1) from PharmacyInventoryDetali p")
	public long maxId();
	
}
