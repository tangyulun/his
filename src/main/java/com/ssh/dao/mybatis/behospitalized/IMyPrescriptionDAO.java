package com.ssh.dao.mybatis.behospitalized;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Prescription;
import com.ssh.vo.nurse.PrescriptionVo;

public interface IMyPrescriptionDAO extends CrudRepository<Prescription, String> {
	public List<PrescriptionVo> selectPrescriptionStartDateToEndDate(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("prescriptionId") String prescriptionId);
}
