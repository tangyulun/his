package com.ssh.dao.jpa.instrument;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentType;
import com.ssh.vo.instrument.InstrumentVo;

public interface InstrumentDAO extends CrudRepository<Instrument, String> {
	//查询
	
	@Query("select new com.ssh.vo.instrument.InstrumentVo(i.instrumentId, i.instruemntTop, i.instrumentBaofeiDate,"
			+"i.instrumentButtom, i.instrumentChicun, i.instrumentName, i.instrumentQiyongDate,"
			+"i.instrumentRemark, i.instrumentShengNum, i. instrumentWaijieNum,"
			+"i.instrumentZongNum , i.instrumentPrice) from Instrument i ")
	public List<InstrumentVo> selectInstrument(Pageable page);

	//点击ul查询
	@Query("select new com.ssh.vo.instrument.InstrumentVo(i.instrumentId, i.instruemntTop, i.instrumentBaofeiDate,"
			+"i.instrumentButtom, i.instrumentChicun, i.instrumentName, i.instrumentQiyongDate,"
			+"i.instrumentRemark, i.instrumentShengNum, i. instrumentWaijieNum,"
			+"i.instrumentZongNum , i.instrumentPrice) "
			+ "from Instrument i where i.instrumentType=?1 order by i.instrumentId desc")
	public List<InstrumentVo> findByAllinstrument(InstrumentType ss, Pageable pageRequest);
	
	
	@Query("select count(i.instrumentId) from Instrument i where i.instrumentType=?1")
	public long finByinstrumentCount(InstrumentType ss);

	//输入框查询
	@Query("select new com.ssh.vo.instrument.InstrumentVo(i.instrumentId, i.instruemntTop, i.instrumentBaofeiDate,"
			+"i.instrumentButtom, i.instrumentChicun, i.instrumentName, i.instrumentQiyongDate,"
			+"i.instrumentRemark, i.instrumentShengNum, i. instrumentWaijieNum,"
			+"i.instrumentZongNum , i.instrumentPrice) "
			+ "from Instrument i where i.instrumentName like ?1 order by i.instrumentId desc")
	public List<InstrumentVo> selectAllinstrument(String instrumentName, Pageable pageRequest);
	
	@Query("select count(i.instrumentId) from Instrument i where i.instrumentName like ?1")
	public long selectinstrumentWhereCount(String instrumentName);
	
	@Query("select nvl(max(o.id) + 1 , 10001) from Instrument o ")
	public String selectMaxId();
	
	
	//验证器械名
	@Query("select d from Instrument d where d.instrumentName =?1")
	public Instrument regexiName(String instrumentName);

}
