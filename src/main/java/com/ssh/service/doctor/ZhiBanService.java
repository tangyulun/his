package com.ssh.service.doctor;

import com.ssh.dao.jpa.doctor.IZhiBanDAO;
import com.ssh.pojos.BeOnDutyPlan;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.BeOnDutyPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ZhiBanService {

	@Autowired
	private IZhiBanDAO IZDAO;
	
	/**
	 * 查找最大值
	 */
	public String selectMaxId(Date date){
		String sId = IZDAO.selectMaxId(new SimpleDateFormat("yyyy").format(date));
		if("1".equals(sId)){
			return new SimpleDateFormat("yyyy").format(date) + "01";
		}
		return sId;
	}
	
	/**
	 * 添加排班计划
	 */
	public Errors insertPaiBanPlan(BeOnDutyPlan be , String mess){
		try {
			//先查询该日期是否已经排班
			BeOnDutyPlan b = IZDAO.findByBeOnDutyPlanStartDate(be.getBeOnDutyPlanStartDate());
			if(b != null){

				return new Errors(b.getBeOnDutyPlanId());
			}else{
				be.setBeOnDutyPlanId(selectMaxId(be.getBeOnDutyPlanStartDate()));
				be.setBeOnDutyPlanDate(be.getBeOnDutyPlanDate());
				byte by [] = mess.getBytes();
				be.setBeOnDutyPlanMessage(by);
				IZDAO.save(be);
				return new Errors(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	//修改
	/**
	 * 查询
	 */
	public List<BeOnDutyPlanVO> selectAll(){
		List<BeOnDutyPlanVO> list =  IZDAO.selectAll();
		for (BeOnDutyPlanVO b : list) {
			String res = new String(b.getBeOnDutyPlanMessage());
			b.setTableMess(res);
		}
		return list;
	}

	public Errors updatePaiBanMessage(String planId, String planMessage) {
		try {
			BeOnDutyPlan plan = IZDAO.findOne(planId);
			plan.setBeOnDutyPlanMessage(planMessage.getBytes());
			return new Errors(true);
		} catch (Exception e) {
			return new Errors(e.getMessage());
		}
		
	}
	
	/**
	 * 查询
	 */
	public List<BeOnDutyPlanVO> selectAllUpdateCopy(){
		List<BeOnDutyPlanVO> list =  IZDAO.selectAll();
		for (BeOnDutyPlanVO b : list) {
			String res = new String(b.getBeOnDutyPlanMessage());
			b.setTableMess(res);
			b.setDateBetween(b.getBeOnDutyPlanId()+" ("+new SimpleDateFormat("MMdd").format(b.getBeOnDutyPlanStartDate() )+"~"+
					new SimpleDateFormat("MMdd").format(b.getBeOnDutyPlanEndDate())+")");
		}
		return list;
	}

	public Errors selectTodayId(String week) {
		List<BeOnDutyPlanVO> list =  IZDAO.selectAll();
		for (BeOnDutyPlanVO b : list) {
			if(week.equals(new SimpleDateFormat("yyyy-MM-dd").format(b.getBeOnDutyPlanStartDate()))){
				return new Errors(true, b.getBeOnDutyPlanId());
			}
		}
		return new Errors(false);
	}
}
