package com.ssh.service.behospitalized;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IHospitaNotifyDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IOutpaitentRegistDAO;
import com.ssh.dao.mybatis.behospitalized.IMyHospitaNotifyDAO;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.QxReturnqx;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.DclassVo;
import com.ssh.vo.behospitalized.EmpVo;
import com.ssh.vo.behospitalized.HHQixeVo;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.MedicalCardVo;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;

@Service
@Transactional
public class HospitaNotifyService {
	@Autowired
	private IHospitaNotifyDAO hospitanotitifydao;
	
	@Autowired
	private IOutpaitentRegistDAO outpaitendao;
	
	@Autowired
	private IMyHospitaNotifyDAO mybatisNotifydao;
	
	@Autowired
	private IHospitalRegistrationDAO registdao;
	
	public String getNumber(){
		return hospitanotitifydao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addHospitaNotify(String state, HospitaNotify hospitaNotify,String outpaitentRegistId){
		try {
			if(hospitaNotify != null){
				HospitaNotify h = hospitanotitifydao.findOne(hospitaNotify.getHospitalNotifyNumber());
				if(h != null){ 
					h.setHospitalNotifyState(state);
				}else{
					OutpaitentRegist out = outpaitendao.findOne(outpaitentRegistId);
					hospitaNotify.setOutpaitentRegist(out);
					hospitaNotify.setHospitalNotifyState(state);
					hospitanotitifydao.save(hospitaNotify);
				}
				
				
			}
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	
	public List<HospitaNotifyVo> selectAllHospitaNotify(int page , int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<HospitaNotifyVo> list = hospitanotitifydao.selectAllHospitaNotify(pages);
		selectOutpaitentRegist(list);
		return list;		
	}
	public long count() {
		return hospitanotitifydao.count();
	}
	
	public List<HospitaNotifyVo> selectHospitaNotifyWhere(int page , int rows, String hospitalNotifyNumber){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<HospitaNotifyVo> list = hospitanotitifydao.selectHospitaNotify(pages, "%" + hospitalNotifyNumber + "%");
		selectOutpaitentRegist(list);
		return list;
	}
	
	public long selectHospitalNotifyWhereCount(String hospitalNotifyNumber){
		return hospitanotitifydao.findHospitalNotifyNumber("%" + hospitalNotifyNumber + "%");
	}
	
	Page<?> pages ;
	public List<HospitaNotifyVo> selectHosStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String hospitalNotifyNumber){
		pages = PageHelper.startPage(page , rows);
		List<HospitaNotifyVo> list =  mybatisNotifydao.selectHosStartDateToEndDate(startTime, endTime, "".equals(hospitalNotifyNumber) ? null : "%"+ hospitalNotifyNumber + "%");
		selectOutpaitentRegist(list);
		return list;
	}

	public long queryStartEndcount() {
		return pages.getTotal();
	}
	
	private void selectOutpaitentRegist(List<HospitaNotifyVo> list) {
		for (HospitaNotifyVo h : list) {
			h.setOutpaitentRegist(new OutpaitentRegistVo(hospitanotitifydao.findOne(h.getHospitalNotifyNumber()).getOutpaitentRegist().getOutpaitentRegistId()));
			h.getOutpaitentRegist().setDclass(new DclassVo(hospitanotitifydao.findOne(h.getHospitalNotifyNumber()).getOutpaitentRegist().getDclass().getDclassId(),
					hospitanotitifydao.findOne(h.getHospitalNotifyNumber()).getOutpaitentRegist().getDclass().getDclassName()));
			h.getOutpaitentRegist().setMedicalCard(new MedicalCardVo(hospitanotitifydao.findOne(h.getHospitalNotifyNumber()).getOutpaitentRegist().getMedicalCard().getMedicalCardCardId(),
					hospitanotitifydao.findOne(h.getHospitalNotifyNumber()).getOutpaitentRegist().getMedicalCard().getMedicalCardName()));
			
		}
	}
	
}
