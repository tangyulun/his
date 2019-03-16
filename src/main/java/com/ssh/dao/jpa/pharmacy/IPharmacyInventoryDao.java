package com.ssh.dao.jpa.pharmacy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.PharmacyInventory;

public interface IPharmacyInventoryDao extends CrudRepository<PharmacyInventory, String>{
	@Query("select max(pi.pharmacyInventoryId) from PharmacyInventory pi where pi.pharmacyInventoryId like ?1")
	public String selectPINumber(String num);
}
