package com.ssh.dao.jpa.doctor;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Bclass;
import com.ssh.vo.doctor.BanciVO;

public interface IBancDAO extends CrudRepository<Bclass, Long>{
	@Query("select new com.ssh.vo.doctor.BanciVO(b.bclassesId, b.bclassesBetTime,"
			+ " b.bclassesColor,b.bclassesName,b.bclassesType) from Bclass b order by b.id desc")
	public List<BanciVO> selectAll(Pageable pages);
	
	@Query("select nvl(max(b.id) + 1 , 1) from Bclass b")
	public long selectMaxId();
	
}
