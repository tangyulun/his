package com.ssh.dao.jpa.nurse;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.PrescriptionRecode;
import com.ssh.vo.nurse.PrescriptionRecodeVo;

public interface IPrescriptionRecodeDAO extends CrudRepository<PrescriptionRecode, String> {
	@Query("select new com.ssh.vo.nurse.PrescriptionRecodeVo(p.prescriptionRecodeId,p.prescriptionId,"
			+ "p.prescriptionRecodeDrugType,p.prescriptionRecodeExplain,p.prescriptionRecodeMoney,"
			+ "p.prescriptionRecodeNum,p.prescriptionRecodePrice,p.prescriptionRecodeRq,p.prescriptionRecodeSj,"
			+ "p.prescriptionRecodeType,p.prescriptionRecodeZt) "
			+ "from PrescriptionRecode p where p.prescriptionId =?1")
	public List<PrescriptionRecodeVo> selectPrescriptionRecode(String prescriptionId);
}
