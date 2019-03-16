package com.ssh.dao.jpa.outpatient;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.MedicalCard;
import com.ssh.vo.outpatient.MedicalVo;

public interface IMedicalcardDao extends CrudRepository<MedicalCard, String>{

	@Query("select max(m.medicalCardCardId) from MedicalCard m")
	public String selectMaxCard();
	
	//查询所有
	@Query("select new com.ssh.vo.outpatient.MedicalVo(m.medicalCardCardId,m.empId,m.medicalCardAge,m.medicalCardBingzhuang,m.medicalCardDate,m.medicalCardHunyanzk,m.medicalCardIdencard,m.medicalCardName,m.medicalCardSex) from MedicalCard m  order by m.id desc")
	public List<MedicalVo> queryMedical(Pageable page);
	
	//通过卡号查询所有
	@Query("select new com.ssh.vo.outpatient.MedicalVo(m.medicalCardCardId,m.empId,m.medicalCardAge,"
			+ "m.medicalCardBingzhuang,m.medicalCardDate,m.medicalCardHunyanzk,m.medicalCardIdencard,"
			+ "m.medicalCardName,m.medicalCardSex) from MedicalCard m  where m.id like ?1 order by m.id desc")
	public List<MedicalVo> queryMedicalIdWhere(String medicalId, Pageable page);

	@Query("select count(m.medicalCardCardId) from MedicalCard m where m.id like ?1")
	public long selectMedicalCount(String MedicalId);

}
