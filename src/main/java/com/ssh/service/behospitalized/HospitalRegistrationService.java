package com.ssh.service.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedDAO;
import com.ssh.dao.jpa.behospitalized.IHospitaNotifyDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Bed;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedVo;
import com.ssh.vo.behospitalized.DclassVo;
import com.ssh.vo.behospitalized.EmpVo;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.behospitalized.MedicalCardVo;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;

@Service
@Transactional
public class HospitalRegistrationService {
	@Autowired
	private IHospitalRegistrationDAO hospitalregistrationdao;
	
	@Autowired
	private IBedDAO beddao;
	
	@Autowired
	private IEmpDAO empdao;
	
	@Autowired 
	private IHospitaNotifyDAO ihostnotifydao;
	
	public String getNumber(){
		return hospitalregistrationdao.getNumber(CommentOrder.dateLike());
	}

	public Errors addHospitalRegistration(String state,HospitalRegistration hospitalRegistration,String bedId,Long empId,String hospitalNotifyNumber){
		try {
			Bed bed = beddao.findOne(bedId);
			Emp emp = empdao.findOne(empId);
			bed.setHouseState("已占用");
			HospitaNotify hospitaNotify = ihostnotifydao.findOne(hospitalNotifyNumber);
			hospitaNotify.setHospitalNotifyState("已登记");
			hospitalRegistration.setBed(bed);
			hospitalRegistration.setHospitalRegistrationState("已登记");
			hospitalRegistration.setEmp(emp);
			hospitalRegistration.setHospitaNotify(hospitaNotify);
			hospitalregistrationdao.save(hospitalRegistration);
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
				
	}
	
	public List<HospitalRegistrationVo> selectAllHospitalRegistration(int page, int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<HospitalRegistrationVo> list = hospitalregistrationdao.selectAllHospitalRegistration(pages);
		selectWaijian(list);
		return list;
	}
	
	public long count() {
		return hospitalregistrationdao.count();
	}
	
	private void selectWaijian(List<HospitalRegistrationVo> list){
		for (HospitalRegistrationVo h : list) {
			HospitalRegistration ho = hospitalregistrationdao.findOne(h.getHospitalRegistrationId());
			HospitaNotify hv = ho.getHospitaNotify();
			HospitaNotifyVo hn = new HospitaNotifyVo();
			OutpaitentRegistVo ov = new OutpaitentRegistVo();
			ov.setOutpaitentRegistId(hv.getOutpaitentRegist().getOutpaitentRegistId());
			ov.setDclass(new DclassVo(hv.getOutpaitentRegist().getDclass().getDclassId(), hv.getOutpaitentRegist().getDclass().getDclassName()));
			ov.setMedicalCard(new MedicalCardVo(hv.getOutpaitentRegist().getMedicalCard().getMedicalCardCardId(), hv.getOutpaitentRegist().getMedicalCard().getMedicalCardName(),
					hv.getOutpaitentRegist().getMedicalCard().getMedicalCardAge(),hv.getOutpaitentRegist().getMedicalCard().getMedicalCardSex()));
			ov.setEmp(new EmpVo(hv.getOutpaitentRegist().getEmp().getEmpId(),hv.getOutpaitentRegist().getEmp().getEmpName()));
			hn.setOutpaitentRegist(ov);
			hn.setHospitalNotifyNumber(hv.getHospitalNotifyNumber());
			hn.setHospitalNotifyCashFeiyong(hv.getHospitalNotifyCashFeiyong());
			hn.setHospitalNotifyCashYanjin(hv.getHospitalNotifyCashYanjin());
			hn.setHospitalNotifyAlertTheJine(hv.getHospitalNotifyAlertTheJine());
			hn.setHospitalNotifyCost(hv.getHospitalNotifyCost());
			ho.setHospitaNotify(hv);
			h.setHospitaNotify(hn);
			Bed bed = ho.getBed();
			if(bed != null){
				h.setBed(new BedVo(bed.getBedId(), bed.getBedName()));
			}
			
		}
	}
}
