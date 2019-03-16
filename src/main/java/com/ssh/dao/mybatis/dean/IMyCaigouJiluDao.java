package com.ssh.dao.mybatis.dean;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.DrugPurchase;
import com.ssh.vo.drugstorage.DrugPurchaseVo;

public interface IMyCaigouJiluDao{
	public List<DrugPurchaseVo> mohufind(
            @Param("startTime") Date startTime,
            @Param("endTime") Date endTime,
            @Param("drugPurchaseId") String drugPurchaseId,
            @Param("drugPurchaseZt") String drugPurchaseZt
    );
}
