package com.ssh.dao.jpa.operation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanType;
import com.ssh.vo.operation.JianyanTypeVo;

public interface JianyanTypeDao extends CrudRepository<JianyanType, Long>{
	/**
	 * 添加分类
	 * @return
	 */
	@Query("select nvl(max(j.jianyanTypeId) + 1,1) from JianyanType j")
		public long selectIdMax();
	
	/**
	 * 根据id查询分类
	 * @param jianyanId
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.JianyanTypeVo(j.jianyanTypeId,j.jianyanTypeName) from JianyanType j")
	public List<JianyanTypeVo> queryJianyanTypeWhere();
}
