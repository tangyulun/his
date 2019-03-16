package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.BedType;
import com.ssh.pojos.BedTypeType;
import com.ssh.vo.behospitalized.BedTypeVo;

public interface IBedTypeDAO extends CrudRepository<BedType, Long> {
	
	@Query("select nvl(max(b.bedTypeId) + 1 , 1) from BedType b")
	public long selectIdMax();
	/**
	 * 查询子类
	 * @param bedtt
	 * @return
	 */
	@Query("select new com.ssh.vo.behospitalized.BedTypeVo(b.bedTypeId , b.bedTypeName) from BedType b where b.bedTypeType=?1")
	public List<BedTypeVo> findByChildren(BedTypeType bedtt);
	/**
	 * 查询bedTypeName是否存在
	 * @param BedTypeName
	 * @return
	 */
	@Query("select b from BedType b where b.bedTypeName=?1")
	public BedType regexBedTypeName(String BedTypeName);
	
}
