package com.ssh.dao.jpa.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Emp;

public interface LoginDao extends CrudRepository<Emp, Long>{
	/**
	 * 登录查询用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@Query("select e from Emp e where e.empLoginName=?1 and e.empPwd=?2")
	public Emp regexEmp(String userName, String passWord);
}
