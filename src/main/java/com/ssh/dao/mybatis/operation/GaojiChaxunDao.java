package com.ssh.dao.mybatis.operation;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.JianyanMess;
import com.ssh.vo.operation.JianyanMessVo;

public interface GaojiChaxunDao extends CrudRepository<JianyanMess, String>{
		public List<JianyanMessVo> selectMessShijian(@Param("oneTime") Date oneTime,
                                                     @Param("trueTime") Date trueTime,
                                                     @Param("jianyanMessId") String jianyanMessId);
}
