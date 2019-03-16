package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;

public interface IOutpaitentRegistDAO extends CrudRepository<OutpaitentRegist, String> {
	@Query("select new com.ssh.vo.behospitalized.OutpaitentRegistVo(o.outpaitentRegistId, "
			+ "o.outpaitentRegistBinglihao,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime, "
			+ "o.outpaitentRegistLiushuihao,o.outpaitentRegistType,o.outpaitentRegistZhuangtai) "
			+ "from OutpaitentRegist o order by o.outpaitentRegistId desc ")
	public List<OutpaitentRegistVo> selectAllRegist(Pageable pages);
	
	@Query("select new com.ssh.vo.behospitalized.OutpaitentRegistVo(o.outpaitentRegistId, "
			+ "o.outpaitentRegistBinglihao,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime, "
			+ "o.outpaitentRegistLiushuihao,o.outpaitentRegistType,o.outpaitentRegistZhuangtai) "
			+ "from OutpaitentRegist o where o.outpaitentRegistId like ?1 order by o.outpaitentRegistId desc ")
	public List<OutpaitentRegistVo> selectTypeRegist(Pageable pages, String outpaitentRegistId);
	
	@Query("select count(o.outpaitentRegistId) from OutpaitentRegist o where o.outpaitentRegistId like ?1")
	public long findOutpaitentRegistIdCount(String outpaitentRegistId);
}
