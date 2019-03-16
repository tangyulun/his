package com.ssh.dao.jpa.drugstorage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.YaokuKucun;

public interface YaokuKucunDao extends CrudRepository<YaokuKucun, Long>{
	
	@Query("select nvl(max(yk.yaokuKucunId)+1,1) from YaokuKucun yk")
	public long findMaxId();
}
