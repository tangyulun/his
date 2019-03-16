package com.ssh.dao.jpa.login;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Emp;
import com.ssh.pojos.LoginLogger;
import com.ssh.vo.login.LoginLoggerVO;

public interface ILoginLoggerDAO extends CrudRepository<LoginLogger, Long>{
	/**
	 * 查询编号
	 */
	@Query("select nvl(max(l.id) + 1 , 1) from LoginLogger l")
	public Long selectMaxId();
	
	/**
	 * 查询当前登录的记录
	 * @param pageRequest 
	 */
	@Query("select new com.ssh.vo.login.LoginLoggerVO(l.loginLogger, l.loginDate, l.loginTimes) from LoginLogger l where l.emp=?1 order by l.id desc")
	public List<LoginLoggerVO> findByToEmp(Emp emp, Pageable pageRequest);

	@Query("select count(l.id) from LoginLogger l where l.emp=?1")
	public long empCount(Emp emp);

	@Query("select new com.ssh.vo.login.LoginLoggerVO(l.loginLogger, l.loginDate, l.loginTimes)"
			+ " from LoginLogger l where l.emp=?1 and l.loginDate=?2 order by l.id desc")
	public List<LoginLoggerVO> loginLoggerSelectWhere(Emp emp, Date times, Pageable pageRequest);

	@Query("select count(l.id) from LoginLogger l where l.emp=?1 and l.loginDate=?2 ")
	public Object empCountWhere(Emp emp, Date times);
	
	@Query("select new com.ssh.vo.login.LoginLoggerVO(l.loginLogger, l.loginDate, l.loginTimes)"
			+ " from LoginLogger l  order by l.id desc")
	public List<LoginLoggerVO> selectAllLogin(Pageable pageRequest);
	
	
	@Query("select to_char(l.loginDate , 'mm') , count(l.id) from LoginLogger l group by to_char(l.loginDate , 'mm') order by to_char(l.loginDate , 'mm') asc")
	public List<Object[]> selectCount();

	@Query("select to_char(l.loginDate , 'dd') , count(l.id) from LoginLogger l  where  "
			+ "  to_char(l.loginDate , 'mm') =?1 group by  to_char(l.loginDate , 'dd') ")
	public List<Object[]> selectLoggerMonth(String month);
  }
