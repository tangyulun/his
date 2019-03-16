package com.ssh.dao.jpa.dean;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanFayaoXq;
import com.ssh.vo.dean.DrugHairXqVo;

public interface IZhuyuanFayaoXqDao extends CrudRepository<ZhuyuanFayaoXq, Long>{

	@Query("select new com.ssh.vo.dean.DrugHairXqVo"
			+ "(zxq.zhuyuanFayaoXqId, zxq.zhuyuanFayaoXqMoney, zxq.zhuyuanFayaoXqNumber, "
			+ "zxq.zhuyuanFayaoXqPh, zxq.zhuyuanFayaoXqPrice, zxq.zhuyuanFayaoXqRemark, zxq.zhuyuanFayaoXqState) "
			+ "from ZhuyuanFayaoXq zxq inner join zxq.zhuyuanFayao fy "
			+ "where fy.zhuyuanFayaoId =?1")
	public List<DrugHairXqVo> selectXqById(String drugYaofangId);
	
}
