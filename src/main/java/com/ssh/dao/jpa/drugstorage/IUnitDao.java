package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Unit;
import com.ssh.vo.drugstorage.UnitVo;

public interface IUnitDao extends CrudRepository<Unit,Long>{
	
	/**
	 * 查询药品表中最大的id
	 * @return
	 */
	@Query("select nvl(max(u.unitsId)+1,1) from Unit u")
	public long maxId();
	
	/**
	 * 查询药品单位中是否有相同的名称
	 * @param unitsName
	 * @return
	 */
	@Query("select u from Unit u where u.unitsName =?1")
	public Unit selectName(String unitsName);
	
	/**
	 * 查询所有药品单位
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.UnitVo(u.unitsId, u.unitsName) from Unit u")
	public List<UnitVo> selectAllUnit(); 
}
