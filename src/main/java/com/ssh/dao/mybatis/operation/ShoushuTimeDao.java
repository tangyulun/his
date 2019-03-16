package com.ssh.dao.mybatis.operation;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.ShoushuMess;
import com.ssh.vo.operation.ShouShuMessVo;

public interface ShoushuTimeDao{
	public List<ShouShuMessVo> selectMessShijiana(@Param("aTime") Date aTime,
                                                  @Param("bTime") Date bTime,
                                                  @Param("shoushuMess") String shoushuMess);
			
}
