package com.ssh.service.doctor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.jpa.behospitalized.IHospitalRegistrationDAO;
import com.ssh.dao.jpa.doctor.DrugChuFnag;
import com.ssh.dao.jpa.doctor.IEletronicDAO;
import com.ssh.dao.jpa.doctor.IPrescriCodeDao;
import com.ssh.dao.jpa.doctor.IYaokuKucunDao;
import com.ssh.dao.jpa.drugstorage.IDrugTypeDao;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.pojos.Drug;
import com.ssh.pojos.DrugType;
import com.ssh.pojos.Emp;
import com.ssh.pojos.HospitalRegistration;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.Prescription;
import com.ssh.pojos.PrescriptionRecode;
import com.ssh.pojos.YaokuKucun;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.doctor.DrugChuFangVO;
import com.ssh.vo.doctor.EletronicPrescriVo;
import com.ssh.vo.doctor.KuCunVO;
import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.UnitVo;

/**
 * 电子处方业务类
 * @author Administrator
 *
 */
@Service
@Transactional
public class ElectronicService {

	@Autowired
	private IDrugTypeDao drugTypeDao;
	@Autowired
	private IEletronicDAO eletronicDAO;
	@Autowired
	private DrugChuFnag drugDao;
	@Autowired
	private IYaokuKucunDao IYDAO;
	@Autowired
	private IOutpaitentDAO outpaitentDAO;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private IPrescriCodeDao prescriCodeDao;
	
	@Autowired
	private IHospitalRegistrationDAO IHDAO;
	public String selectLikeNUmber(){
		return eletronicDAO.selectLikeNUmber(CommentOrder.dateLike());
	}
	
	List<EletronicPrescriVo> listEle = new ArrayList<>();//存处方开药的集合

	/**
	 * 添加处方记录的数据
	 * @param e
	 */
	public void addDrugAll(EletronicPrescriVo e) {
		e.setId(String.valueOf(listEle.size() +1));
		e.setPrescriptionRecodeDrugType("处方开药");
		e.setPrescriptionRecodeZt("未");
		if(listEle.size() == 0){
			listEle.add(e);
			return;
		}
		
		for (int i = 0; i < listEle.size(); i++) {
			if(listEle.get(i).getPrescriptionRecodeId().equals( e.getPrescriptionRecodeId())){
				listEle.get(i).setPrescriptionRecodeNum(new BigDecimal(listEle.get(i).getPrescriptionRecodeNum().intValue() 
						+ e.getPrescriptionRecodeNum().intValue()));
				listEle.get(i).setPrescriptionRecodeMoney(new BigDecimal(listEle.get(i).getPrescriptionRecodeNum().intValue()
						* listEle.get(i).getPrescriptionRecodePrice().intValue()));
				break;
			}else if(i == listEle.size() -1){
				listEle.add(e);
				break;
			}
		}
	}
	
	public List<EletronicPrescriVo> queryEleAll(){
		return listEle;
	}
	
	public void clear(){
		listEle.clear();
	}
	
	/**
	 * 查询处方
	 */
	public List<DrugChuFangVO> queryDrug(int page, int rows){
		List<DrugChuFangVO> listDrug =  drugDao.selectAllDrug(new PageRequest(page - 1, rows));
		selectChuFang(listDrug);
		return listDrug;
	}
	
	/**
	 * 绑定单位，数量，类型之间的关系
	 * @param listDrug
	 */
	private void selectChuFang(List<DrugChuFangVO> listDrug) {
		for (DrugChuFangVO d : listDrug) {
			d.setKukun(new KuCunVO(drugDao.findOne(d.getDrugId()).getYaokuKucun().getYaokuKucunId(),
					drugDao.findOne(d.getDrugId()).getYaokuKucun().getYaofangKaiyaoShengyuNum(),
					drugDao.findOne(d.getDrugId()).getYaokuKucun().getYaofangKucunNum()));
			
			d.setType(new DrugTypeVo(drugDao.findOne(d.getDrugId()).getDrugType().getDrugTypeId(), 
					drugDao.findOne(d.getDrugId()).getDrugType().getDrugTypeName()));
			
			d.setUnit(new UnitVo(drugDao.findOne(d.getDrugId()).getUnit().getUnitsId(), 
					drugDao.findOne(d.getDrugId()).getUnit().getUnitsName()));
		}
	}

	public long queryDrugCount(){
		return drugDao.count();
	}

	/**
	 * 查询通过药品分类
	 * @param page
	 * @param rows
	 * @param drugTypeId
	 * @return
	 */
	public List<DrugChuFangVO> queryDrugFindByTypeId(int page, int rows, Long drugTypeId) {
		DrugType drug = drugTypeDao.findOne(drugTypeId);
		PageRequest pages = new PageRequest(page - 1, rows);
		List<DrugChuFangVO> listDrug= drugDao.queryDrugFingByTypeId(pages,drug);
		selectChuFang(listDrug);
		return listDrug;
	}

	public long queryDrugCounts(Long drugTypeId) {
		DrugType drug = drugTypeDao.findOne(drugTypeId);
		return drugDao.queryDrugCounts(drug);
	}
	
	boolean isFrag = false;
	public void deleteDrug(List<Long> l) {
		for (Long long1 : l) {
			for (EletronicPrescriVo ele : listEle) {
				if(Long.parseLong(ele.getId())==long1){
					listEle.remove(ele);
					isFrag = true;
					updateKucunNum(ele.getPrescriptionRecodeNum().intValue(), ele.getPrescriptionRecodeId());
					break;
				}
			}
		}
		
	}

	/**
	 * 修改表格记录
	 * @param ele
	 * @param id
	 * @param num 
	 */
	public void updataDrugCodes(EletronicPrescriVo ele, int id, BigDecimal num) {
		for (EletronicPrescriVo e : listEle) {
			if(Long.parseLong(e.getId()) == id){
				e.setPrescriptionRecodeNum(ele.getPrescriptionRecodeNum());
				e.setPrescriptionRecodeMoney(new BigDecimal(e.getPrescriptionRecodePrice().doubleValue()
						* ele.getPrescriptionRecodeNum().intValue()));
				e.setPrescriptionRecodeExplain(ele.getPrescriptionRecodeExplain());
				Drug drug = drugDao.findOne(e.getPrescriptionRecodeId());
				YaokuKucun k = IYDAO.findOne(drug.getYaokuKucun().getYaokuKucunId());
				k.setYaofangKaiyaoShengyuNum(new BigDecimal(k.getYaofangKaiyaoShengyuNum().intValue() + 
						num.intValue()));
				k.setYaofangKaiyaoNum(
						new BigDecimal(
					k.getYaofangKucunNum().intValue() - k.getYaofangKaiyaoShengyuNum().intValue()
				));
				break;
			}
		}
	}
	
	/**
	 * 计算总金额
	 */
	public double sumMoney(){
		double money = 0.0;
		for (EletronicPrescriVo e : listEle) {
			money +=e.getPrescriptionRecodeMoney().doubleValue();
		}
		return money;
	}
	
	/**
	 * 修改库存数量
	 * @param kucunNum
	 * @param drugId
	 * @return
	 */
	public Errors updateKucunNum(int kucunNum, String drugId) {
		try {
			Drug drug = drugDao.findOne(drugId);
			YaokuKucun yf = IYDAO.findOne(drug.getYaokuKucun().getYaokuKucunId());
			if(isFrag){
				yf.setYaofangKaiyaoShengyuNum(new BigDecimal(yf.getYaofangKaiyaoShengyuNum().intValue() + kucunNum));
			}else{
				yf.setYaofangKaiyaoShengyuNum(new BigDecimal(yf.getYaofangKaiyaoShengyuNum().intValue() - kucunNum));
			}
				isFrag = false;
				yf.setYaofangKaiyaoNum(new BigDecimal(yf.getYaofangKucunNum().intValue() - yf.getYaofangKaiyaoShengyuNum().intValue()));
			return new Errors(true);
		} catch (Exception e) {
			return new Errors(e.getMessage());
		}
	}
	
	public void addEletonic(Prescription prescri, String hId){
		Iterable<PrescriptionRecode> code = prescriCodeDao.findAll();
		for (PrescriptionRecode p : code) {
			if(p.getPrescriptionId() == prescri.getPrescriptionId()){
				prescriCodeDao.delete(p);
			}
		}
		for (EletronicPrescriVo ele : listEle) {
			PrescriptionRecode p = new PrescriptionRecode();//处方记录
			p.setPrescriptionRecodeDrugType(ele.getPrescriptionRecodeDrugType());
			p.setPrescriptionRecodeId((prescriCodeDao.count()+1)+"");
			p.setDrug(drugDao.findOne(ele.getPrescriptionRecodeId()));
			p.setPrescriptionId(prescri.getPrescriptionId());
			p.setPrescriptionRecodeNum(ele.getPrescriptionRecodeNum());
			p.setPrescriptionRecodePrice(ele.getPrescriptionRecodePrice());
			p.setPrescriptionRecodeMoney(ele.getPrescriptionRecodeMoney());
			p.setPrescriptionRecodeExplain(ele.getPrescriptionRecodeExplain());
			p.setPrescriptionRecodeRq(new Date());
			p.setPrescriptionRecodeSj(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			p.setPrescriptionRecodeZt(ele.getPrescriptionRecodeZt());
			p.setPrescriptionRecodeDrugType("".equals(hId) ? "门诊开药" : "住院开药");
			System.err.println(p.getPrescriptionRecodeSj());
			prescriCodeDao.save(p);
		}
	}
	
	/**
	 * 新增电子处方
	 * @param state 
	 */
	public Errors insertEletronic(Prescription p,String outRegistId,Long empId, String eType , String hId){
		try {
					p.setPrescriptionZt("已处理");
					p.setPrescriptionType(eType);
					insertChufang(p, outRegistId, empId , eType , hId);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	private void insertChufang(Prescription p, String outRegistId, Long empId, String eType, String hId) {
		System.err.println(hId);
		Emp emp = loginDao.findOne(empId);
		HospitalRegistration hr = IHDAO.findOne(hId);
		if("门诊处方".equals(eType)){
			OutpaitentRegist regist = outpaitentDAO.findOne(outRegistId);
				p.setOutpaitentRegist(regist);
		}else{
			OutpaitentRegist out = outpaitentDAO.findOne(IHDAO.findOne(hId).getHospitaNotify().getOutpaitentRegist().getOutpaitentRegistId());
			p.setOutpaitentRegist(out);
			p.setHospitalRegistration(hr);
		}
		p.setEmp(emp);
		eletronicDAO.save(p);
	}

	public Errors queryPrescrition(String outpaitentRegistId) {
		System.err.println(outpaitentRegistId);
		if(outpaitentRegistId != null){
			OutpaitentRegist regist = outpaitentDAO.findOne(outpaitentRegistId);
			try {
				String p = regist.getPrescriptions().get(0).getPrescriptionId();
				return new Errors(true, p);
			} catch (Exception e) {
				return new Errors(e.getMessage());
			}
		}
		return new Errors(false);
	}
	
	
}
