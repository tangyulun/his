package com.ssh.dao.jpa.staff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Emp;
import com.ssh.pojos.EmpMessage;

public interface IEmpMessage extends CrudRepository<EmpMessage , Long> {
	
	/**
	 * 查询编号
	 */
	@Query("select nvl(max(e.id) + 1 , 1) from EmpMessage e")
	public long selectMaxId();

}
