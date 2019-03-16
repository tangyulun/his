package com.ssh.dao.mybatis.staff;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.staff.EmpVO;

public interface MyIStaffDAO {
	public List<EmpVO> selectAllEmpWhereGrade(
            @Param("empName") String empName,
            @Param("empDeptId") String empDeptId,
            @Param("empDclassId") String empDclassId,
            @Param("empSex") String empSex,
            @Param("empState") String empState);
}
