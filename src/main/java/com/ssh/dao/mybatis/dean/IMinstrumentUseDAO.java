package com.ssh.dao.mybatis.dean;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.instrument.LingyongVo;

public interface IMinstrumentUseDAO {
	public List<LingyongVo> mohufindinstrumentUse(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("qxUseId") String qxUseId,
            @Param("qxUseState") String qxUseState
    );
}