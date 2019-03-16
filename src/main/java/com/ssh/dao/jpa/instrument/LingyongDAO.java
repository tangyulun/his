package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.QxUse;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.LingyongVo;

public interface LingyongDAO extends CrudRepository<QxUse, String>{
	
	@Query("select max(o.qxUseId) from QxUse o where o.qxUseId like ?1")
	
	public String selectLikeNumber(String dateLike);

	
	//查询领用
	@Query("select new com.ssh.vo.instrument.LingyongVo(i.qxUseId,i.qxUseDate,i.qxUseDuix,i.qxUseKeshi,i.qxUseState,i.qxUseWarehouse) from QxUse i ")
	public List<LingyongVo> selectInstrumently(Pageable page);
	
	
	
	//s输入框查询
	@Query("select new com.ssh.vo.instrument.LingyongVo(i.qxUseId,i.qxUseDate,i.qxUseDuix,i.qxUseKeshi,i.qxUseState,i.qxUseWarehouse) "
			+ "from QxUse i where i.qxUseId like ?1 order by i.qxUseId desc")
	public List<LingyongVo> selectAllinstrument(String qxUseId, Pageable pageRequest);
	
	
	//查询数
	@Query("select count(i.qxUseId) from QxUse i where i.qxUseId like ?1")
	public long selectinstrumentlyWhereCount(String qxUseId);

}
