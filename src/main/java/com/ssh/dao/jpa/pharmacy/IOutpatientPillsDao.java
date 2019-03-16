package com.ssh.dao.jpa.pharmacy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugYaofang;

public interface IOutpatientPillsDao extends CrudRepository<DrugYaofang, String>{
	@Query("select max(op.drugYaofangId) from DrugYaofang op where op.drugYaofangId like ?1")
	public String selectOPNumber(String num);
}
