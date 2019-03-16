package com.ssh.dao.jpa.outpatient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugYaofangXq;

public interface IOutRegistPillXqDao extends CrudRepository<DrugYaofangXq, Long>{

	@Query("select nvl(max(d.drugYaofangXqId) +1 , 1) from DrugYaofangXq d")
	public long getDrugYaoFangId();
}
