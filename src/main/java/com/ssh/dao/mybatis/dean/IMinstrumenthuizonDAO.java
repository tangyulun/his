package com.ssh.dao.mybatis.dean;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.instrument.InstrumentCaigouVo;

public interface IMinstrumenthuizonDAO {
	public List<InstrumentCaigouVo> mohufindinstrument(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("instrumentCaigouId") String instrumentCaigouId,
            @Param("instrumentCaigouState") String instrumentCaigouState
    );
}