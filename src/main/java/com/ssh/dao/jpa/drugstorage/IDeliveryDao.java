package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugDelivery;

public interface IDeliveryDao extends CrudRepository<DrugDelivery, String>{
	@Query("select max(d.drugDeliveryId) from DrugDelivery d where d.drugDeliveryId like ?1")
	public String selectDNumber(String num);
}
