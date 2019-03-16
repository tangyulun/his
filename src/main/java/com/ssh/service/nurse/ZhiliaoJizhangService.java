package com.ssh.service.nurse;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.nurse.IPrescriptionDAO;
import com.ssh.dao.jpa.nurse.IZhiliaoJizhangDAO;
import com.ssh.dao.jpa.nurse.IZhiliaoJizhangXqDAO;
import com.ssh.dao.jpa.outpatient.IFinancialDao;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Financial;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.ZhiliaoJizhang;
import com.ssh.pojos.ZhiliaoJizhangXq;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.nurse.ZhuyuanZhiliaojizhangVo;

@Service
@Transactional
public class ZhiliaoJizhangService {
	@Autowired
	private IZhiliaoJizhangDAO zhiliaojizhangdao;
	@Autowired
	private IEmpDAO empdao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	@Autowired
	private IZhiliaoJizhangXqDAO zhiliaoxqdao;
	@Autowired
	private IFinancialDao financialdao;
	@Autowired
	private IPrescriptionDAO prescdao;
	
	private List<ZhuyuanZhiliaojizhangVo> list = new ArrayList<>();
	
	public String getNumber(){
		return zhiliaojizhangdao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addZhiliaoJizhang(String state,ZhiliaoJizhang zhiliaoJizhang ,Long empId,String hospitalRegistrationId){
		try {
			if (zhiliaoJizhang !=null) {
				ZhiliaoJizhang z = zhiliaojizhangdao.findOne(zhiliaoJizhang.getZhiliaoJizhangId());
				if (z !=null) {
					z.setZhiliaoJizhangState(state);
					
				}else {
					Emp emp = empdao.findOne(empId);
					HospitalRegistration hospitalRegistration = registdao.findOne(hospitalRegistrationId);
					zhiliaoJizhang.setZhiliaoJizhangState(state);
					zhiliaoJizhang.setEmp(emp);
					zhiliaoJizhang.setHospitalRegistration(hospitalRegistration);
					zhiliaojizhangdao.save(zhiliaoJizhang);
							
				}
			}
			addZhiliaoJizhangXq(zhiliaoJizhang);
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	public void addZhuyuanZhiliaojizhang(String financialId,String financialName,BigDecimal number,BigDecimal money,String state,String chufanhao,String shoufeileixing){
		ZhuyuanZhiliaojizhangVo zhiliao= new ZhuyuanZhiliaojizhangVo(list.size()+1,financialId,financialName,number,money,"未",chufanhao,shoufeileixing);
		System.err.println(zhiliao.toString());
		list.add(zhiliao);
	}
	public List<ZhuyuanZhiliaojizhangVo> selectAll(){
		return list;
	}
	
	public void clear(){
		list.clear();
	}
	
	public Errors delete(List<Long> id){
		for (Long l : id) {
			for (ZhuyuanZhiliaojizhangVo z : list) {
				if(z.getId() == l){
					list.remove(z);
					break;
				}
			}
		}
		return new Errors(true);
	}
	public long getxqNumber() {
		return zhiliaoxqdao.getxqNumber();
	}
	public void addZhiliaoJizhangXq(ZhiliaoJizhang zhiliaoJizhang){
		ZhiliaoJizhang z =zhiliaojizhangdao.findOne(zhiliaoJizhang.getZhiliaoJizhangId());
		if (z.getZhiliaoJizhangXqs()!=null) {
			zhiliaoxqdao.delete(z.getZhiliaoJizhangXqs());
		}
		for (ZhuyuanZhiliaojizhangVo zz : list) {
			ZhiliaoJizhangXq zxq = new ZhiliaoJizhangXq();
			zxq.setZhiliaoJizhangXqId(zhiliaoxqdao.getxqNumber());
			zxq.setZhiliaoJizhangXqState("已");
			zxq.setZhiliaoJizhangXqNumber(zz.getNumber());
			zxq.setZhiliaoJizhangXqDate(new Date());
			
			zxq.setZhiliaoJizhangXqTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			zxq.setFinancial(financialdao.findOne(zz.getFinancialId()));
			zxq.setPrescription(prescdao.findOne(zz.getChufanhao()));
			zxq.setZhiliaoJizhang(zhiliaojizhangdao.findOne(zhiliaoJizhang.getZhiliaoJizhangId()));
			zhiliaoxqdao.save(zxq);
		}
	}
}
