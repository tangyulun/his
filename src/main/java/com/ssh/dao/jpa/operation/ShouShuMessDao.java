package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuMess;
import com.ssh.vo.operation.ShouShuXqVo;

public interface ShouShuMessDao extends CrudRepository<ShoushuMess, String>{
	/**
	 * 添加手术挂单东西
	 * @return
	 */
	@Query("select max(s.shoushuMess) from ShoushuMess s where s.shoushuMess like ?1")
	public String addShoushuGd(String dateLike);
	
	/**
	 * 详情
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.ShouShuXqVo(s.shoushuMessXqId,s.shoushuMessXqMoney,s.shoushuMessXqName,s.shoushuMessXqNum,s.shoushuMessXqPrice,s.shoushuMessXqResult,s.shoushuMessXqType) from ShoushuMessXq s")
	public List<ShouShuXqVo> selectShoushuMessXq();
} 
