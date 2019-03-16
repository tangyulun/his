package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.YajinTuifei;

public interface IYajinTuifeiDAO extends CrudRepository<YajinTuifei, String> {
	@Query("select max(y.yajinTuifeiId) from YajinTuifei y where y.yajinTuifeiId like ?1")
	public String getNumber(String dateLike);
}
