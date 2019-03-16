package com.ssh.dao.jpa.operation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuType;

public interface SugeryFlDao extends CrudRepository<ShoushuType, Long>{
	/**
	 * 查询手术分类是否存在
	 * @param dclassName
	 * @return
	 */
	@Query("select s from ShoushuType s where s.shoushuTypeName=?1")
	public ShoushuType sugeryflclassName(String shoushuTypeName);
}
