package com.ssh.dao.mybatis.instrument;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ssh.vo.instrument.YanshoVo;

public interface InstrumentYanshiTimeDAO {
	public List<YanshoVo> selectInstrumentystiem(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("instrumentYsId") String instrumentYsId);

}
