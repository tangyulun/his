package com.ssh.service.nurse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.dean.IZhuyuanFayaoDao;
import com.ssh.dao.jpa.doctor.IYaokuKucunDao;
import com.ssh.dao.jpa.drugstorage.IDrugDao;
import com.ssh.dao.jpa.nurse.IPrescriptionDAO;
import com.ssh.dao.jpa.nurse.IPrescriptionRecodeDAO;
import com.ssh.dao.jpa.nurse.IZhuyuanFayaoXqDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.dao.mybatis.behospitalized.IMyPrescriptionDAO;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.Prescription;
import com.ssh.pojos.YaokuKucun;
import com.ssh.pojos.ZhuyuanFayao;
import com.ssh.pojos.ZhuyuanFayaoXq;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.HospitaNotifyVo;
import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.drugstorage.DrugVo;
import com.ssh.vo.nurse.PrescriptionRecodeVo;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.nurse.ZhuyuanFayaoXqVo;

@Service
@Transactional
public class ZhuyuanFayaoService {
	@Autowired
	private IZhuyuanFayaoDao fayaodao;
	
	@Autowired
	private IHospitalRegistrationDAO registdao;
	
	@Autowired
	private IPrescriptionDAO prescription;
	
	@Autowired
	private IPrescriptionRecodeDAO prescrpdao;
	
	@Autowired
	private IEmpDAO empdao;
	
	@Autowired
	private IZhuyuanFayaoXqDAO fayaoxq;
	
	@Autowired
	private IDrugDao drugdao;
	
	@Autowired
	private IYaokuKucunDao yaokudao;
	
	@Autowired
	private IMyPrescriptionDAO myprescription;
	
	private List<PrescriptionRecodeVo> list=new ArrayList<>();
	
	public List<PrescriptionRecodeVo> selectPrescriptionRecode(String prescriptionId){
		list = prescrpdao.selectPrescriptionRecode(prescriptionId);
		selectDrug(list);
		return list;
	}
	public HospitalRegistrationVo selectZhuYuanDengji(String number) {
		Prescription p = prescription.findOne(number);
		try {
			System.err.println(number);
			System.err.println(p.getHospitalRegistration());
			if(p.getHospitalRegistration()==null){
				return null; 
			}
		} catch (Exception e) {
			return null;
		}
		return new HospitalRegistrationVo(p.getHospitalRegistration().getHospitalRegistrationId());
	}
	
	public void selectDrug(List<PrescriptionRecodeVo> list){
		for (PrescriptionRecodeVo h : list) {
			
			h.setDrug(new DrugVo(prescrpdao.findOne(h.getPrescriptionRecodeId()).getDrug().getDrugId(), 
					prescrpdao.findOne(h.getPrescriptionRecodeId()).getDrug().getDrugName()));
		}
	}
	
	public List<PrescriptionVo> selectPrescription(int page, int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<PrescriptionVo> list = prescription.selectPrescription(pages);
		//selectWaijian(list);
		return list;
	}
	
	public long count() {
		return prescription.count();
	}
	
	public List<PrescriptionVo> selectPrescriptionByName(int page , int rows, String prescriptionId){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<PrescriptionVo> list = prescription.selectPrescriptionByName(pages, "%" + prescriptionId + "%");
		
		return list;
	}
	
	public long findPrescriptionId(String prescriptionId){
		return prescription.findPrescriptionId("%" + prescriptionId + "%");
	}
	
	Page<?> pages ;
	public List<PrescriptionVo> selectPrescriptionStartDateToEndDate(int page , int rows , Date startTime, Date endTime,String prescriptionId){
		pages = PageHelper.startPage(page , rows);
		List<PrescriptionVo> list =  myprescription.selectPrescriptionStartDateToEndDate(startTime, endTime, "".equals(prescriptionId) ? null : "%"+ prescriptionId + "%");
		
		return list;
	}

	public long queryStartEndcount() {
		return pages.getTotal();
	}
	
	public Errors addZhuyuanfayao(ZhuyuanFayao zhuyuanfayao,String hospitalRegistrationId,Long empId,String prescriptionId){
			
		try {
			if (zhuyuanfayao !=null) {
				HospitalRegistration hospitalRegistration =registdao.findOne(hospitalRegistrationId);
				Emp emp = empdao.findOne(empId);
				zhuyuanfayao.setEmp(emp);
				zhuyuanfayao.setPrescription(prescription.findOne(prescriptionId));
				zhuyuanfayao.setHospitalRegistration(hospitalRegistration);
				zhuyuanfayao.setZhuyuanFayaoState("已处理");
				fayaodao.save(zhuyuanfayao);
				
			}
			addZhuyuanfayaoXq(zhuyuanfayao);
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
			
	}
	
	public void addZhuyuanfayaoXq(ZhuyuanFayao zhuyuanFayao){
		ZhuyuanFayao z = fayaodao.findOne(zhuyuanFayao.getZhuyuanFayaoId());
		if (z.getZhuyuanFayaoXqs() !=null) {
			fayaoxq.delete(z.getZhuyuanFayaoXqs());
		}
		for (PrescriptionRecodeVo p : list) {
			ZhuyuanFayaoXq zxq = new ZhuyuanFayaoXq();
			zxq.setZhuyuanFayaoXqId(fayaoxq.getxqNumber());
			zxq.setDrug(drugdao.findOne(p.getDrugVo().getDrugId()));
			zxq.setZhuyuanFayao(fayaodao.findOne(zhuyuanFayao.getZhuyuanFayaoId()));
			zxq.setZhuyuanFayaoXqMoney(p.getPrescriptionRecodeMoney());
			zxq.setZhuyuanFayaoXqNumber(p.getPrescriptionRecodeNum());
			//zxq.setZhuyuanFayaoXqPh(zhuyuanFayaoXqPh);
			zxq.setZhuyuanFayaoXqPrice(p.getPrescriptionRecodePrice());
			//zxq.setZhuyuanFayaoXqRemark();
			zxq.setZhuyuanFayaoXqState(p.getPrescriptionRecodeZt());
			zxq.setZhuyuanFayaoXqState("已发药");
			
			YaokuKucun yk = yaokudao.findOne(zxq.getDrug().getYaokuKucun().getYaokuKucunId());
			yk.setYaofangKucunNum(new BigDecimal(yk.getYaofangKucunNum().intValue() - zxq.getZhuyuanFayaoXqNumber().intValue()));
			System.err.println(yk.getYaofangKucunNum().intValue()+"55555");
			System.err.println(zxq.getZhuyuanFayaoXqNumber().intValue());
			System.err.println(zxq+"11111111");
			fayaoxq.save(zxq);
		}
	}
	
}
