package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentYanshouXq;
import com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo;
import com.ssh.vo.instrument.ZyanshoxqVo;

public interface YanshoxqingqingDAO extends CrudRepository<InstrumentYanshouXq, Long>{
	@Query("select nvl(max(d.instrumentYanshouXqId)+1,1) from InstrumentYanshouXq d")
	public long maxId();
	
	
	@Query("select new com.ssh.vo.instrument.ZyanshoxqVo(h.instrumentYanshouXqId, h.instrumentId, h.instrumentYanshouXqBhgeNum,"
			+ " h.instrumentYanshouXqHegeNum, h.instrumentYanshouXqMoney, h.instrumentYanshouXqPh, h.instrumentYanshouXqRemark, h.instrumentYanshouXqZongNum, h.instrumentYsId) "
			+ "from InstrumentYanshouXq h where h.instrumentYsId=?1")
	public List<ZyanshoxqVo> selecttable(String instrumentYsId);
	
	//查询退货table
	@Query("select new com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo(i.instrumentYanshouXqId,i.instrumentYanshouXqMoney,i.instrumentYanshouXqRemark,i.instrumentYanshouXqZongNum) from InstrumentYanshouXq i ")
		public List<InstrumentYanshoxiangqiangVo> selectyanshoxiangq();
	
	@Query("select new com.ssh.vo.instrument.InstrumentYanshoxiangqiangVo(i.instrumentYanshouXqId,i.instrumentYanshouXqMoney,i.instrumentYanshouXqRemark,i.instrumentYanshouXqBhgeNum)  "
			+ " from InstrumentYanshouXq i where i.instrumentYanshouXqBhgeNum > 0 and i.instrumentYsId=?1")
	public List<InstrumentYanshoxiangqiangVo> selecttablew(String instrumentYsId);
	}
