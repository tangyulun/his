package com.ssh.dao.mybatis.outpatient;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.outpatient.MedicalVo;

public interface IMedicalDao {

	public List<MedicalVo> selectMedical(@Param("startTime") Date startTime,
                                         @Param("endTime") Date endTime,
                                         @Param("searcherId") String searcherId);
}
