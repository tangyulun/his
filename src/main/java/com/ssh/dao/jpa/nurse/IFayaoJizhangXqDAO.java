package com.ssh.dao.jpa.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.FayaoJizhangXq;

public interface IFayaoJizhangXqDAO extends CrudRepository<FayaoJizhangXq, Long> {
	@Query("select nvl(max(f.fayaoJizhangXqId) + 1 , 1) from FayaoJizhangXq f")
	public long getxqNumber();
}
