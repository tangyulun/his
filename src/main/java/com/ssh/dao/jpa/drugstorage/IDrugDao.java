package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugType;
import com.ssh.vo.drugstorage.DrugVo;

public interface IDrugDao extends CrudRepository<Drug, String>{
	
	/**
	 * 分页查询所有药品
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugVo(d.drugId, d.drugBname, d.drugBz, d.drugBzdate,"
			+ " d.drugCf, d.drugGg, d.drugJx, d.drugLsprice, d.drugLx, d.drugName, d.drugPfprice, "
			+ "d.drugSccj, d.drugShr, d.drugYf, d.drugZt) from Drug d order by d.id desc")
	public List<DrugVo> findAllDrug(Pageable p);
	
	/**
	 * 自动生成id
	 * @param drugId
	 * @return
	 */
	@Query("select nvl(max(d.drugId)+1,10001) from Drug d")
	public String findDrugId();
	
	/**
	 * 根据药品分类查询药品信息
	 * @param dt
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugVo(d.drugId, d.drugBname, d.drugBz, d.drugBzdate,"
			+ " d.drugCf, d.drugGg, d.drugJx, d.drugLsprice, d.drugLx, d.drugName, d.drugPfprice, "
			+ "d.drugSccj, d.drugShr, d.drugYf, d.drugZt) from Drug d where d.drugType =?1 order by d.drugId desc")
	public List<DrugVo> findDrugByType(DrugType dt, Pageable p);
	
	/**
	 * 记录数量
	 * @param dt
	 * @return
	 */
	@Query("select count(d.drugId) from Drug d where d.drugType =?1")
	public long findDrugByTypeCount(DrugType dt);
	
	/**
	 * 模糊查询药品信息
	 * @param drugName
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.DrugVo(d.drugId, d.drugBname, d.drugBz, d.drugBzdate,"
			+ " d.drugCf, d.drugGg, d.drugJx, d.drugLsprice, d.drugLx, d.drugName, d.drugPfprice, "
			+ "d.drugSccj, d.drugShr, d.drugYf, d.drugZt) from Drug d where d.drugName like ?1 order by d.drugId desc")
	public List<DrugVo> mohufindDrugByName(String drugName, Pageable p);
	
	@Query("select count(d.drugId) from Drug d where d.drugName =?1")
	public long mohufindDrugByNameCount(String drugName);
	
	
	@Query("select new com.ssh.vo.drugstorage.DrugVo(d.drugId, d.drugBname, d.drugBz, d.drugBzdate,"
			+ " d.drugCf, d.drugGg, d.drugJx, d.drugLsprice, d.drugLx, d.drugName, d.drugPfprice, "
			+ "d.drugSccj, d.drugShr, d.drugYf, d.drugZt) from Drug d "
			+ " where d.yaokuKucun.yaokuKucunNum >0")
	public List<DrugVo> findAllDrugByKucun(Pageable p);

	@Query("select new com.ssh.vo.drugstorage.DrugVo(d.drugId, d.drugBname, d.drugBz, d.drugBzdate,"
			+ " d.drugCf, d.drugGg, d.drugJx, d.drugLsprice, d.drugLx, d.drugName, d.drugPfprice, "
			+ "d.drugSccj, d.drugShr, d.drugYf, d.drugZt) from Drug d "
			+ " where d.drugId like ?1 or d.drugName like ?2 order by d.id desc")
	public List<DrugVo> findAllDrugWhere(String key, String string, Pageable pageRequest);

	@Query("select count(d.id) from Drug d "
			+ " where d.drugId like ?1 or d.drugName like ?2 order by d.id desc")
	public long countWhere(String key, String string);
	
	
}
