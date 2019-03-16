package com.ssh.dao.jpa.operation;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuType;
import com.ssh.vo.operation.JianyanTypeVo;
import com.ssh.vo.operation.ShouShuTypeVo;

public interface ShouShuTypeDao extends CrudRepository<ShoushuType, Long>{
	/**
	 * 添加分类
	 * @return
	 */
	@Query("select nvl(max(s.shoushuTypeId) +1,1) from ShoushuType s")
	public long selectAddfl();
	
	/**
	 * 左边的文件夹
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.ShouShuTypeVo(s.shoushuTypeId , s.shoushuTypeName) from ShoushuType s")
	public  List<ShouShuTypeVo> selectshoushu();
	
	/**
	 * 根据id查询分类
	 * @param jianyanId
	 * @return
	 */
	@Query("select new com.ssh.vo.operation.ShouShuTypeVo(s.shoushuTypeId,s.shoushuTypeName) from ShoushuType s")
	public List<ShouShuTypeVo> SelectSugeryIdFl();
}
