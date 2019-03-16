package com.ssh.service.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedDAO;
import com.ssh.dao.jpa.behospitalized.IBedsToAdjustDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Bed;
import com.ssh.pojos.BedTiaozheng;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Service
@Transactional
public class BedsToAdjustService {
	@Autowired
	private IBedsToAdjustDAO bedstoadjustdao;
	
	@Autowired
	private IBedDAO beddao;
	
	@Autowired
	private IEmpDAO empdao;
	
	@Autowired
	private IHospitalRegistrationDAO hosdao;
	
	public String getNumber(){
		return bedstoadjustdao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addBedTiaozheng(BedTiaozheng bedTiaozheng, String bedId, Long empId,String hospitalRegistrationId){
		try {
			if (bedTiaozheng != null) {
				Bed bedX = beddao.findOne(bedId);
				Emp emp = empdao.findOne(empId);
				HospitalRegistration hospitalRegistration = hosdao.findOne(hospitalRegistrationId);
				bedTiaozheng.setBed(bedX);
				bedTiaozheng.setEmp1(emp);
				bedTiaozheng.setHospitalRegistration(hospitalRegistration);
				bedTiaozheng.setBedTiaozhengState("已处理");
				Bed bedY = beddao.findOne(hospitalRegistration.getBed().getBedId());
				bedY.setHouseState("未占用");
				hospitalRegistration.setBed(bedX);
				bedX.setHouseState("已占用");
				bedstoadjustdao.save(bedTiaozheng);
			} 
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	
	
}
