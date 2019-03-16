package com.ssh.dao.mybatis.operation;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.operation.JianyanMessVo;


public interface TimeMessDao {
	
	public List<JianyanMessVo> selectMessTime(@Param("firstTime") Date firstTime,
                                              @Param("endTime") Date endTime,
                                              @Param("jianyanMessId") String jianyanMessId);
}
