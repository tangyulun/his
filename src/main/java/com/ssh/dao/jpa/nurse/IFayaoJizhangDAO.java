package com.ssh.dao.jpa.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.FayaoJizhang;

public interface IFayaoJizhangDAO extends CrudRepository<FayaoJizhang, String> {
	@Query("select max(f.zhuyuanJizhangId) from FayaoJizhang f where f.zhuyuanJizhangId like ?1")
	public String getNumber(String dateLike);
}
