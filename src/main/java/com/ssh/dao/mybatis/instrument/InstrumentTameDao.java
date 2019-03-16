package com.ssh.dao.mybatis.instrument;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.instrument.InstrumentCaigouVo;


public interface InstrumentTameDao {
	public List<InstrumentCaigouVo> selectInstrument(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("instrumentCaigouId") String instrumentCaigouId);

}
