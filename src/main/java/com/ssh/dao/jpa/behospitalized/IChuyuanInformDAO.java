package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ChuyuanInform;

public interface IChuyuanInformDAO extends CrudRepository<ChuyuanInform, String> {
	@Query("select max(c.chuyuanInformId) from ChuyuanInform c where c.chuyuanInformId like ?1")
	public String getNumber(String dateLike);
}
