package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugType;
import com.ssh.vo.drugstorage.DrugTypeVo;

public interface IDrugTypeDao extends CrudRepository<DrugType, Long>{
	
	/**
	 * 查询商品分类中最大的ID
	 * @return
	 */
	@Query("select nvl(max(dt.drugTypeId)+1,1) from DrugType dt")
	public long selectMaxId();
	
	/**
	 * 查询所有药品分类
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugTypeVo(dt.drugTypeId, dt.drugTypeName) from DrugType dt")
	public List<DrugTypeVo> selectDrugTypeName();
	
	/**
	 * 查询药品分类中是否有相同的分类名称
	 * @param drugTypeName
	 * @return
	 */
	@Query("select dt from DrugType dt where dt.drugTypeName =?1")
	public DrugType selectName(String drugTypeName);

	@Query("select new com.ssh.vo.drugstorage.DrugTypeVo(d.drugTypeId , d.drugTypeName) from DrugType d"
			+ " inner join d.drugs dd where dd=?1")
	public DrugTypeVo selectTypeName(Drug findOne);
}
