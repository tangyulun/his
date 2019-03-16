package com.ssh.dao.jpa.drugstorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.Supplier;
import com.ssh.pojos.SupplierType;
import com.ssh.service.drugstorage.SupplierService;
import com.ssh.vo.drugstorage.SupplierTypeVo;

public interface ISupplierTypeDao extends CrudRepository<SupplierType,Long>{
	@Query("select new com.ssh.vo.drugstorage.SupplierTypeVo(s.supplierTypeId,s.supplierTypeName) from SupplierType s inner join s.suppliers su where su=?1")
	public SupplierTypeVo findAllSupplier(Supplier s);
	
	/**
	 * 查询供应商分类中最大的id值
	 * @return
	 */
	@Query("select nvl(max(st.supplierTypeId)+1,1) from SupplierType st")
	public long selectSupplierId();
	
	/**
	 * 查询供应商分类
	 * @return
	 */
	@Query("select new com.ssh.vo.drugstorage.SupplierTypeVo(st.supplierTypeId,st.supplierTypeName) from SupplierType st")
	public List<SupplierTypeVo> findAllSupplierType();
	
	/**
	 * 查询是否有相同的分类名称
	 * @param supplierTypeName
	 * @return
	 */
	@Query("select st from SupplierType st where st.supplierTypeName=?1")
	public SupplierType findSupplierTypeName(String SName);
}
