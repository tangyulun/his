package com.ssh.dao.jpa.behospitalized;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.BedTypeType;
import com.ssh.vo.behospitalized.BedTypeTypeVo;
import com.ssh.vo.staff.EmpVO;

public interface IBedTypeTypeDAO extends CrudRepository<BedTypeType, Long>{
	
	@Query("select new com.ssh.vo.behospitalized.BedTypeTypeVo(b.bedTypeTypeId,b.bedTypeTypeName) from BedTypeType b")
	public List<BedTypeTypeVo> selectBed();
	
	@Query("select nvl(max(b.bedTypeTypeId) + 1 , 1) from BedTypeType b")
	public long selectIdMax();
	
}
