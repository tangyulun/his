package com.ssh.dao.jpa.instrument;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.InstrumentCaigou;
import com.ssh.vo.instrument.InstrumentCaigouVo;
import com.ssh.vo.instrument.InstrumentVo;


public interface ICaigoDAO extends CrudRepository<InstrumentCaigou, String>{
	
	@Query("select max(o.instrumentCaigouId) from InstrumentCaigou o where o.instrumentCaigouId like ?1")
	public String selectLikeNumber(String dateLike);

	//查询采购
	@Query("select new com.ssh.vo.instrument.InstrumentCaigouVo(i.instrumentCaigouId,i.instrumentCaigouAddress,i.instrumentCaigouDhDate,i.instrumentCaigouGhDate,i.instrumentCaigouMoney,i.instrumentCaigouState) from InstrumentCaigou i ")
	public List<InstrumentCaigouVo> selectInstrumentcaig(Pageable page);
	
	@Query("select nvl(max(o.instrumentCaigouId)+1,10001) from InstrumentCaigou o where o.instrumentCaigouId like ?1")
	public String selectLikeNumberid();

	
	
	//s输入框查询
	@Query("select new com.ssh.vo.instrument.InstrumentCaigouVo(i.instrumentCaigouId,i.instrumentCaigouAddress,i.instrumentCaigouDhDate,i.instrumentCaigouGhDate,i.instrumentCaigouMoney,i.instrumentCaigouState) "
			+ "from InstrumentCaigou i where i.instrumentCaigouId like ?1 order by i.instrumentCaigouId desc")
	public List<InstrumentCaigouVo> selectAllinstrument(String instrumentCaigouId, Pageable pageRequest);
	//查询数
	@Query("select count(i.instrumentCaigouId) from InstrumentCaigou i where i.instrumentCaigouId like ?1")
	public long selectinstrumentcaigoWhereCount(String instrumentCaigouId);

}
