package com.ssh.dao.jpa.menu;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Emp;
import com.ssh.pojos.QianDao;

public interface IQianDaoDAO extends CrudRepository<QianDao, Long> {

	public QianDao findByQianDaoDateAndEmp(Date date, Emp emp);

	@Query("select to_char(q.qianDaoDate , 'dd')"
			+ "from QianDao  q where q.emp = ?1 and  to_char(q.qianDaoDate , 'yyyy-mm') =?2"
			+ " group by to_char(q.qianDaoDate , 'dd')")
	public List<String> selectMoneyQD(Emp emp, String mm);

	@Query("select count(q.id) "
			+ "from QianDao  q where to_char(q.qianDaoDate , 'yyyy-mm') =?1 and q.emp=?2")
	public int findByToMonth(String format, Emp e);

}
