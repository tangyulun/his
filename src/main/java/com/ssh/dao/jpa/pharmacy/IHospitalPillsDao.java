package com.ssh.dao.jpa.pharmacy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanFayao;

public interface IHospitalPillsDao extends CrudRepository<ZhuyuanFayao, String>{
	@Query("select max(hp.zhuyuanFayaoId) from ZhuyuanFayao hp where hp.zhuyuanFayaoId like ?1")
	public String selectHPNumber(String num);
}
