package com.ssh.service.behospitalized;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IZhuyuanHesuanDAO;
import com.ssh.dao.jpa.doctor.IPrescriCodeDao;
import com.ssh.dao.jpa.nurse.IFayaoJizhangDAO;
import com.ssh.dao.jpa.nurse.IFayaoJizhangXqDAO;
import com.ssh.dao.jpa.nurse.IZhiliaoJizhangDAO;
import com.ssh.dao.jpa.nurse.IZhiliaoJizhangXqDAO;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.pojos.FayaoJizhang;
import com.ssh.pojos.FayaoJizhangXq;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;
import com.ssh.pojos.ZhiliaoJizhang;
import com.ssh.pojos.ZhiliaoJizhangXq;
import com.ssh.pojos.ZhuyuanHesuan;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.ChufangVo;
import com.ssh.vo.behospitalized.FeiYongHeSuanVo;

@Service
@Transactional
public class ZhuyuanHesuanService {
	@Autowired
	private IZhuyuanHesuanDAO zhuyuanhesuandao;
	@Autowired
	private IHospitalRegistrationDAO registdao;

	@Autowired
	private IPrescriCodeDao ip;
	
	@Autowired
	private IFinancialHistoryDao fhdao;
	
	@Autowired
	private IFayaoJizhangXqDAO faxqdao;
	@Autowired
	private IZhiliaoJizhangXqDAO zhiliaoxqdao;
	
	private List<FeiYongHeSuanVo> list = new ArrayList<>();
	
	public String getNumber() {
		return zhuyuanhesuandao.getNumber(CommentOrder.dateLike());
	}

	public Errors addZhuyuanHesuan(ZhuyuanHesuan zhuyuanHesuan, String hospitalRegistrationId) {
		System.err.println(hospitalRegistrationId);
		try {
			HospitalRegistration hospitalRegistration = registdao.findOne(hospitalRegistrationId);
			zhuyuanHesuan.setHospitalRegistration(hospitalRegistration);
			zhuyuanhesuandao.save(zhuyuanHesuan);
			//获取list所有数据
			List<FeiYongHeSuanVo> f = selectAll(hospitalRegistrationId);
			
			for (int i = 0; i <f.size(); i++) {
				System.err.println(f.get(i).getShoufeileixing());
				if("发药记账".equals(f.get(i).getShoufeileixing())){
					FayaoJizhangXq fy = faxqdao.findOne(Long.valueOf(f.get(i).getId()));
					System.err.println(fy.getFayaoJizhangXqState());
					if ("已".equals(fy.getFayaoJizhangXqState())) {
						fy.setFayaoJizhangXqState("核");
					}
					
				}
				if("治疗记账".equals(f.get(i).getShoufeileixing())){
					ZhiliaoJizhangXq zl = zhiliaoxqdao.findOne(Long.valueOf(f.get(i).getId()));
					System.err.println(zl.getZhiliaoJizhangXqState());
					if ("已".equals(zl.getZhiliaoJizhangXqState())) {
						
						zl.setZhiliaoJizhangXqState("核");
					}
					
				}
				
			}
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	
	
	public List<FeiYongHeSuanVo> selectAll(String hospitalRegistrationId) {
		List<FeiYongHeSuanVo> list = new ArrayList<>();
		HospitalRegistration h = registdao.findOne(hospitalRegistrationId);
		OutpaitentRegist o = h.getHospitaNotify().getOutpaitentRegist();
		
		// 项目
		/*if (o.getFinancialHistories() != null) {
			for (FinancialHistory f : o.getFinancialHistories()) {
				list.add(new FeiYongHeSuanVo(Integer.parseInt(f.getFinancialHistoryId()), f.getFinancialHistoryShoufeilx(), f.getFinancial().getFinancialId(),
						f.getFinancial().getFinancialName(), f.getFinancialHistoryShoufeirq(),
						f.getFinancialHistoryShoufeisj(), f.getFinancialHistoryShoufeije(),
						f.getFinancialHistoryShoufeizt(), hospitalRegistrationId));
			}
		}*/
		if (h.getZhiliaoJizhangs() !=null) {
			for (ZhiliaoJizhang z : h.getZhiliaoJizhangs()) {
				for (ZhiliaoJizhangXq zx : z.getZhiliaoJizhangXqs()) {
					FeiYongHeSuanVo fei = new FeiYongHeSuanVo(zx.getZhiliaoJizhangXqId() ,zx.getFinancial().getFinancialId(),zx.getFinancial().getFinancialName(),zx.getZhiliaoJizhangXqDate(),zx.getZhiliaoJizhangXqDate()+" "+zx.getZhiliaoJizhangXqTime(),
							zx.getZhiliaoJizhangXqNumber(),zx.getFinancial().getFinancialMoney(),zx.getZhiliaoJizhangXqState(),zx.getPrescription().getPrescriptionId(),
							zx.getZhiliaoJizhang().getHospitalRegistration().getHospitalRegistrationId());
							fei.setShoufeileixing("治疗记账");
							list.add(fei);
				}
				System.err.println(h.getZhiliaoJizhangs().size());
			}
			
		}
		// 药品
		if (h.getFayaoJizhangs() != null) {
			
			/*for (FayaoJizhang lisy : h.getFayaoJizhangs()) {
				for (FayaoJizhangXq fr : lisy.getFayaoJizhangXqs()) {
					list.add(new FeiYongHeSuanVo(Integer.parseInt(String.valueOf(fr.getFayaoJizhangXqId())), fr.getDrug().getDrugType().getDrugTypeName(),
							fr.getDrug().getDrugId(), fr.getDrug().getDrugName(), new Date(),
							fr.getDrug().getDrugBname(), fr.getFayaoJizhangXqPrice(), fr.getFayaoJizhangXqState() ,
							hospitalRegistrationId));
				}
				
			}*/
			for (FayaoJizhang lisy : h.getFayaoJizhangs()) {
				for (FayaoJizhangXq fr : lisy.getFayaoJizhangXqs()) {
					FeiYongHeSuanVo yayao=new FeiYongHeSuanVo(fr.getFayaoJizhangXqId(),
							fr.getDrug().getDrugId(), fr.getDrug().getDrugName(),fr.getFayaoJizhangXqDate(),fr.getFayaoJizhangXqTime(), fr.getFayaoJizhangXqNum(),
							fr.getFayaoJizhangXqPrice(), fr.getFayaoJizhangXqState(),hospitalRegistrationId,
							fr.getPrescription().getPrescriptionId()
							);
					yayao.setShoufeileixing("发药记账");
					list.add(yayao);
					System.err.println(fr.getPrescription().getPrescriptionId());
				}
			}
		}
		return list;
	}

	public List<FeiYongHeSuanVo> selectAllyiliao(String hospitalRegistrationId) {
		List<FeiYongHeSuanVo> list = new ArrayList<>();
		HospitalRegistration h = registdao.findOne(hospitalRegistrationId);
		OutpaitentRegist o = h.getHospitaNotify().getOutpaitentRegist();
		/*if (o.getFinancialHistories() != null) {
			for (FinancialHistory f : o.getFinancialHistories()) {
				list.add(new FeiYongHeSuanVo(list.size() + 1, f.getFinancialHistoryType(), f.getFinancialHistoryId(),
						f.getFinancial().getFinancialName(), f.getFinancialHistoryShoufeirq(),
						f.getFinancialHistoryShoufeisj(), f.getFinancialHistoryShoufeije(),
						f.getFinancialHistoryShoufeizt(), hospitalRegistrationId));
			}
		}*/
		if (h.getZhiliaoJizhangs() !=null) {
			for (ZhiliaoJizhang z : h.getZhiliaoJizhangs()) {
				for (ZhiliaoJizhangXq zx : z.getZhiliaoJizhangXqs()) {
					list.add(new FeiYongHeSuanVo(zx.getZhiliaoJizhangXqId(),zx.getFinancial().getFinancialId(),zx.getFinancial().getFinancialName(),
							zx.getZhiliaoJizhangXqNumber(),new BigDecimal(zx.getFinancial().getFinancialMoney().doubleValue() * 
							zx.getZhiliaoJizhangXqNumber().intValue())
							,zx.getZhiliaoJizhangXqState(),zx.getPrescription().getPrescriptionId(),
							zx.getZhiliaoJizhang().getHospitalRegistration().getHospitalRegistrationId()));
					
				}
				System.err.println(h.getZhiliaoJizhangs().size());
			}
			
		}

		return list;
	}

	public List<FeiYongHeSuanVo> selectAllyaoping(String hospitalRegistrationId) {
		List<FeiYongHeSuanVo> list = new ArrayList<>();
		HospitalRegistration h = registdao.findOne(hospitalRegistrationId);
		if (h.getFayaoJizhangs() != null) {
			for (FayaoJizhang lisy : h.getFayaoJizhangs()) {
				for (FayaoJizhangXq fr : lisy.getFayaoJizhangXqs()) {
					list.add(new FeiYongHeSuanVo(fr.getFayaoJizhangXqId(),
							fr.getDrug().getDrugId(), fr.getDrug().getDrugName(), fr.getFayaoJizhangXqNum(),
							fr.getFayaoJizhangXqPrice(), fr.getFayaoJizhangXqState(),hospitalRegistrationId,
							fr.getPrescription().getPrescriptionId()
							));
					System.err.println(fr.getPrescription().getPrescriptionId());
				}
			}
		}
		
		return list;
	}
	
	public List<ChufangVo> selectAllChufang(String hospitalRegistrationId){
		List<ChufangVo> list = new ArrayList<>();
		HospitalRegistration h = registdao.findOne(hospitalRegistrationId);
		if (h.getPrescriptions() !=null) {
			for (Prescription p : h.getPrescriptions()) {
				list.add(new ChufangVo(list.size()+1,p.getPrescriptionId(),p.getPrescriptionZt(),
						p.getPrescriptionDate(),p.getEmp().getEmpName()));
			}
		}
		return list;
	}
	
}
