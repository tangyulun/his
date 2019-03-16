package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentCaigouXq;

import com.ssh.vo.instrument.CaigoXianqingVo;

public interface CaigoxiangqinDAO extends CrudRepository<InstrumentCaigouXq, Long>{
	/**
	 * 根据器械采购订单号查询采购详情
	 * @param instrumentCaigouId
	 * @return
	 */
	@Query("select new com.ssh.vo.instrument.CaigoXianqingVo(i.instrumentCaigouXqId, "
			+ "i.instrumentCaigouXqMoney, i.instrumentCaigouXqNum, i.instrumentCaigouXqPh,"
			+ " i.instrumentCaigouXqPrice, i.instrumentCaigouXqRemark) from InstrumentCaigouXq i"
			+ " inner join i.instrumentCaigou ist where ist.instrumentCaigouId =?1")
	public List<CaigoXianqingVo> selectByinstrumentCaigouXqId(String instrumentCaigouId);


}
