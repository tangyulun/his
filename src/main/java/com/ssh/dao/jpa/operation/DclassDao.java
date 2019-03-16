package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Dclass;
import com.ssh.vo.operation.DclasssVo;

public interface DclassDao extends CrudRepository<Dclass, Long>{
	@Query("select new com.ssh.vo.operation.DclasssVo(d.dclassId,d.dclassAddress,d.dclassCreateDate,d.dclassExplain,d.dclassFuzeName,"
			+ "d.dclassGrade,d.dclassName,d.dclassRemark,d.dclassState) from Dclass d")
	public List<DclasssVo> queryDclass();
}
