package com.ssh.dao.jpa.outpatient;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.MedicalCard;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.outpatient.OutRegistDayCountVo;
import com.ssh.vo.outpatient.OutRegistVo;
import com.ssh.vo.outpatient.OutpatientVo;

public interface IOutpaitentDAO extends CrudRepository<OutpaitentRegist, String>{
	
	@Query("select new com.ssh.vo.outpatient.OutpatientVo(o.outpaitentRegistId,o.outpaitentRegistBinglihao) from OutpaitentRegist o ")
	public List<OutpatientVo> queryAll();

	/**
	 * 根据日期模糊查询单号
	 * @param dateLike
	 * @return
	 */
	@Query("select max(o.outpaitentRegistId) from OutpaitentRegist o where o.outpaitentRegistId like ?1")
	public String selectLikeNumber(String dateLike);
	
	@Query("select new com.ssh.vo.outpatient.OutRegistVo(o.outpaitentRegistId,o.outpaitentRegistType,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime) from OutpaitentRegist o where o.medicalCard=?1 order by o.id desc")
	public List<OutRegistVo> queryOutRegistAll(MedicalCard medical);
	
	@Query("select count(o.outpaitentRegistId) from OutpaitentRegist o where o.medicalCard=?1")
	public long queryOutRegistAllCount(MedicalCard medical);
	
	@Query("select new com.ssh.vo.outpatient.OutRegistVo(o.outpaitentRegistId,o.outpaitentRegistType,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime) from OutpaitentRegist o where o.id like ?1 and o.medicalCard=?2  order by o.id desc")
	public List<OutRegistVo> queryoutpaitentRegistIdLike(String outpaitentRegistId, MedicalCard medicalCardId);
	
	@Query("select count(o.outpaitentRegistId) from OutpaitentRegist o where o.id like ?1 and o.medicalCard=?2")
	public long queryRegistIdCount(String outpaitentRegistId, MedicalCard medicalCardId);
	
	@Query("select new com.ssh.vo.outpatient.OutRegistVo(o.outpaitentRegistId,o.outpaitentRegistType,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime,o.outpaitentRegistZhuangtai) from OutpaitentRegist o where o.id like ?1  order by o.id desc")
	public List<OutRegistVo> queryoutpaitentRegistDataIdLike(String outpaitentRegistId);
	
	@Query("select count(o.outpaitentRegistId) from OutpaitentRegist o where o.id like ?1")
	public long queryRegistIdDataCount(String outpaitentRegistId);


	@Query("select new com.ssh.vo.outpatient.OutRegistVo(o.outpaitentRegistId,o.outpaitentRegistType,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime,o.outpaitentRegistZhuangtai) from OutpaitentRegist o order by o.id desc")
	public List<OutRegistVo> queryOutRegist();
	
	@Query("select count(o.outpaitentRegistId) from OutpaitentRegist o")
	public long queryOutRegistAllCountAll();
	
	//查询所有挂号记录
	@Query("select new com.ssh.vo.outpatient.OutRegistVo(o.outpaitentRegistId,o.outpaitentRegistType,o.outpaitentRegistGuahaodate,o.outpaitentRegistGuahaotime,o.outpaitentRegistZhuangtai) from OutpaitentRegist o order by o.id desc")
	public List<OutRegistVo> selectOutRegistAll(Pageable page);
	
	@Query("select to_char(o.outpaitentRegistGuahaodate,'dd') ,count(o.outpaitentRegistId) from OutpaitentRegist o "
			+ "where to_char(o.outpaitentRegistGuahaodate,'mm') = ?1 group by to_char(o.outpaitentRegistGuahaodate,'dd')")
	public List<Object[]> queryregistDayCount(String month);
}
