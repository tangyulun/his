package com.ssh.service.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IChuyuanInformDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.ChuyuanInform;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;

@Service
@Transactional
public class ChuyuanInformService {
	@Autowired
	private IChuyuanInformDAO chuyuaninformdao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	@Autowired
	private IEmpDAO empdao;
	
	public String getNumber(){
		return chuyuaninformdao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addChuyuanInform(String state,ChuyuanInform chuyuanInform,String hospitalRegistrationId,Long empId){
		try {
			if (chuyuanInform !=null) {
				ChuyuanInform c = chuyuaninformdao.findOne(chuyuanInform.getChuyuanInformId());
				if (c !=null) {
					c.setChuyuanInformState(state);
				}else {
					HospitalRegistration hospitalRegistration = registdao.findOne(hospitalRegistrationId);
					Emp emp = empdao.findOne(empId);
					chuyuanInform.setEmp(emp);
					chuyuanInform.setHospitalRegistration(hospitalRegistration);
					chuyuanInform.setChuyuanInformState(state);
					chuyuaninformdao.save(chuyuanInform);
				}
			}
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
}
