package com.ssh.dao.jpa.instrument;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxThelibrary;

public interface ChukuDAO extends CrudRepository<QxThelibrary, String>{
	
	@Query("select max(o.qxThelibraryId) from QxThelibrary o where o.qxThelibraryId like ?1")
	public String selectLikeNumber(String dateLike);
}
