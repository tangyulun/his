package com.ssh.dao.jpa.instrument;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentRk;
import com.ssh.pojos.QxThelibrary;
import com.ssh.vo.instrument.ThelibraryVo;


public interface IThelibrayDAO extends CrudRepository<InstrumentRk, String>{
	@Query("select new com.ssh.vo.instrument.ThelibraryVo(q.qxThelibraryId,q.qxThelibraryDate,"
			+ "q.qxThelibraryDuixiang,q.qxThelibraryPzId,q.qxThelibraryState,"
			+ "q.qxThelibraryType,q.qxThelibraryWarehouse) from QxThelibrary q")
		public List<ThelibraryVo> selectAll();
	
	/**
	 * 根据日期模糊查询单号
	 */

	@Query("select max(o.instrumentRkId) from InstrumentRk o where o.instrumentRkId like ?1")
		public String selectLikeNumber(String dateLike);

}

