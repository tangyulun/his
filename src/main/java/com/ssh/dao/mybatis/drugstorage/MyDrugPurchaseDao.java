package com.ssh.dao.mybatis.drugstorage;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugPurchase;
import com.ssh.vo.drugstorage.DrugPurchaseVo;

public interface MyDrugPurchaseDao extends CrudRepository<DrugPurchase, String>{
	
	public List<DrugPurchaseVo> startDateEndDate(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("drugPurchaseId") String drugPurchaseId
    );
}
