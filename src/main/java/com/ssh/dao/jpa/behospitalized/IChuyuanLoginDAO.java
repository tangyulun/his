package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ChuyuanLogin;

public interface IChuyuanLoginDAO extends CrudRepository<ChuyuanLogin, String>{
	@Query("select max(c.chuyuanLoginId) from ChuyuanLogin c where c.chuyuanLoginId like ?1")
	public String getNumber(String dateLike);
}
