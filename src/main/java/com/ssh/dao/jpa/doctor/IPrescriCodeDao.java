package com.ssh.dao.jpa.doctor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.PrescriptionRecode;

public interface IPrescriCodeDao extends CrudRepository<PrescriptionRecode, String>{

	@Query("select nvl(max(p.prescriptionRecodeId) + 1, 1) from PrescriptionRecode p")
	public String queryPrescriCodeId();
	
	@Query("select to_char(f.prescriptionRecodeRq, 'mm') , sum(f.prescriptionRecodeMoney) "
			+ "from PrescriptionRecode f where f.prescriptionRecodeZt='结'"
			+ " group by to_char(f.prescriptionRecodeRq, 'mm')")
	public List<Object[]> selectZhexianTu();
	
	@Query("select to_char(f.prescriptionRecodeRq, 'mm') , sum(f.prescriptionRecodeMoney) "
			+ "from PrescriptionRecode f where f.prescriptionRecodeDrugType=?1 and f.prescriptionRecodeZt='结'"
			+ " group by to_char(f.prescriptionRecodeRq, 'mm') ")
	public List<Object[]> selectZhuXingTu(String type);
}
