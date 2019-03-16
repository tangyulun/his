package com.ssh.dao.jpa.nurse;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Prescription;
import com.ssh.vo.nurse.PrescriptionVo;

public interface IPrescriptionDAO extends CrudRepository<Prescription, String> {
	@Query("select new com.ssh.vo.nurse.PrescriptionVo(p.prescriptionId) from Prescription p ")
	public List<PrescriptionVo> selectAllPrescription();
	
	@Query("select new com.ssh.vo.nurse.PrescriptionVo(p.prescriptionId,p.prescriptionDate,"
			+ "p.prescriptionType,p.prescriptionYzzx,p.prescriptionZt) "
			+ "from Prescription p order by p.prescriptionId desc ")
	public List<PrescriptionVo> selectPrescription(Pageable pages);
	
	@Query("select new com.ssh.vo.nurse.PrescriptionVo(p.prescriptionId,p.prescriptionDate,"
			+ "p.prescriptionType,p.prescriptionYzzx,p.prescriptionZt) "
			+ "from Prescription p where p.prescriptionId like ?1 order by p.prescriptionId desc ")
	public List<PrescriptionVo> selectPrescriptionByName(Pageable pages, String prescriptionId);
	
	@Query("select count(p.prescriptionId) from Prescription p where p.prescriptionId like ?1")
	public long findPrescriptionId(String prescriptionId);
}
