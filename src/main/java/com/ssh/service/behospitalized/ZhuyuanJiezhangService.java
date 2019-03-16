package com.ssh.service.behospitalized;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.behospitalized.IZhuyuanJiezhangDAO;
import com.ssh.dao.jpa.nurse.IFayaoJizhangXqDAO;
import com.ssh.dao.jpa.nurse.IZhiliaoJizhangXqDAO;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.pojos.FayaoJizhang;
import com.ssh.pojos.FayaoJizhangXq;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.RushShouqu;
import com.ssh.pojos.ZhiliaoJizhang;
import com.ssh.pojos.ZhiliaoJizhangXq;
import com.ssh.pojos.ZhuyuanJiezhang;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.behospitalized.FeiYongHeSuanVo;
import com.ssh.vo.behospitalized.RushShouquVo;

@Service
@Transactional
public class ZhuyuanJiezhangService {
	@Autowired
	private IZhuyuanJiezhangDAO zhuyuanjiezhangdao;
	@Autowired
	private IHospitalRegistrationDAO registdao;
	
	@Autowired
	private IFinancialHistoryDao fhdao;
	@Autowired
	private IZhiliaoJizhangXqDAO zhiliaoxqdao;
	@Autowired
	private IFayaoJizhangXqDAO faxqdao;
	
	public String getNumber(){
		return zhuyuanjiezhangdao.getNumber(CommentOrder.dateLike());
	}
	
	public Errors addZhuyuanJiezhang(ZhuyuanJiezhang zhuyuanJiezhang, String hospitalRegistrationId){
		try {
			HospitalRegistration hospitalRegistration = registdao.findOne(hospitalRegistrationId);
			zhuyuanJiezhang.setHospitalRegistration(hospitalRegistration);
			zhuyuanjiezhangdao.save(zhuyuanJiezhang);
			//获取list所有数据
			List<FeiYongHeSuanVo> f = selectAll(hospitalRegistrationId);
			
			for (int i = 0; i <f.size(); i++) {
				System.err.println(f.get(i).getShoufeileixing());
				if("发药记账".equals(f.get(i).getShoufeileixing())){
					FayaoJizhangXq fy = faxqdao.findOne(Long.valueOf(f.get(i).getId()));
					System.err.println(fy.getFayaoJizhangXqState());
					if ("核".equals(fy.getFayaoJizhangXqState())) {
						fy.setFayaoJizhangXqState("结");
					}
				}
				if("治疗记账".equals(f.get(i).getShoufeileixing())){
					ZhiliaoJizhangXq zl = zhiliaoxqdao.findOne(Long.valueOf(f.get(i).getId()));
					System.err.println(zl.getZhiliaoJizhangXqState());
					if ("核".equals(zl.getZhiliaoJizhangXqState())) {
						zl.setZhiliaoJizhangXqState("结");
					}
				}
			}
			return new Errors(true);
		} catch (Exception e) {
			// TODO: handle exception
			return new Errors(e.getMessage());
		}
	}
	
	//根据住院号来查询rushShouquYushouMoney
	public List<RushShouquVo> selectrushShouquYushouMoney(String number){
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
		/*if (h.getFayaoJizhangs() != null) {
			
			for (FayaoJizhang lisy : h.getFayaoJizhangs()) {
				for (FayaoJizhangXq fr : lisy.getFayaoJizhangXqs()) {
					list.add(new FeiYongHeSuanVo(Integer.parseInt(String.valueOf(fr.getFayaoJizhangXqId())), fr.getDrug().getDrugType().getDrugTypeName(),
							fr.getDrug().getDrugId(), fr.getDrug().getDrugName(), new Date(),
							fr.getDrug().getDrugBname(), fr.getFayaoJizhangXqPrice(), fr.getFayaoJizhangXqState() ,
							hospitalRegistrationId));
				}
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
		return list;
	}
}
