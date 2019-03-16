package com.ssh.dao.jpa.operation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanType;
import com.ssh.pojos.ShoushuType;


public interface KeshiClassDao extends CrudRepository<JianyanType, String>{
		/**
		 * 查询科室是否存在
		 * @param dclassName
		 * @return
		 */
		@Query("select j from JianyanType j where j.jianyanTypeName=?1")
		public JianyanType regexKeshiclassName(String jianyanTypeName);
		
}
