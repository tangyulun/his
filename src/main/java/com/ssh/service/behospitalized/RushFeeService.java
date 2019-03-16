package com.ssh.service.behospitalized;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IRushFeeDAO;
import com.ssh.pojos.Bed;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.RushFee;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.BedVo;
import com.ssh.vo.behospitalized.DclassVo;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.behospitalized.MedicalCardVo;
import com.ssh.vo.behospitalized.OutpaitentRegistVo;
import com.ssh.vo.behospitalized.RushFeeVo;

@Service
@Transactional
public class RushFeeService {
	@Autowired
	private IRushFeeDAO rushfeedao;
	@Autowired
	private IHospitalRegistrationDAO hosdao;
	public String getNumber(){
		return rushfeedao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addRushFee(String state,RushFee rushFee,String hospitalRegistrationId){
		try {
			if (rushFee != null) {
				HospitalRegistration h = hosdao.findOne(hospitalRegistrationId);
				rushFee.setHospitalRegistration(h);
				System.err.println(state);
				rushFee.setRushFeeState(state);
				rushfeedao.save(rushFee);
			} 
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	
	public List<RushFeeVo> selectAllRushFee(int page, int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<RushFeeVo> list = rushfeedao.selectAllRushFee(pages);
		
		selectWaijian(list);
		return list;
	}
	
	public long count() {
		return rushfeedao.count();
	}
	
	private void selectWaijian(List<RushFeeVo> list){
		for (RushFeeVo r : list) {
			r.setHospitalRegistration(new HospitalRegistrationVo(rushfeedao.findOne(r.getRushFeeId()).getHospitalRegistration().getHospitalRegistrationId()));
			/*r.getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().setDclass(new DclassVo(rushfeedao.findOne(r.getRushFeeId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getDclass().getDclassId(),
					rushfeedao.findOne(r.getRushFeeId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getDclass().getDclassName()));
			r.getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().setMedicalCard(new MedicalCardVo(rushfeedao.findOne(r.getRushFeeId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getMedicalCard().getMedicalCardCardId(),
					rushfeedao.findOne(r.getRushFeeId()).getHospitalRegistration().getHospitaNotify().getOutpaitentRegist().getMedicalCard().getMedicalCardName()));*/
		}
	}
}
