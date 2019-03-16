package com.ssh.dao.mybatis.behospitalized;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.HospitaNotify;
import com.ssh.vo.behospitalized.HospitaNotifyVo;

public interface IMyHospitaNotifyDAO extends CrudRepository<HospitaNotify, String> {
	public List<HospitaNotifyVo> selectHosStartDateToEndDate(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("hospitalNotifyNumber") String hospitalNotifyNumber);
}
