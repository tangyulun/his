package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxLnventory;


public interface PandianDAO extends CrudRepository<QxLnventory, String>{
	
	@Query("select max(o.qxLnventoryId) from QxLnventory o where o.qxLnventoryId like ?1")
	
	public String selectLikeNumber(String dateLike);

	


}
