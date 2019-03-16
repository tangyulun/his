package com.ssh.dao.jpa.dean;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ZhuyuanFayao;
import com.ssh.vo.dean.DrugHairVo;

public interface IZhuyuanFayaoDao extends CrudRepository<ZhuyuanFayao, String>{

	@Query("select fy from ZhuyuanFayao fy")
	public List<ZhuyuanFayao> selectZhuyuanFayao();
	
	@Query("select fy from ZhuyuanFayao fy where fy.zhuyuanFayaoId like ?1")
	public List<ZhuyuanFayao> mohufind(String drugYaofangId);
}
