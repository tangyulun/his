package com.ssh.dao.jpa.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhiliaoJizhang;

public interface IZhiliaoJizhangDAO extends CrudRepository<ZhiliaoJizhang, String> {
	@Query("select max(z.zhiliaoJizhangId) from ZhiliaoJizhang z where z.zhiliaoJizhangId like ?1")
	public String getNumber(String dateLike);
}
