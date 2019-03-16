package com.ssh.service.outpatient;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssh.dao.jpa.dclass.IDClassDAO;
import com.ssh.dao.jpa.doctor.IPrescriCodeDao;
import com.ssh.dao.jpa.login.LoginDao;
import com.ssh.dao.jpa.outpatient.IFinancialDao;
import com.ssh.dao.jpa.outpatient.IFinancialTypeDao;
import com.ssh.dao.jpa.outpatient.IMedicalcardDao;
import com.ssh.dao.jpa.outpatient.IOutpaitentDAO;
import com.ssh.dao.jpa.outpatient.IPrescriptionTypeDAO;
import com.ssh.dao.mybatis.outpatient.IMedicalDao;
import com.ssh.dao.mybatis.outpatient.IOutPatientRegistDao;
import com.ssh.pojos.Dclass;
import com.ssh.pojos.Emp;
import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialHistory;
import com.ssh.pojos.FinancialType;
import com.ssh.pojos.MedicalCard;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.pojos.PrescriptionRecode;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.login.EmpVo;
import com.ssh.vo.outpatient.FinacialVo;
import com.ssh.vo.outpatient.FinancialTypeVo;
import com.ssh.vo.outpatient.MedicalVo;
import com.ssh.vo.outpatient.OutRegistChargesVo;
import com.ssh.vo.outpatient.OutRegistDayCountVo;
import com.ssh.vo.outpatient.OutRegistVo;
import com.ssh.vo.outpatient.OutpatientVo;
import com.ssh.vo.outpatient.ParentTypeVo;

@Service
@Transactional
public class OutPatientRegistService {

	@Autowired
	private IOutpaitentDAO outpaitentDAO;
	@Autowired
	private IPrescriptionTypeDAO IPDAO;
	@Autowired
	private IMedicalcardDao medicalDao;
	@Autowired
	private IMedicalDao mediDao;//高级查询
	@Autowired
	private IFinancialDao finanDao;
	@Autowired
	private IFinancialTypeDao finaTypeDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private IDClassDAO dclassDao;
	@Autowired
	private IOutPatientRegistDao outPatientDao;//高级查询
	@Autowired
	private IPrescriCodeDao codeDao;
	
	
	/**
	 * 绑定门诊与处方之间的关系
	 * @return
	 */
	public List<OutpatientVo> queryAllOut(){
		List<OutpatientVo> list = outpaitentDAO.queryAll();
		for (OutpatientVo oV : list) {
			oV.setPrescriptionTypes(IPDAO.selectAll(outpaitentDAO.findOne(oV.getOutpaitentRegistId())));
		}
		return list;
	}
	
	/**
	 * 生成门诊号
	 */
	public String RNumber(){
		return outpaitentDAO.selectLikeNumber(CommentOrder.dateLike());
	}
	
	/**
	 * 生成就诊卡编号
	 * 
	 */
	public  String medicalCard(){
		String str = medicalDao.selectMaxCard();
		if(str == null){
			return "NO:000001";
		}else{
			Integer integer =Integer.parseInt(str.substring(3, str.length()))+1;
			String st = "";
			if(Integer.toString(integer).length() < 6){
				for (int i = 0; i < 6 - (Integer.toString(integer).length()); i++) {
					st +="0";
				}
			}
			return "NO:" + st + integer;
		}
	}
	
	/**
	 * 生成收费项目编号
	 */
	public String queryfinancialId(){
		String str = finanDao.queryFinancialWhere();
		if(str==null){
			return "100001";
		}else{
			Integer integer = Integer.parseInt(str)+1;
			return ""+integer;
		}
	}
	
	/**
	 * 增加卡记录
	 */
	public Errors addCard(MedicalCard medical){
		try {
			 medicalDao.save(medical);
			 return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 查询卡记录
	 */
	public List<MedicalVo> queryAll(int currPage,int pageSize){
		PageRequest page = new PageRequest(currPage - 1, pageSize);
		return medicalDao.queryMedical(page);
	}
	
	public long count(){
		return medicalDao.count();
	}
	
	/**
	 * 通过编号查询所有
	 */
	public List<MedicalVo> queryMedicalIdWhere(int page,int rows,String medicalId){
		PageRequest pages = new PageRequest(page - 1, rows);
		return medicalDao.queryMedicalIdWhere("%"+medicalId+"%", pages);
	}
	/**
	 * 通过编号模糊查询记录数
	 * @param MedicalId
	 * @return
	 */
	public long queryMedicalCont(String MedicalId){
		return medicalDao.selectMedicalCount("%"+MedicalId+"%");
	}

	/**
	 * 高级查询卡号记录
	 * @param page
	 * @param rows
	 * @param startTime
	 * @param endTime
	 * @param medicalId
	 * @return
	 */
	Page<?> pages ;
	public List<MedicalVo> queryDateAndString(int page, int rows, Date startTime, Date endTime, String searcherId) {
		pages = PageHelper.startPage(page,rows);
		return mediDao.selectMedical(startTime, endTime, "".equals(searcherId) ? null : "%"+ searcherId + "%");
	}

	public long queryDScount() {
		return pages.getTotal();
	}
	
	/**
	 * 查询所有项目
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<FinacialVo> queryFinacialAll(int page,int rows){
		PageRequest pages = new PageRequest(page - 1, rows);
		List<FinacialVo> list = finanDao.queryFinacialAll(pages);
		findByTypes(list);
		return list;
	}
	
	public long queryFinaCount(){
		return finanDao.count();
	}
	
	/**
	 * 查询收费项目类型
	 * @return
	 */
	public List<ParentTypeVo> queryFinancType(){
		List<FinancialTypeVo> list = finaTypeDao.queryFunanType();
		List<ParentTypeVo> parentVo = new ArrayList<>();
		parentVo.add(new ParentTypeVo(1 , "收费项目分类结构", list));
		return parentVo;
	}
	
	public List<FinancialTypeVo> queryFinancialId(){
		return finaTypeDao.queryFunanType();
	}
	
	/**
	 * 新增收费项目
	 */
	public Errors addFinancial(Financial finan,String financialTypeId,Long empId){
		try {
			FinancialType financialType = finaTypeDao.findOne(financialTypeId);
			Emp emp = loginDao.findOne(empId);
			finan.setEmp(emp);
			finan.setFinancialTypeBean(financialType);
			finanDao.save(finan);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 修改收费项目
	 * @param finaId 
	 */
	public Errors updateFinancial(Financial finan,String financialTypeId){
		try {
			Financial f = finanDao.findOne(finan.getFinancialId());
			FinancialType type = finaTypeDao.findOne(financialTypeId);
			f.setFinancialCreatorDate(finan.getFinancialCreatorDate());
			f.setFinancialExplain(finan.getFinancialExplain());
			f.setFinancialMoney(finan.getFinancialMoney());
			f.setFinancialName(finan.getFinancialName());
			f.setFinancialPrice(finan.getFinancialPrice());
			f.setFinancialType(finan.getFinancialType());
			f.setFinancialTypeBean(type);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
		
	}
	
	/**
	 * 通过收费类型id查询
	 * @param page
	 * @param rows
	 * @param financialTypeId
	 * @return
	 */
	public List<FinacialVo> queryFinancialTypeId(int page, int rows, String financialTypeId) {
		if(financialTypeId != null){
			FinancialType ft = finaTypeDao.findOne(financialTypeId);
			List<FinacialVo> list =  finanDao.finByTypeFinancial(ft , new PageRequest(page - 1, rows));
			findByTypes(list);
			return list;
		}
		return null;
	}
	
	public long queryFTCount(String financialTypeId){
		FinancialType ft = finaTypeDao.findOne(financialTypeId);
		return finanDao.finByTypeFinancialCount(ft);
	}
	
	/**
	 * 通过收费项目名模糊查询
	 */
	public List<FinacialVo> queryFinancialNameWhere(int page,int rows,String financialName){
		List<FinacialVo> list =  finanDao.queryFinancialNameWhere("%"+financialName+"%", new PageRequest(page - 1, rows));
		findByTypes(list);
		return list;
	}

	private void findByTypes(List<FinacialVo> list) {
		for (FinacialVo f : list) {
			f.setFinanTypeVo(finaTypeDao.queryFinancialTypeName(finanDao.findOne(f.getFinancialId())));
		}
	}
	
	public long queryFinanNameCount(String financialName){
		return finanDao.financialTypeNameCount("%"+financialName+"%");
	}
	
	/**
	 * 新增分类名
	 * @param ft
	 * @return
	 */
	public Errors addFinancialTypeName(FinancialType ft){
		try {
			ft.setFinancialTypeId(finaTypeDao.selectMaxId()+"");
			finaTypeDao.save(ft);
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 修改分类名
	 */
	public Errors updataFinancialTypeName(String financialTypeId,String financialTypeName){
		try {
			FinancialType ft = finaTypeDao.findOne(financialTypeId);
			ft.setFinancialTypeName(financialTypeName);
			return new Errors(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}
	
	/**
	 * 验证分类码是否唯一
	 */
	public Errors regexFinanTypeName(String finanTypeName){
		FinancialType ftype = finaTypeDao.regexFTypaName(finanTypeName);
		return ftype == null ? new Errors(true) : new Errors();
	}
	
	/**
	 * 新增挂号信息
	 * @param state 
	 * @param outpaitentRegistGuahaosj 
	 */
	public Errors addRegistinfo(Long empId, Long dclassId,String medicalCardCardId, OutpaitentRegist regist, String state){
		try {
			System.err.println(state);
			if("未处理".equals(state)){
				insert_out(empId, dclassId, medicalCardCardId, regist ,state);
			}else{
				OutpaitentRegist outp = outpaitentDAO.findOne(regist.getOutpaitentRegistId());
				if(outp != null){
					outp.setOutpaitentRegistZhuangtai(state);
				}else{
					insert_out(empId, dclassId, medicalCardCardId, regist ,state);
				}
			}
			//保存收费项目信息记录
			return new Errors(true);
		} catch (Exception e) {
			e.printStackTrace();
			return new Errors(e.getMessage());
		}
	}

	private void insert_out(Long empId, Long dclassId, String medicalCardCardId, OutpaitentRegist regist, String state) {
		Emp emp = loginDao.findOne(empId);
		Dclass keshi = dclassDao.findOne(dclassId);
		MedicalCard medical = medicalDao.findOne(medicalCardCardId);
		regist.setDclass(keshi);
		regist.setEmp(emp);
		regist.setMedicalCard(medical);
		regist.setOutpaitentRegistZhuangtai(state);
		outpaitentDAO.save(regist);
	}
	
	

	/**
	 * 高级查询历史门诊
	 */
	public List<OutRegistVo> queryOutRgistAndTime(String registSearcher, String registType,
			Date registStartTime, Date registEndTime) {
		System.err.println(registSearcher +registType+registStartTime+registEndTime);
		List<OutRegistVo> list = outPatientDao.selectOutRegistAndTime("".equals(registSearcher) ? null : "%" +registSearcher+"%" ,
				"".equals(registType) ? null : "%" +registType+"%", registStartTime,registEndTime);
		for (OutRegistVo p : list) {
			p.setOutpaitentRegistGuahaoTime(new SimpleDateFormat("yyyy-MM-dd").format(p.getOutpaitentRegistGuahaodate())
					+" "+p.getOutpaitentRegistGuahaoTime());
		}
		return list;
	}
	
	
	/**
	 * 历史门诊为空查询所有
	 */
	public List<OutRegistVo> queryOutRegist(String medicalCardCardId){
		List<OutRegistVo> list = null;
		if(medicalCardCardId !=null){
			MedicalCard  medical = medicalDao.findOne(medicalCardCardId);
		    list =  outpaitentDAO.queryOutRegistAll(medical);
		    selectDclassToO(list);
		}else{
			 list =  outpaitentDAO.queryOutRegist();
			  selectDclassToO(list);
		}
		return list;
	}

	private void selectDclassToO(List<OutRegistVo> list) {
		for (OutRegistVo o : list) {
			o.setId(o.getOutpaitentRegistId());
			
			if(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getDclass() != null){
				o.setDclass(new DClassVO(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getDclass().getDclassId(), 
						outpaitentDAO.findOne(o.getOutpaitentRegistId()).getDclass().getDclassName()));
			}
			if(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getEmp() != null){
				o.setEmp(new EmpVo(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getEmp().getEmpId(),
						outpaitentDAO.findOne(o.getOutpaitentRegistId()).getEmp().getEmpLoginName()));
			}
			
			MedicalCard c = outpaitentDAO.findOne(o.getOutpaitentRegistId()).getMedicalCard();
			if(c != null){
				o.setMedical(new MedicalVo(c.getMedicalCardCardId(),c.getMedicalCardAge(),c.getMedicalCardBingzhuang(),c.getMedicalCardDate(),c.getMedicalCardHunyanzk(),c.getMedicalCardIdencard(),c.getMedicalCardName(),c.getMedicalCardSex()));
			}
			
			o.setOutpaitentRegistGuahaoTime(o.getOutpaitentRegistGuahaodate()+" "+o.getOutpaitentRegistGuahaoTime());
			
			o.setEletronicId(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getPrescriptions().isEmpty() ? null : outpaitentDAO.findOne(o.getOutpaitentRegistId()).getPrescriptions().get(0).getPrescriptionId());
		}
	}
	
	public long queryOutRegistAllCount(String medicalCardCardId){
		if(medicalCardCardId !=null){
			MedicalCard medical = medicalDao.findOne(medicalCardCardId);
			return outpaitentDAO.queryOutRegistAllCount(medical);
		}
		return outpaitentDAO.queryOutRegistAllCountAll();
	}
	
	/**
	 * 通过id模糊查询历史门诊
	 */
	public List<OutRegistVo>  queryRegistLike(String outpaitentRegistId , String medicalCardId){
		List<OutRegistVo> list =  outpaitentDAO.queryoutpaitentRegistIdLike("%"+outpaitentRegistId+"%",  medicalDao.findOne(medicalCardId));
		selectDclassToO(list);
		return list;
	}
	
	public long queryRegistIdCount(String outpaitentRegistId , String medicalCainrdId){
		return outpaitentDAO.queryRegistIdCount("%" +outpaitentRegistId+ "%", medicalDao.findOne(medicalCainrdId));
	}
	
	
	public List<OutRegistVo>  SelectRegistDataLikesID(String outpaitentRegistId){
		List<OutRegistVo> listp =  outpaitentDAO.queryoutpaitentRegistDataIdLike("%"+outpaitentRegistId+"%");
		selectDclassToO(listp);
		return listp;
	}
	
	public long queryRegistIdDataCount(String outpaitentRegistId){
		return outpaitentDAO.queryRegistIdDataCount("%"+outpaitentRegistId +"%");
	}
	
	
	/**
	 * 通过收费项目编号查询收费名称 
	 */
	public  FinacialVo queryFinancialNameWhere(String financialId){
		Financial fc = finanDao.findOne(financialId);
		return fc == null ? null : new FinacialVo(fc.getFinancialId(), fc.getFinancialMoney(), fc.getFinancialName());
	}
	
	/**
	 * 查询所有的挂号记录,datagrid
	 */
	public List<OutRegistVo> selectOutRegistAll(int page, int rows){
		List<OutRegistVo> list= outpaitentDAO.selectOutRegistAll(new PageRequest(page - 1, rows));
		selectDclassToO(list);
		return list;
	}
	
	public long selectOutRegistAllCount(){
		return outpaitentDAO.count();
	}
	
	/**
	 * 查询收费记录下拉框所有编号
	 */
	public List<FinacialVo> queryFinancialIds(){
		return finanDao.queryFinancialId();
	}

	/**
	 * 高级查询挂号页面的信息
	 */
	public List<OutRegistVo> queryRegistDataGrid(int page, int rows, Date registdataStartTime, Date registdataEndTime,
			String registdataSearcher) {
		pag = PageHelper.startPage(page, rows);
		List<OutRegistVo> outgistVo = outPatientDao.selectDataGridRegistAndTime(registdataStartTime, registdataEndTime, 
					"" .equals(registdataSearcher) ? null : "%" +registdataSearcher+ "%");
		for (OutRegistVo o : outgistVo) {
			o.setOutpaitentRegistGuahaoTime(new SimpleDateFormat("yyyy-MM-dd").format(o.getOutpaitentRegistGuahaodate())
					+" "+o.getOutpaitentRegistGuahaoTime());
		}
		return outgistVo;
	}

	/**
	 * 高级查询门诊记录表
	 * 高级查询
	 */
	Page<?> pag;
	public List<OutRegistVo> queryOutRegistCodeAll(int page, int rows, String outregistqkSearchbox,
			Date outregistqkStartTime, Date outregistqkEndTime, String outregistqkztCombobox) {
		pag = PageHelper.startPage(page,rows);
		List<OutRegistVo> out = outPatientDao.selectRegistCode("".equals(outregistqkSearchbox) ? null : "%" +outregistqkSearchbox+ "%",
				outregistqkStartTime,outregistqkEndTime,"全部".equals(outregistqkztCombobox) ? null : outregistqkztCombobox);
		
		for (OutRegistVo o : out) {
			o.setOutpaitentRegistGuahaoTime(new SimpleDateFormat("yyyy-MM-dd").format(o.getOutpaitentRegistGuahaodate())
					+" "+o.getOutpaitentRegistGuahaoTime());
			o.setEletronicId(outpaitentDAO.findOne(o.getOutpaitentRegistId()).getPrescriptions().isEmpty() ? null : outpaitentDAO.findOne(o.getOutpaitentRegistId()).getPrescriptions().get(0).getPrescriptionId());
		}
		return out;
	}

	public long queryRegistCodeCount() {
		return pag.getTotal();
	}

	/**
	 * 查询门诊情况总表
	 * @param outRegistId
	 * @param eletronicId
	 * @return
	 */
	
	public List<OutRegistChargesVo> queryOutRegistCodeXQ(String outRegistId, String eletronicId) {
		System.err.println(outRegistId +"" +eletronicId);
		List<OutRegistChargesVo> out = new ArrayList<>();
		if(outRegistId != null){
			OutpaitentRegist o = outpaitentDAO.findOne(outRegistId);
			if(o.getFinancialHistories() != null){
				//查看收费历史记录
				List<FinancialHistory> f = o.getFinancialHistories();
				for (FinancialHistory h : f) {
					OutRegistChargesVo  r = new OutRegistChargesVo();
					r.setFinancialHistoryId(h.getFinancialHistoryId());
					r.setFinancialHistoryShoufeiName(h.getFinancial().getFinancialName());
					r.setFinancialHistoryShoufeilx(h.getFinancialHistoryShoufeilx());
					r.setFinancialHistoryNum(h.getFinancialHistoryNum());
					r.setFinancialHistoryPrice(h.getFinancial().getFinancialPrice());
					r.setFinancialHistoryShoufeije(new BigDecimal(h.getFinancialHistoryNum().intValue() * h.getFinancial().getFinancialPrice().doubleValue()));
					r.setFinancialHistoryShoufeizt(h.getFinancialHistoryShoufeizt());
					r.setPrescriptionRecodeExplain(h.getFinancial().getFinancialExplain());
					r.setFinancialHistoryShoufeisj(h.getFinancialHistoryShoufeirq() +" "+ h.getFinancialHistoryShoufeisj());
					out.add(r);
				}
			}
		}
		
		if(eletronicId != null){
			List<PrescriptionRecode> code = (List<PrescriptionRecode>) codeDao.findAll();
			for (PrescriptionRecode c : code) {
				if(c.getPrescriptionId().equals(eletronicId)){
					OutRegistChargesVo  r = new OutRegistChargesVo();
					r.setFinancialHistoryId(c.getPrescriptionId());
					r.setFinancialHistoryShoufeiName(c.getDrug().getDrugName());
					r.setFinancialHistoryShoufeilx(c.getPrescriptionRecodeDrugType());
					r.setFinancialHistoryNum(c.getPrescriptionRecodeNum());
					r.setFinancialHistoryPrice(c.getPrescriptionRecodePrice());
					r.setFinancialHistoryShoufeije(new BigDecimal(c.getPrescriptionRecodeNum().intValue() * c.getPrescriptionRecodePrice().doubleValue()));
					r.setFinancialHistoryShoufeizt(c.getPrescriptionRecodeZt());
					r.setPrescriptionRecodeExplain(c.getPrescriptionRecodeExplain());
					r.setFinancialHistoryShoufeisj(c.getPrescriptionRecodeRq() +" "+ c.getPrescriptionRecodeSj());
					out.add(r);
				}
			}
		}
		return out;
	}
	
	public List<OutRegistDayCountVo> queryDayCount(String month){
		List<OutRegistDayCountVo> list = new ArrayList<>();
		try {
			List<Object[]> o = outpaitentDAO.queryregistDayCount(month);
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2018-"+month+"-01"));
			int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int i = 1; i <= day; i++) {
				for (int j = 0; j < o.size(); j++) {
					if(Integer.parseInt(o.get(j)[0].toString()) == i){
						list.add(new OutRegistDayCountVo(i,Integer.parseInt(o.get(j)[1].toString()),Integer.parseInt(o.get(j)[1].toString())));
						break;
					}else if(j == o.size()-1){
						list.add(new OutRegistDayCountVo(i,0,0));
						break;
					}
				}
				if(o.size() == 0){
					list.add(new OutRegistDayCountVo(i,0,0));
				}
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

}
