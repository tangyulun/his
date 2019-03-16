package com.ssh.dao.jpa.doctor;

import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugType;
import com.ssh.vo.doctor.DrugChuFangVO;
import com.ssh.vo.drugstorage.DrugTypeVo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DrugChuFnag extends CrudRepository<Drug, String>{
	
	@Query("select new com.ssh.vo.doctor.DrugChuFangVO(d.drugId,d.drugName, d.drugLsprice)"
			+ " from Drug d where d.yaokuKucun.yaofangKaiyaoShengyuNum > 0")
	public List<DrugChuFangVO> selectAllDrug(Pageable page);

	@Query("select new com.ssh.vo.doctor.DrugChuFangVO(d.drugId,d.drugName, d.drugLsprice) from Drug d where d.drugType=?1 and d.yaokuKucun.yaofangKaiyaoShengyuNum > 0 order by d.id desc")
	public List<DrugChuFangVO> queryDrugFingByTypeId(Pageable pages, DrugType drugTypeId);
	
	@Query("select count(d.id) from Drug d where d.drugType=?1 and d.yaokuKucun.yaofangKaiyaoShengyuNum > 0 order by d.id desc")
	public long queryDrugCounts(DrugType drugTypeId);
}
