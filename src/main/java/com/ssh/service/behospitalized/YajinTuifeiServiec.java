package com.ssh.service.behospitalized;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IChuyuanInformDAO;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IYajinTuifeiDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Bed;
import com.ssh.pojos.ChuyuanInform;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitaNotify;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.RushShouqu;
import com.ssh.pojos.YajinTuifei;
import com.ssh.pojos.ZhuyuanJiezhang;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.RushShouquVo;
import com.ssh.vo.behospitalized.ZhuyuanJiezhangVo;

@Service
@Transactional
public class YajinTuifeiServiec {
	@Autowired
	private IYajinTuifeiDAO yajindao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	@Autowired
	private IEmpDAO empdao;
	@Autowired
	private IChuyuanInformDAO chuyuandao;
	

	public String getNumber(){
		return yajindao.getNumber(CommentOrder.dateLike());
	}
	/*public List<RushShouquVo> selectrushShouquYushouMoney(String number){
		HospitalRegistration h = registdao.findOne(number);
		try {
			if (h.getRushShouqus().isEmpty()) {
				System.err.println(number);
				System.err.println(h.getRushShouqus());
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		List<RushShouquVo> list = new ArrayList<>();
		for (RushShouqu r : h.getRushShouqus()) {
			
			list.add(new RushShouquVo(r.getRushShouquYushouMoney()));
		}
		//return new RushShouquVo(h.getRushShouqus().get(0).getRushShouquYushouMoney());
		return list;
	}*/
	public List<ZhuyuanJiezhangVo> selectZhuyuanJiezhang(String number){
		HospitalRegistration h = registdao.findOne(number);
		try {
			if (h.getZhuyuanJiezhangs().isEmpty()) {
				System.err.println(h.getZhiliaoJizhangs());
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		List<ZhuyuanJiezhangVo> list = new ArrayList<>();
		for (ZhuyuanJiezhang z : h.getZhuyuanJiezhangs()) {
			list.add(new ZhuyuanJiezhangVo(z.getZhuyuanJiezhangZmoney()));
		}
		return list;
		//return new ZhuyuanJiezhangVo(h.getZhuyuanJiezhangs().get(0).getZhuyuanJiezhangZmoney());
	}

	public Errors addYajinTuifei(String state,YajinTuifei yajinTuifei,Long empId,String chuyuanInformId){
		try {
			if (yajinTuifei !=null) {
				YajinTuifei y =yajindao.findOne(yajinTuifei.getYajinTuifeiId());
				if (y!=null) {
					y.setYajinTuifeiState(state);
				}else {
					Emp emp = empdao.findOne(empId);
					ChuyuanInform chuyuanInform = chuyuandao.findOne(chuyuanInformId);
					yajinTuifei.setEmp(emp);
					yajinTuifei.setChuyuanInform(chuyuanInform);
					yajinTuifei.setYajinTuifeiState(state);
					yajindao.save(yajinTuifei);
				}
			}
			return new Errors(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
}
