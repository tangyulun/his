package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuMessXq;
import com.ssh.vo.operation.ShouShuXqVo;

public interface ShouShuXqDao extends CrudRepository<ShoushuMessXq, Long>{
	
	@Query("select nvl(max(s.shoushuMessXqId)+1,1) from ShoushuMessXq s")
	public long maxId();
	
	@Query("select new com.ssh.vo.operation.ShouShuXqVo(s.shoushuMessXqId,s.shoushuMessXqMoney,s.shoushuMessXqName,s.shoushuMessXqNum,"
			+ "s.shoushuMessXqPrice,s.shoushuMessXqResult,s.shoushuMessXqType) from ShoushuMessXq s "
			+ "inner join s.shoushuMessBean q where q.shoushuMess=?1")
	public List<ShouShuXqVo> selectShoushuXqHuiZong(String shoushuMess);
}
