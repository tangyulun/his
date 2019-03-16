package com.ssh.dao.mybatis.dean;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.drugstorage.DrugVo;

public interface IMyDrugDAO {

	List<DrugVo> selectAllDrugDeanGradeWhere(
            @Param("key") String key,
            @Param("type") String type,
            @Param("ku") String ku,
            @Param("fang") String fang);

}
