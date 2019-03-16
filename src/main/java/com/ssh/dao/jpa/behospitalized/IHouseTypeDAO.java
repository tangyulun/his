package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.HouseType;
import com.ssh.vo.behospitalized.BedTypeTypeVo;
import com.ssh.vo.behospitalized.HouseTypeVo;

public interface IHouseTypeDAO extends CrudRepository<HouseType, Long> {	
	@Query("select nvl(max(h.houseTypeId) + 1 , 1) from HouseType h")
	public long selectIdMax();
	
	@Query("select new com.ssh.vo.behospitalized.HouseTypeVo(h.houseTypeId,h.houseTypeName) from HouseType h")
	public List<HouseTypeVo> selectHouse();
}
