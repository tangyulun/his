package com.ssh.dao.jpa.doctor;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ssh.pojos.BeOnDutyPlan;
import com.ssh.vo.doctor.BeOnDutyPlanVO;

public interface IZhiBanDAO extends CrudRepository<BeOnDutyPlan, String>{
	@Query("select nvl(max(b.id) + 1 , 1) from BeOnDutyPlan b where to_char(b.beOnDutyPlanStartDate , 'yyyy') =?1")
	public String selectMaxId(String year);
	
	public BeOnDutyPlan findByBeOnDutyPlanStartDate(Date beOnDutyPlanStartDate);
	
	@Query("select new  com.ssh.vo.doctor.BeOnDutyPlanVO(b.beOnDutyPlanId, b.beOnDutyPlanDate,"
	  + "b.beOnDutyPlanEndDate,b.beOnDutyPlanMessage, b.beOnDutyPlanStartDate, b.beOnDutyPlanType)"
	  + " from BeOnDutyPlan b")
	public List<BeOnDutyPlanVO> selectAll();
}
