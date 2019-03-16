package com.ssh.dao.jpa.menu;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.FunctionType;
import com.ssh.vo.menu.FunctionTypeVo;
import com.ssh.vo.staff.GrantFunctionTypeVO;

public interface IFunctionTypeDAO extends CrudRepository<FunctionType, Long>{
	/**
	 * 查询功能分类
	 * @return
	 */
	@Query("select new com.ssh.vo.menu.FunctionTypeVo(f.functionTypeId, f.functionTypeIcon,"
			+ " f.functionTypeName,f.functionTypeShowOrder) from FunctionType f order by f.functionTypeShowOrder asc")
	public List<FunctionTypeVo> selectAllFunction();
	
	/**
	 * 查询功能分类
	 * @return
	 */
	@Query("select new com.ssh.vo.staff.GrantFunctionTypeVO(t.functionTypeId , t.functionTypeName) from FunctionType t order by t.functionTypeShowOrder asc")
	public List<GrantFunctionTypeVO> findGrantAllType();
}
