package com.ssh.dao.mybatis.staff;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ssh.vo.staff.RoleVO;

public interface IRolesDAO {
	/**
	 * 名字、日期范围高级查询
	 * @param key
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<RoleVO> findGradeWhereRoles(
            @Param("key") String key,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
