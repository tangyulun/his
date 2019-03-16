package com.ssh.dao.jpa.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanFayaoXq;

public interface IZhuyuanFayaoXqDAO extends CrudRepository<ZhuyuanFayaoXq, Long> {
	@Query("select nvl(max(z.zhuyuanFayaoXqId) + 1 , 1) from ZhuyuanFayaoXq z")
	public long getxqNumber();
}
