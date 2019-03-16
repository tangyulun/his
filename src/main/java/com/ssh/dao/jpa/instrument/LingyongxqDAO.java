package com.ssh.dao.jpa.instrument;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.ssh.pojos.QxUseqx;
import com.ssh.vo.instrument.CaigoXianqingVo;
import com.ssh.vo.instrument.LingyongHuizonXqVo;
import com.ssh.vo.instrument.LingyongXqVo;

public interface LingyongxqDAO extends CrudRepository<QxUseqx, Long>{
	@Query("select nvl(max(d.qxUseqxId)+1,1) from QxUseqx d")
	public long maxId();
	

	@Query("select new com.ssh.vo.instrument.LingyongHuizonXqVo(i.qxUseqxId,i.qxUseqxBeizu, i.qxUseqxJcshul, i.qxUseqxLyshul,"
			+ " i.qxUseqxPihao) from QxUseqx i"
			+ " where i.qxUse.qxUseId =?1")
	public List<LingyongHuizonXqVo> selectByinstrumentLYXqId(String qxUseId);
}
