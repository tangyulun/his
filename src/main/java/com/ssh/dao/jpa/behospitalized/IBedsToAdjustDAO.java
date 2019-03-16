package com.ssh.dao.jpa.behospitalized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.BedTiaozheng;

public interface IBedsToAdjustDAO extends CrudRepository<BedTiaozheng, String>{
	@Query("select max(b.bedTiaozhengId) from BedTiaozheng b where b.bedTiaozhengId like ?1")
	public String getNumber(String dateLike);
}
