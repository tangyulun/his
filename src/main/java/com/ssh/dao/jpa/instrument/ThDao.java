package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxReturngoo;
import com.ssh.vo.instrument.YanshoVo;
import com.ssh.vo.instrument.YanshoxiangqingVo;

public interface ThDao extends CrudRepository<QxReturngoo, String>{
	
	@Query("select max(o.qxReturngoosId) from QxReturngoo o where o.qxReturngoosId like ?1")
	
	public String selectLikeNumber(String dateLike);





}
