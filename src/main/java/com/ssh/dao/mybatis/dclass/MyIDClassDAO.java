package com.ssh.dao.mybatis.dclass;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.dclass.DClassVO;

public interface MyIDClassDAO{

	List<DClassVO> selectDClassGradeWhere(
            @Param("dclassName") String dclassName,
            @Param("dclassFuzeName") String dclassFuzeName,
            @Param("dclassDept") String dclassDept,
            @Param("dclassState") String dclassState,
            @Param("dclassGrade") String dclassGrade);
	
}
