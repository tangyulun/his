package com.ssh.dao.mybatis.outpatient;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssh.vo.outpatient.OutRegistVo;


public interface IOutPatientRegistDao {

	public List<OutRegistVo> selectOutRegistAndTime(@Param("registSearcher") String registSearcher,
                                                    @Param("registType") String registType,
                                                    @Param("registStartTime") Date registStartTime,
                                                    @Param("registEndTime") Date registEndTime);

	
	public List<OutRegistVo> selectDataGridRegistAndTime(@Param("registdataStartTime") Date registdataStartTime,
                                                         @Param("registdataEndTime") Date registdataEndTime,
                                                         @Param("registdataSearcher") String registdataSearcher);


	public List<OutRegistVo> selectRegistCode(@Param("outregistqkSearchbox") String outregistqkSearchbox,
                                              @Param("outregistqkStartTime") Date outregistqkStartTime,
                                              @Param("outregistqkEndTime") Date outregistqkEndTime,
                                              @Param("outregistqkztCombobox") String outregistqkztCombobox);
}
