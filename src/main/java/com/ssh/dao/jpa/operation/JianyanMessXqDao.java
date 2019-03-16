package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanMessXq;
import com.ssh.vo.operation.JianyanMessXqVo;


public interface JianyanMessXqDao extends CrudRepository<JianyanMessXq, Long>{
	/**
	 * 检验详情加入得
	 * @return
	 */
	@Query("select max(j.jianyanMessXqId) from JianyanMessXq j where j.jianyanMessXqId like ?1")
	public long addJianyanMessXq(); 
	
	@Query("select nvl(max(j.jianyanMessXqId)+1,1) from JianyanMessXq j")
	public long maxId();
	
	/**
	 * 第二个表格				
	 * */													
	@Query("select new com.ssh.vo.operation.JianyanMessXqVo(j.jianyanMessXqId,j.jianyanMessXq,j.jianyanMessXqBetween,j.jianyanMessXqResult) from JianyanMessXq j "
			+ "inner join j.jianyanMess jj where jj.jianyanMessId=?1")
	public List<JianyanMessXqVo> selectJianyanXqHuiZong(String JianyanMessId);
}
