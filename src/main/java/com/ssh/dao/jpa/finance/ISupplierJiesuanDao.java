package com.ssh.dao.jpa.finance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.SupplierJiesuan;
import com.ssh.vo.drugstorage.AcceptanceVo;

public interface ISupplierJiesuanDao extends CrudRepository<SupplierJiesuan, String>{

	@Query("select max(s.supplierJiesuanId) from SupplierJiesuan s where s.supplierJiesuanId like ?1")
	public String sNumber(String datelike);
	
}
