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
import com.ssh.dao.jpa.doctor.IYaokuKucunDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.nurse.IFayaoJizhangDAO;
import com.ssh.dao.jpa.nurse.IFayaoJizhangXqDAO;
import com.ssh.dao.jpa.nurse.IPrescriptionDAO;
import com.ssh.dao.jpa.nurse.IPrescriptionRecodeDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.FayaoJizhang;
import com.ssh.pojos.FayaoJizhangXq;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.PrescriptionRecode;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.nurse.ZhuyuanFayaoXqVo;

@Service
@Transactional
public class FayaoJizhangService {
	@Autowired
	private IFayaoJizhangDAO fayaojizhangdao;
	@Autowired
	private IEmpDAO empdao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	@Autowired
	private IFayaoJizhangXqDAO fayaoxqdao;
	@Autowired
	private IDrugDao drugdao;
	@Autowired
	private IPrescriptionDAO prescdao;
	@Autowired
	private IPrescriptionRecodeDAO codedao;
	@Autowired
	private IYaokuKucunDao yaokuDAO;
	
	private List<ZhuyuanFayaoXqVo> list=new ArrayList<>();

	public String getNumber() {
		return fayaojizhangdao.getNumber(CommentOrder.dateLike());
	}

	public Errors addFayaoJizhang(String state, FayaoJizhang fayaoJizhang, Long empId, String hospitalRegistrationId) {
		try {
			if (fayaoJizhang != null) {
				FayaoJizhang f = fayaojizhangdao.findOne(fayaoJizhang.getZhuyuanJizhangId());
				if (f != null) {
					f.setZhuyuanJizhangState(state);
				} else {
					Emp emp = empdao.findOne(empId);
					HospitalRegistration hospitalRegistration = registdao.findOne(hospitalRegistrationId);
					fayaoJizhang.setZhuyuanJizhangState(state);
					fayaoJizhang.setEmp(emp);
					fayaoJizhang.setHospitalRegistration(hospitalRegistration);
					fayaojizhangdao.save(fayaoJizhang);
				}
			}
			addZhuyuanFayaoJizhang(fayaoJizhang);
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}

	public long getxqNumber() {
		return fayaoxqdao.getxqNumber();
	}

	public void addZhuyuanFayaoXq(String drugId,String drugBname,BigDecimal number,BigDecimal jilian,BigDecimal money,String state,String pingzhengdaohao, Date shoufeiDate, String shoufeiTime){
		ZhuyuanFayaoXqVo zhuyuanxq = new  ZhuyuanFayaoXqVo(list.size()+1, drugId, drugBname, number ,jilian, money, "未" ,pingzhengdaohao,shoufeiDate,shoufeiTime);
		System.out.println(zhuyuanxq);
		list.add(zhuyuanxq);
	}
	
	public List<ZhuyuanFayaoXqVo> selectAll(){
		return list;
	}
	
	public void clear(){
		list.clear();
	}
	
	public Errors delete(List<Long> id){
		for (Long l : id) {
			for (ZhuyuanFayaoXqVo z : list) {
				if(z.getId() == l){
					list.remove(z);
					break;
				}
			}
		}
		return new Errors(true);
	}
	/**
	 * 添加住院发药详情
	 * @param fayaoJizhang
	 */
	public void addZhuyuanFayaoJizhang(FayaoJizhang fayaoJizhang){
		FayaoJizhang f = fayaojizhangdao.findOne(fayaoJizhang.getZhuyuanJizhangId());
		if (f.getFayaoJizhangXqs() !=null) {
			fayaoxqdao.delete(f.getFayaoJizhangXqs());
		}
		for (ZhuyuanFayaoXqVo z : list) {
			FayaoJizhangXq fxq = new FayaoJizhangXq();
			fxq.setFayaoJizhangXqId(fayaoxqdao.getxqNumber());
			fxq.setFayaoJizhangXqJiliang(z.getJilian());
			fxq.setFayaoJizhangXqNum(z.getNumber());
			fxq.setFayaoJizhangXqPrice(z.getMoney());
			fxq.setFayaoJizhangXqState("已");
			fxq.setFayaoJizhangXqDate(new Date());
			fxq.setFayaoJizhangXqTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			fxq.setDrug(drugdao.findOne(z.getShoufeiid()));
			System.err.println(prescdao.findOne(z.getPingzhengdaohao()));
			
			
			/*FayaoJizhangXq fayaoxq =fayaoxqdao.findOne(fxq.getFayaoJizhangXqId());
			YaokuKucun yk = yaokuDAO.findOne(fayaoxq.getDrug().getYaokuKucun().getYaokuKucunId());
			yk.setYaofangKucunNum(new BigDecimal(yk.getYaofangKucunNum().intValue() - fayaoxq.getFayaoJizhangXqNum().intValue()));
			System.err.println(yk.getYaofangKucunNum().intValue()+"123333313");
			System.err.println(fayaoxq.getFayaoJizhangXqNum().intValue());*/
			fxq.setPrescription(prescdao.findOne(z.getPingzhengdaohao()));
			fxq.setFayaoJizhang(fayaojizhangdao.findOne(fayaoJizhang.getZhuyuanJizhangId()));
			fayaoxqdao.save(fxq);
		}
	}
	public List<PrescriptionVo> selectAllPrescription(){
		return prescdao.selectAllPrescription();
	}
}
