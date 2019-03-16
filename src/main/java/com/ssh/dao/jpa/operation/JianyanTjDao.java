package com.ssh.dao.jpa.operation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Jianyan;

public interface JianyanTjDao extends CrudRepository<Jianyan, String>{
	/*根据日期模糊查询单号*/
	@Query("select nvl(max(j.jianyanId) +1,1001) from Jianyan j")
	public String selectJianyantj();
}
