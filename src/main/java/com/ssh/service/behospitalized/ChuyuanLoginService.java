package com.ssh.service.behospitalized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IBedDAO;
import com.ssh.dao.jpa.behospitalized.IChuyuanInformDAO;
import com.ssh.dao.jpa.behospitalized.IChuyuanLoginDAO;
import com.ssh.dao.jpa.behospitalized.IHospitaNotifyDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.pojos.ChuyuanInform;
import com.ssh.pojos.ChuyuanLogin;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.ChuyuanInformVo;

@Service
@Transactional
public class ChuyuanLoginService {
	@Autowired
	private IChuyuanLoginDAO chuyuanlogindao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	@Autowired
	private IChuyuanInformDAO chuyuaninformdao;
	@Autowired
	private IBedDAO beddao;
	@Autowired
	private IHospitaNotifyDAO notifydao;
	
	
	public String getNumber(){
		return chuyuanlogindao.getNumber(CommentOrder.dateLike());
	}
	
	public ChuyuanInformVo selectChuYuanTongzhi(String number){
		HospitalRegistration h = registdao.findOne(number);
		try {
			System.err.println(number);
			System.err.println(h.getChuyuanInforms());
			if (h.getChuyuanInforms().isEmpty()) {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return new ChuyuanInformVo(h.getChuyuanInforms().get(0).getChuyuanInformId(),
				h.getChuyuanInforms().get(0).getChuyuanInformFeiyongZmoney(),
				h.getChuyuanInforms().get(0).getChuyuanInformYajinZmoney());
	}
	
	public Errors addChuyuanLogin(String state , ChuyuanLogin chuyuanLogin,String chuyuanInformId){
		try {
			if (chuyuanLogin !=null) {
				ChuyuanLogin c = chuyuanlogindao.findOne(chuyuanLogin.getChuyuanLoginId());
				if (c !=null) {
					c.setChuyuanLoginState(state);
				}else {
					ChuyuanInform chuyuanInform  = chuyuaninformdao.findOne(chuyuanInformId);
					chuyuanLogin.setChuyuanLoginState(state);
					chuyuanLogin.setChuyuanInform(chuyuanInform);
					
					String bedid=chuyuanLogin.getChuyuanInform().getHospitalRegistration().getBed().getBedId();
					beddao.findOne(bedid).setHouseState("未占用");
					String hospitalRegistrationId =chuyuanLogin.getChuyuanInform().getHospitalRegistration().getHospitalRegistrationId();
					registdao.findOne(hospitalRegistrationId).setHospitalRegistrationState("已出院");
					String hospitalNotifyNumber =chuyuanLogin.getChuyuanInform().getHospitalRegistration().getHospitaNotify().getHospitalNotifyNumber();
					notifydao.findOne(hospitalNotifyNumber).setHospitalNotifyState("已出院");
					System.err.println(hospitalNotifyNumber);
					chuyuanlogindao.save(chuyuanLogin);
				}
			}
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
}
