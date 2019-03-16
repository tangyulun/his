package com.ssh.dao.jpa.outpatient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugYaofang;

public interface IOutPaientPillsDao extends CrudRepository<DrugYaofang, String>{
		
	
}
