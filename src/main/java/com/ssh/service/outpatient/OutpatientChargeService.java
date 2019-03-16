package com.ssh.service.outpatient;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.doctor.IEletronicDAO;
import com.ssh.dao.jpa.doctor.IPrescriCodeDao;
import com.ssh.dao.jpa.doctor.IYaokuKucunDao;
import com.ssh.dao.jpa.outpatient.IFinancialHistoryDao;
import com.ssh.dao.jpa.outpatient.IOutPaientPillsDao;
import com.ssh.dao.jpa.outpatient.IOutRegistPillXqDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.dao.jpa.outpatient.IOutpatientChargesDAO;
import com.ssh.dao.jpa.staff.IEmpDAO;
import com.ssh.pojos.ChargeManagement;
import com.ssh.pojos.DrugYaofang;
import com.ssh.pojos.DrugYaofangXq;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;
import com.ssh.pojos.PrescriptionRecode;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.EletronicPrescriVo;
import com.ssh.vo.doctor.HospitalProjectVo;
import com.ssh.vo.outpatient.FinacialVo;
import com.ssh.vo.outpatient.OutRegistChargesVo;

/**
 * 门诊划价收费类
 * @author Administrator
 *
 */
@Service
@Transactional
public class OutpatientChargeService {
	
	@Autowired
	private IOutpatientChargesDAO chargesDAO;
	@Autowired
	private IEletronicDAO eleDao;
	@Autowired
	private IOutpaitentDAO IODAO;
	@Autowired
	private IFinancialHistoryDao finanCodeDao;
	@Autowired
	private IPrescriCodeDao codeDao;
	@Autowired
	private IOutPaientPillsDao outPillDao;
	@Autowired
	private IOutRegistPillXqDao outPillXQDao;
	@Autowired
	private IEmpDAO IEDao;
	
	@Autowired
	private IYaokuKucunDao IYDAO;
	public String selectLikeNUmber(){
		return chargesDAO.selectLikeNumer(CommentOrder.dateLike());
	}
	
	/**
	 * 查询药品选项卡
	 */
	List<EletronicPrescriVo> listEle =new ArrayList<>();//药品选项卡
	public List<EletronicPrescriVo> queryEletronicPrescri(String outpaitentRegistId){
		clearDrug();//清空
		if(outpaitentRegistId != null){
			OutpaitentRegist out = IODAO.findOne(outpaitentRegistId);
			if(out.getPrescriptions() != null){
				//查询所有的处方记录
				List<PrescriptionRecode> code = (List<PrescriptionRecode>) codeDao.findAll();
				//循环构建处方和处方记录
				for (PrescriptionRecode ptwo : code) {
				for (Prescription pone: out.getPrescriptions()) {
						if(pone.getPrescriptionId().equals(ptwo.getPrescriptionId())){
							EletronicPrescriVo ele = new EletronicPrescriVo();
							ele.setId(ptwo.getPrescriptionRecodeId());
							ele.setPrescriptionRecodeDrugType(ptwo.getPrescriptionRecodeDrugType());
							ele.setPrescriptionRecodeId(codeDao.findOne(ptwo.getPrescriptionRecodeId()).getDrug().getDrugId());
							ele.setDrugBname(codeDao.findOne(ptwo.getPrescriptionRecodeId()).getDrug().getDrugName());
							ele.setPrescriptionRecodeNum(ptwo.getPrescriptionRecodeNum());
							ele.setPrescriptionRecodePrice(ptwo.getPrescriptionRecodePrice());
							ele.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							ele.setPrescriptionRecodeMoney(new BigDecimal(ptwo.getPrescriptionRecodeNum().intValue()*ptwo.getPrescriptionRecodePrice().doubleValue()));
							ele.setPrescriptionRecodeZt(ptwo.getPrescriptionRecodeZt());
							listEle.add(ele);
							break;
						}
					}
				}
				
			}
		}
		return listEle;
	}
	
	/**
	 * 清除药品集合
	 */
	public void clearDrug(){
		listEle.clear();
	}
	
	/**
	 * 检验选项卡
	 */
	List<HospitalProjectVo>  jianyanList = new ArrayList<>();//检验选项卡
	List<HospitalProjectVo>  zhiliaoList = new ArrayList<>();//治疗选项卡
	List<HospitalProjectVo>  shoushuList = new ArrayList<>();//手术选项卡
	List<HospitalProjectVo>  haocaiList = new ArrayList<>();//耗材选项卡
	List<HospitalProjectVo>  qitaList = new ArrayList<>();//其他选项卡
	
	/**
	 * 判断选项卡是什么类型
	 * @param outpaitentRegistId
	 * @param typeName
	 * @return
	 */
	public List<HospitalProjectVo> queryJianYan(String outpaitentRegistId,String typeName){
	
		if(outpaitentRegistId != null){
			OutpaitentRegist regist = IODAO.findOne(outpaitentRegistId);
			if(regist != null){
				switch (typeName) {
				case "体检费":
					return queryHispitalTypeName(jianyanList,regist,typeName);
				case "治疗费":
					return  queryHispitalTypeName(zhiliaoList,regist,typeName);
				case "手术费":
					return queryHispitalTypeName(shoushuList,regist,typeName);
				case "耗材费":
					return queryHispitalTypeName(haocaiList,regist,typeName);
				default:
					List<HospitalProjectVo> f = finanCodeDao.queryFinancialByTypeName(IODAO.findOne(outpaitentRegistId));
					for (HospitalProjectVo h : f) {
						FinancialHistory fin = finanCodeDao.findOne(h.getFinancialId());
						h.setId(h.getFinancialId());
						h.setFinancialId(fin.getFinancial().getFinancialId());
						h.setFinancialName(fin.getFinancial().getFinancialName());
						h.setFinancialMoney(new BigDecimal(fin.getFinancialHistoryNum().intValue()*fin.getFinancialHistoryShoufeije().doubleValue()));
						h.setFinancialTypeName(fin.getFinancialHistoryShoufeilx());
						h.setTime(fin.getFinancialHistoryShoufeirq() + " " + fin.getFinancialHistoryShoufeisj());
					}
					return f;
				}
			}
		}
		return haocaiList;
	}
	
	/**
	 * 根据分类名查询划价选项卡数据集合（中间板块）
	 * @param typeName 
	 * @param regist 
	 * @param jianyanList 
	 * @param h
	 * @param typeName
	 * @return
	 */			
	public List<HospitalProjectVo> queryHispitalTypeName(List<HospitalProjectVo> list
			, OutpaitentRegist regist,String typeName){
		List<FinancialHistory> hlist = regist.getFinancialHistories();
		if(hlist != null){
			list.clear();  
			for (FinancialHistory f : hlist) {
				String type = f.getFinancial().getFinancialTypeBean().getFinancialTypeName();
				if(type.equals(typeName)){
					GetHospitalProjrctVo(list, f);
				}
			}
			
		}
		return list;
	}

	private void GetHospitalProjrctVo(List<HospitalProjectVo> list, FinancialHistory f) {
		HospitalProjectVo h = new HospitalProjectVo();
		h.setFinancialTypeName(f.getFinancial().getFinancialTypeBean().getFinancialTypeName());
		h.setFinancialId(f.getFinancial().getFinancialId());
		h.setFinancialName(f.getFinancial().getFinancialName());
		h.setFinancialNum(f.getFinancialHistoryNum());
		h.setTime(f.getFinancialHistoryShoufeirq()+" "+f.getFinancialHistoryShoufeisj());
		h.setId(f.getFinancialHistoryId());
		h.setFinancialPrice(f.getFinancialHistoryShoufeije());
		h.setFinancialMoney(new BigDecimal(f.getFinancialHistoryNum().intValue()*f.getFinancialHistoryShoufeije().doubleValue()));
		h.setFinancialzt(f.getFinancialHistoryShoufeizt());
		list.add(h);
	}

	/**
	 * 通过收费项目id改变状态
	 * @param financialId
	 * @param financialzt
	 * @return
	 */
	public Errors updateChargeZT(String id, String financialHistoryShoufeilx,String outpaitentRegistId) {
		try {
			if(id != null){
				if("门诊开药".equals(financialHistoryShoufeilx)){
					PrescriptionRecode p = codeDao.findOne(id);
					p.setPrescriptionRecodeZt("记");
				}else{
					FinancialHistory f = finanCodeDao.findOne(id);
					f.setFinancialHistoryShoufeizt("记");
				}
				
				if(outpaitentRegistId != null){
					OutpaitentRegist out = IODAO.findOne(outpaitentRegistId);
					out.setOutpaitentRegistZhuangtai("已划价");
					if(out.getFinancialHistories() == null){
						out.setFinancialHistories(new ArrayList<>());
					}
					for (FinancialHistory f : out.getFinancialHistories()) {
						FinancialHistory fa = finanCodeDao.findOne(f.getFinancialHistoryId());
						if("门诊收费".equals(fa.getFinancial().getFinancialTypeBean().getFinancialTypeName())){
							fa.setFinancialHistoryShoufeizt("结");
						}
					}
				}
				
				
			}
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}

	/**
	 * 查询未收费
	 * @param outpaitentRegistId
	 * @return
	 */
	public List<OutRegistChargesVo> queryOutRegistCharges(String outpaitentRegistId) {
		List<OutRegistChargesVo> listRWei = new ArrayList<>();;
	
		if(outpaitentRegistId != null){
			OutpaitentRegist out = IODAO.findOne(outpaitentRegistId);
			if(out.getFinancialHistories() != null){
				for (FinancialHistory h : out.getFinancialHistories()) {
					OutRegistChargesVo oc = new OutRegistChargesVo();
					getFinal(h, oc);
					listRWei.add(oc);
				}
			}
			
			if(out.getPrescriptions() != null){
				List<PrescriptionRecode> code = (List<PrescriptionRecode>) codeDao.findAll();
				for (PrescriptionRecode code1 : code) {
					for (Prescription p : out.getPrescriptions()) {
						if(p.getPrescriptionId().equals(code1.getPrescriptionId())){
							OutRegistChargesVo oc1 = new OutRegistChargesVo();
							getDrugCode(code1, oc1);
							listRWei.add(oc1);
							break;
						}
					}
				}
			}
			
		}
		return listRWei;
	}

	private void getDrugCode(PrescriptionRecode code1, OutRegistChargesVo oc1) {
		oc1.setFinancialHistoryId(code1.getPrescriptionRecodeId());
		oc1.setFinancialHistoryShoufeilx(code1.getPrescriptionRecodeDrugType());
		oc1.setFinancialHistoryShoufeiName(code1.getDrug().getDrugName());
		oc1.setFinancialHistoryShoufeisj(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
		oc1.setFinancialHistoryNum(code1.getPrescriptionRecodeNum());
		oc1.setFinancialHistoryPrice(code1.getPrescriptionRecodePrice());
		oc1.setFinancialHistoryShoufeije(new BigDecimal(code1.getPrescriptionRecodeNum().intValue() * code1.getPrescriptionRecodePrice().doubleValue()));
		oc1.setFinancialHistoryShoufeizt(code1.getPrescriptionRecodeZt());
	}

	private void getFinal(FinancialHistory h, OutRegistChargesVo oc) {
		//oc.setId(listRWei.size()+1);
		oc.setFinancialHistoryId(h.getFinancialHistoryId());
		oc.setFinancialHistoryShoufeilx(h.getFinancialHistoryShoufeilx());
		oc.setFinancialHistoryShoufeiName(h.getFinancial().getFinancialName());
		oc.setFinancialHistoryShoufeisj(h.getFinancialHistoryShoufeirq() + " "+ h.getFinancialHistoryShoufeisj());
		oc.setFinancialHistoryNum(h.getFinancialHistoryNum());
		oc.setFinancialHistoryPrice(finanCodeDao.findOne(h.getFinancialHistoryId()).getFinancial().getFinancialPrice());
		oc.setFinancialHistoryShoufeije(new BigDecimal(h.getFinancialHistoryNum().intValue() * finanCodeDao.findOne(h.getFinancialHistoryId()).getFinancialHistoryShoufeije().doubleValue()));
		oc.setFinancialHistoryShoufeizt(h.getFinancialHistoryShoufeizt());
	}
	
	/**
	 * 增加电子处方
	 * @param outpaitentRegistId
	 * @param prescriptionId
	 * @return
	 */
	public Errors addPatientCharges(ChargeManagement c,String outpaitentRegistId, String prescriptionId) {
		try {
			OutpaitentRegist  out =IODAO.findOne(outpaitentRegistId);
			Prescription p = eleDao.findOne(prescriptionId);
			c.setOutpaitentRegist(out);
			c.setPrescription(p);
			c.setChargeManagementZt("已处理");
			out.setOutpaitentRegistZhuangtai("已结算");
			chargesDAO.save(c);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	public Errors updateYiShouChargeZT(String id, String typeName) {
		try {
			if(id != null){
				if("门诊开药".equals(typeName)){
					PrescriptionRecode prescri = codeDao.findOne(id);
					if("记".equals(prescri.getPrescriptionRecodeZt())){
						prescri.setPrescriptionRecodeZt("结");
					}
				}else{
					FinancialHistory finan = finanCodeDao.findOne(id);
					if("记".equals(finan.getFinancialHistoryShoufeizt())){
						finan.setFinancialHistoryShoufeizt("结");
					}
				}
			}
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 门诊发药的查询记录
	 * @param outpaitentRegistId
	 * @return
	 */
	public List<EletronicPrescriVo> queryEleRegistFaYao(String outpaitentRegistId) {
		List<EletronicPrescriVo> list = new ArrayList<>();
		if(outpaitentRegistId != null){
			OutpaitentRegist out = IODAO.findOne(outpaitentRegistId);
			if(out.getPrescriptions() != null){
				List<PrescriptionRecode> listCode = (List<PrescriptionRecode>) codeDao.findAll();
				for (Prescription p : out.getPrescriptions()) {
					for (PrescriptionRecode code : listCode) {
						if(p.getPrescriptionId().equals(code.getPrescriptionId())){
							if("结".equals(code.getPrescriptionRecodeZt())){
								list.add(new EletronicPrescriVo(code.getPrescriptionRecodeId(),
										code.getDrug().getDrugName(), code.getPrescriptionRecodeDrugType(), 
										code.getPrescriptionRecodeExplain(),
										new BigDecimal(code.getPrescriptionRecodeNum().intValue() * code.getPrescriptionRecodePrice().intValue()), 
										code.getPrescriptionRecodeNum(), code.getPrescriptionRecodePrice(),
										code.getPrescriptionRecodeZt()));
							}
						}
					}
				}
			}
		}
		return list;
	}

	/**
	 * 增加门诊发药
	 * @param listLong 
	 * @param drug
	 * @param outpaitentRegistId
	 * @param prescriptionId
	 * @param empId 
	 * @return
	 */
	public Errors addPatientPills(List<Long> listLong, DrugYaofang drug, String outpaitentRegistId, String prescriptionId, Long empId) {
		try {
			OutpaitentRegist  out =IODAO.findOne(outpaitentRegistId);
			Prescription p = eleDao.findOne(prescriptionId);
			drug.setOutpaitentRegist(out);
			drug.setDrugYaofangState("已处理");
			drug.setPrescription(p);
			drug.setEmp(IEDao.findOne(empId));
			outPillDao.save(drug);
			for (Long l : listLong) {
				PrescriptionRecode code = codeDao.findOne(String.valueOf(l));
				DrugYaofangXq drugXq = new DrugYaofangXq();
				drugXq.setDrugYaofangXqId(outPillXQDao.getDrugYaoFangId());
				drugXq.setDrug(code.getDrug());
				drugXq.setDrugYaofang(drug);
				drugXq.setDrugYaofangXqNumber(code.getPrescriptionRecodeNum());
				drugXq.setDrugYaofangXqPrice(code.getPrescriptionRecodePrice());
				drugXq.setDrugYaofangXqMoney(new BigDecimal(code.getPrescriptionRecodeNum().intValue() * code.getPrescriptionRecodePrice().doubleValue()));
				drugXq.setDrugYaofangXqRemark(code.getPrescriptionRecodeExplain());
				drugXq.setDrugYaofangXqState("已发药");
				
				YaokuKucun yk = IYDAO.findOne(code.getDrug().getYaokuKucun().getYaokuKucunId());
				yk.setYaofangKucunNum(new BigDecimal(yk.getYaofangKucunNum().intValue() - code.getPrescriptionRecodeNum().intValue()));
				yk.setYaofangKaiyaoShengyuNum(new BigDecimal( yk.getYaofangKucunNum().intValue() - yk.getYaofangKaiyaoNum().intValue()));
				outPillXQDao.save(drugXq);
			}
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	/**
	 * 查找已发药状态的记录
	 * @param outpaitentRegistId
	 * @return
	 */
	public Errors queryOutPatientState(String outpaitentRegistId) {
		try {
			if(outpaitentRegistId != null){
				OutpaitentRegist  out = IODAO.findOne(outpaitentRegistId);
					List<DrugYaofang> list = out.getDrugYaofangs();
					return list.isEmpty() ? new Errors() : new Errors(true);
			}
			return new Errors();
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	
	
}
