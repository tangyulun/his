			package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.ssh.pojos.InstrumentY;
import com.ssh.vo.drugstorage.AcceptanceVo;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.YanshoVo;

public interface YanshoDao extends CrudRepository<InstrumentY, String>{
	
@Query("select max(o.instrumentYsId) from InstrumentY o where o.instrumentYsId like ?1")
	public String selectLikeNumber(String dateLike);

@Query("select new com.ssh.vo.instrument.YanshoVo(i.instrumentYsId,"
		+ " i.instrumentYsDate, i.instrumentYsPzdh, i.instrumentYsState) from InstrumentY i")
	public List<YanshoVo> selectyansho(Pageable p);

//s输入框查询
	@Query("select new com.ssh.vo.instrument.YanshoVo(i.instrumentYsId,i.instrumentYsDate,i.instrumentYsPzdh,i.instrumentYsState) "
			+ "from InstrumentY i where i.instrumentYsId like ?1 order by i.instrumentYsId desc")
	public List<YanshoVo> selectAllinstrumentys(String instrumentYsId, Pageable pageRequest);
	
	
	//查询数
		@Query("select count(i.instrumentYsId) from InstrumentY i where i.instrumentYsId like ?1")
		public long selectinstrumentcaigoWhereCountys(String instrumentYsId);
		
		//查询不合格的验收记录
		@Query("select new com.ssh.vo.instrument.YanshoVo(da.instrumentYsId,"
				+ " da.instrumentYsDate, da.instrumentYsPzdh, da.instrumentYsState) from InstrumentY da")
		public List<YanshoVo> selectNohegeJilu(Pageable p);
		
		
		@Query("select new com.ssh.vo.instrument.YanshoVo(i.instrumentYsId,"
				+ " i.instrumentYsDate, i.instrumentYsPzdh, i.instrumentYsState) from InstrumentY i")
			public List<YanshoVo> selectyanshoww();
}
