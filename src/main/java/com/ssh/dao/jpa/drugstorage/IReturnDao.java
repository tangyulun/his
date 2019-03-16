package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugTuihuo;

public interface IReturnDao extends CrudRepository<DrugTuihuo, String>{
	@Query("select max(t.drugTuihuoId) from DrugTuihuo t where t.drugTuihuoId like ?1")
	public String selectRNumber(String num);
}
