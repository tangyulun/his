package com.ssh.dao.jpa.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhiliaoJizhangXq;

public interface IZhiliaoJizhangXqDAO extends CrudRepository<ZhiliaoJizhangXq, Long> {
	@Query("select nvl(max(z.zhiliaoJizhangXqId) + 1 , 1) from ZhiliaoJizhangXq z")
	public long getxqNumber();
}
