package com.ssh.dao.jpa.outpatient;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.PrescriptionType;
import com.ssh.vo.outpatient.PrescriptionTypesVo;
/**
 * 划价dao类
 * @author Administrator
 *
 */
public interface IPrescriptionTypeDAO extends CrudRepository<PrescriptionType, String> {
	@Query("select new com.ssh.vo.outpatient.PrescriptionTypesVo(p.prespricedId) from PrescriptionType p where p.outpaitentRegist=?1")
	public List<PrescriptionTypesVo> selectAll(OutpaitentRegist o);
	
	/**
	 * 根据日期模糊查询单号
	 * @param dateLike
	 * @return
	 */
	@Query("select max(p.prespricedId) from  PrescriptionType p where p.prespricedId like ?1")
	public String selectLikeNumber(String dateLike);
}
