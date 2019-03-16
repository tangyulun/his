package com.ssh.dao.mybatis.behospitalized;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.OutpaitentRegist;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;

public interface IMyOutpaitentRegistDAO extends CrudRepository<OutpaitentRegist, String> {
	public List<OutpaitentRegistVo> selectStartDateToEndDate(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("outpaitentRegistId") String outpaitentRegistId);
}
