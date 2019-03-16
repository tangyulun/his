package com.ssh.dao.jpa.dean;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugYaofang;
import com.ssh.vo.dean.DrugHairVo;

public interface MengzhengFayaoDao extends CrudRepository<DrugYaofang, String>{
	
	@Query("select fy from DrugYaofang fy")
	public List<DrugYaofang> selectMzFy();
	
	@Query("select fy from DrugYaofang fy where drugYaofangId like ?1")
	public List<DrugYaofang> mohufind(String drugYaofangId);
}
