package com.ssh.dao.mybatis.dept;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.dept.DeptVO;

public interface MyIDeptDAO {
	
	/**
	 * 高级查询
	 * @param deptName
	 * @param deptFuzeName
	 * @param state
	 * @param grade
	 * @return
	 */
	public List<DeptVO> selectGradeWhere(@Param("deptName") String deptName,
                                         @Param("deptFuzeName") String deptFuzeName,
                                         @Param("state") String state,
                                         @Param("grade") String grade);
}
