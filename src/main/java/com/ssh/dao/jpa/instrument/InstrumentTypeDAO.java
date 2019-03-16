package com.ssh.dao.jpa.instrument;


import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Instrument;
import com.ssh.pojos.InstrumentType;
import com.ssh.vo.dept.DeptVO;
import com.ssh.vo.instrument.InstrumentTypeVo;
import com.ssh.vo.instrument.InstrumentVo;
import com.ssh.vo.outpatient.FinancialTypeVo;

public interface InstrumentTypeDAO extends CrudRepository<InstrumentType, Long> {
	//添加分类
	@Query("select nvl(max(h.instrumentTypeId)+1,1) from InstrumentType h")
	public long selectidMAX();
	
	
	
	//查询分类
	@Query("select new com.ssh.vo.instrument.InstrumentTypeVo(h.instrumentTypeId,h.instrumentTypeName)from InstrumentType h")
	public List<InstrumentTypeVo> findByAllDept();
	
	
	

	//验证分类重名
	@Query("select d from InstrumentType d where d.instrumentTypeName =?1")
	public InstrumentType regexiTypeName(String instrumentTypeName);
	

	@Query("select new com.ssh.vo.instrument.InstrumentTypeVo(f.instrumentTypeId,f.instrumentTypeName) from InstrumentType f")
	public List<InstrumentTypeVo> queryInstrumenType();
	
	
	
	

}
