package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Supplier;
import com.ssh.pojos.SupplierType;
import com.ssh.vo.drugstorage.SupplierVo;

public interface ISupplierDao extends CrudRepository<Supplier,String>{
	
	@Query("select new com.ssh.vo.drugstorage.SupplierVo(s.supplierId, s.supplierAddress, s.supplierBgdz,"
			+ " s.supplierBurman) from Supplier s")
	public List<SupplierVo> findAllSupplierVo();
	
	/**
	 * 分页查询所有供应商资料
	 * @param p
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.SupplierVo(sv.supplierId, sv.supplierAddress, sv.supplierBgdz, sv.supplierBurman,"
			+ " sv.supplierFkfs, sv.supplierGsxz, sv.supplierIssh, sv.supplierJc, sv.supplierJzfs, sv.supplierLxr, "
			+ "sv.supplierName, sv.supplierPd, sv.supplierPhone, sv.supplierShfs, sv.supplierSm) from Supplier sv")
	public List<SupplierVo> selectAllSupplierVo(Pageable p);
	
	/**
	 * 查询所有供应商
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.SupplierVo(sv.supplierId, sv.supplierAddress, sv.supplierBgdz, sv.supplierBurman,"
			+ " sv.supplierFkfs, sv.supplierGsxz, sv.supplierIssh, sv.supplierJc, sv.supplierJzfs, sv.supplierLxr, "
			+ "sv.supplierName, sv.supplierPd, sv.supplierPhone, sv.supplierShfs, sv.supplierSm) from Supplier sv")
	public List<SupplierVo> selectAllSupplierV();
	
	/**
	 * 根据供应商分类查询对应的供应商信息
	 * @param typeId
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.SupplierVo(sv.supplierId, sv.supplierAddress, sv.supplierBgdz, sv.supplierBurman,"
			+ " sv.supplierFkfs, sv.supplierGsxz, sv.supplierIssh, sv.supplierJc, sv.supplierJzfs, sv.supplierLxr, "
			+ "sv.supplierName, sv.supplierPd, sv.supplierPhone, sv.supplierShfs, sv.supplierSm)"
			+ " from Supplier sv where sv.supplierType =?1 order by sv.supplierId desc")
	public List<SupplierVo> selectSupplierByTypeId(SupplierType st, Pageable pageRequest);
	
	@Query("select count(s.supplierId) from Supplier s where s.supplierType =?1")
	public long findByTypeSupplierCount(SupplierType st);
	
	/**
	 * 根据供应商模糊查询供应商信息
	 * @param supplierName
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.SupplierVo(sv.supplierId, sv.supplierAddress, sv.supplierBgdz, sv.supplierBurman,"
			+ " sv.supplierFkfs, sv.supplierGsxz, sv.supplierIssh, sv.supplierJc, sv.supplierJzfs, sv.supplierLxr, "
			+ "sv.supplierName, sv.supplierPd, sv.supplierPhone, sv.supplierShfs, sv.supplierSm)"
			+ " from Supplier sv inner join sv.supplierType where sv.supplierName like ?1 order by sv.supplierId desc")
	public List<SupplierVo> mohuSupplierVo(String supplierName, Pageable pageRequest);
	
	@Query("select count(sv.supplierId) from Supplier sv where sv.supplierName like ?1")
	public long mohuSupplierCount(String supplierName);
	
	/**
	 * 自动生成id编号
	 * @param supplierId
	 * @return
	 */
	@Query("select nvl(max(sv.supplierId) + 1 , 10001) from Supplier sv")
	public String findId();
}
