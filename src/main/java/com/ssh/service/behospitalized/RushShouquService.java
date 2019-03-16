package com.ssh.service.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitaNotifyDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IRushShouquDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.RushShouqu;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;

@Service
@Transactional
public class RushShouquService {
	@Autowired
	private IRushShouquDAO shouqudao;
	@Autowired
	private IEmpDAO empdao;
	@Autowired
	private IHospitalRegistrationDAO regisdao;
	@Autowired
	private IHospitaNotifyDAO notifydao;
	
	
	public String getNumber(){
		return shouqudao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addRushShouqu(String state,RushShouqu rushShouqu,Long empId,String hospitalRegistrationId,String hospitalNotifyNumber){
		try {
			if (rushShouqu != null) {
				RushShouqu r = shouqudao.findOne(rushShouqu.getRushShouquId());
				if (r != null) {
					r.setRushShouquState(state);
					System.err.println("111111111111111111111111111111111");
				} else {
					Emp emp = empdao.findOne(empId);
					HospitalRegistration hospitalRegistration = regisdao.findOne(hospitalRegistrationId);
					HospitaNotify hospitaNotify = notifydao.findOne(hospitalNotifyNumber);
					rushShouqu.setEmp(emp);
					rushShouqu.setHospitalRegistration(hospitalRegistration);
					rushShouqu.setHospitaNotify(hospitaNotify);
					rushShouqu.setRushShouquState(state);
					
					shouqudao.save(rushShouqu);

				}
			} 
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
		
		
	}

	public HospitalRegistrationVo selectZhiYuanDengji(String number) {
		HospitaNotify  h = notifydao.findOne(number);
		try {
			System.err.println(number);
			System.err.println(h.getHospitalRegistrations());
			if(h.getHospitalRegistrations().isEmpty()){
				return null; 
			}
		} catch (Exception e) {
			return null;
		}
		return new HospitalRegistrationVo(h.getHospitalRegistrations().get(0).getHospitalRegistrationId());
	}
}
