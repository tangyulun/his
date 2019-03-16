package com.ssh.dao.jpa.dean;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugYaofangXq;
import com.ssh.vo.dean.DrugHairXqVo;

public interface MengzhengFayaoXqDao extends CrudRepository<DrugYaofangXq, Long>{

	@Query("select new com.ssh.vo.dean.DrugHairXqVo"
			+ "(dxq.drugYaofangXqId, dxq.drugYaofangXqMoney, dxq.drugYaofangXqNumber, "
			+ "dxq.drugYaofangXqPh, dxq.drugYaofangXqPrice, dxq.drugYaofangXqRemark, dxq.drugYaofangXqState) "
			+ "from DrugYaofangXq dxq inner join dxq.drugYaofang fy where fy.drugYaofangId =?1")
	public List<DrugHairXqVo> selectXqById(String drugYaofangId);
}
