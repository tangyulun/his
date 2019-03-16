package com.ssh.dao.mybatis.dean;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.dean.BingChuangVO;

public interface IMyBingChuangDAO {

	public List<BingChuangVO> selectAllBedsWhereGrade(
            @Param("key") String key1,
            @Param("state") String state,
            @Param("sex") String sex);
	
	
}
