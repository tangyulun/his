package com.ssh.controller.outpatient;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.pojos.Financial;
import com.ssh.pojos.FinancialType;
import com.ssh.pojos.MedicalCard;
import com.ssh.pojos.OutpaitentRegist;
import com.ssh.service.doctor.ElectronicService;
import com.ssh.service.outpatient.FinancialHistoryService;
import com.ssh.service.outpatient.FinancialVMService;
import com.ssh.service.outpatient.OutPatientRegistService;
import com.ssh.service.outpatient.OutpatientChargeService;
import com.ssh.service.outpatient.PrescriptionService;
import com.ssh.utils.CommentOrder;
import com.ssh.utils.Errors;
import com.ssh.vo.outpatient.FinacialVo;
import com.ssh.vo.outpatient.FinancialHistoryVo;
import com.ssh.vo.outpatient.FinancialTypeVo;
import com.ssh.vo.outpatient.MedicalVo;
import com.ssh.vo.outpatient.OutRegistChargesVo;
import com.ssh.vo.outpatient.OutRegistDayCountVo;
import com.ssh.vo.outpatient.OutRegistVo;
import com.ssh.vo.outpatient.OutpatientVo;
import com.ssh.vo.outpatient.ParentTypeVo;
import com.ssh.vo.outpatient.PrescriptionTypesVo;

@Controller
public class OutpatientController {

	@Autowired
	private OutPatientRegistService outPatientService;
	@Autowired
	private PrescriptionService preService;
	@Autowired
	private OutpatientChargeService chargeService;
	@Autowired
	private ElectronicService eletronicService;
	@Autowired
	private FinancialVMService financialVMService;
	@Autowired
	private FinancialHistoryService historyService;
	
	@RequestMapping("/go_registration")
	public String go_registration(){
		return "outpatient/registration";
	}
	
	@RequestMapping("/go_registselect")
	public String go_registselect(){
		return "outpatient/registselect";
	}
	
	@RequestMapping("/go_eletronicselect")
	public String go_eletronicselect(){
		return "outpatient/eletronicselect";
	}
	
	@RequestMapping("/queryall_outpatient")
	public String queryAll(){
		List<OutpatientVo> listOutpatient = outPatientService.queryAllOut();
		for (OutpatientVo outpatientVo : listOutpatient) {
			System.out.println(outpatientVo.getOutpaitentRegistId());
			for (PrescriptionTypesVo patientVo : outpatientVo.getPrescriptionTypes()) {
				System.out.println(patientVo.getPrespricedId());
			}
		}
		return null;
	}
	
	@GetMapping("/r_number")
	@ResponseBody
	public String RNumber(){
		return CommentOrder.commOrder(outPatientService.RNumber(), "MG");
	}
	
	@GetMapping("/pre_number")
	@ResponseBody
	public String pre_Number(){
		return CommentOrder.commOrder(preService.selectLikeNumber(), "MH");
	}
	
	@GetMapping("/charge_number")
	@ResponseBody
	public String charge_Number(){
		return CommentOrder.commOrder(chargeService.selectLikeNUmber(), "MS");
	}
	
	@GetMapping("/eletronic_number")
	@ResponseBody
	public String eletronic_Number(){
		return CommentOrder.commOrder(eletronicService.selectLikeNUmber(), "DF");
	}
	
	//生成卡号
	@GetMapping("/medical_card")
	@ResponseBody
	public String medicalCard(){
		return outPatientService.medicalCard();
	}
	
	//新增卡记录
	@PostMapping("/addMedical")
	@ResponseBody
	public Errors addMedical(MedicalCard medical){
		return outPatientService.addCard(medical);
	}
	
	//查询所有卡记录
	@GetMapping("/queryMedical")
	@ResponseBody
	public Map<String,Object> queryAll(int page,int rows){
		List<MedicalVo> list = outPatientService.queryAll(page, rows);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.count());
		map.put("rows", list);
		return map;
	}
	
	
	//通过卡号查询所有
	@GetMapping("/queryMedical_where_Id")
	@ResponseBody
	public Map<String,Object> queryMedicalWhere(int page,int rows,String MedicalId){
		List<MedicalVo> listm = outPatientService.queryMedicalIdWhere(page, rows, MedicalId);
		Map<String,Object> maps = new HashMap<>();
		maps.put("total", outPatientService.queryMedicalCont(MedicalId));
		maps.put("rows", listm);
		return maps;
	}
	
	//高级查询卡号
	@GetMapping("/queryDate_and_String")
	@ResponseBody
	public Map<String,Object> queryDateAndString(int page, int rows ,Date startTime,Date endTime,String searcherId){
		List<MedicalVo> listo = outPatientService.queryDateAndString(page, rows ,startTime,endTime,searcherId);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.queryDScount());
		map.put("rows", listo);
		return map;
	}
	
	//查询所有项目
	@GetMapping("/query_financial_all")
	@ResponseBody
	public Map<String,Object> queryFinancial(int page,int rows){
		List<FinacialVo> list = outPatientService.queryFinacialAll(page, rows);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.queryFinaCount());
		map.put("rows", list);
		return map;
	}
	
	@GetMapping("/query_financial_type")
	@ResponseBody
	public List<ParentTypeVo> queryFinanType(){
		return outPatientService.queryFinancType();
	}
	
	//生成收费项目编号
	@GetMapping("/query_finanicalid")
	@ResponseBody
	public String queryFinanicalWhere(){
		return outPatientService.queryfinancialId();
	}
	
	//查询收费项目分类
	@GetMapping("/query_fianaical_fenlei")
	@ResponseBody
	public List<FinancialTypeVo> queryFinancial(){
		return outPatientService.queryFinancialId();
	}
	
	//新增收费项目
	@PostMapping("/add_financial")
	@ResponseBody
	public Errors addFinancial(Financial financial,String financialTypeId,Long empId){
		return outPatientService.addFinancial(financial,financialTypeId,empId);
	}
	
	//修改收费项目
	@PostMapping("/update_financial")
	@ResponseBody
	public Errors update_financial(Financial financial,String financialTypeId){
		return outPatientService.updateFinancial(financial, financialTypeId);
	}
	
	//通过收费类型id查询
	@GetMapping("/query_financial_all_where")
	@ResponseBody
	public Map<String,Object> queryFinancialType(int page,int rows,String financialTypeId){
		List<FinacialVo> list = outPatientService.queryFinancialTypeId(page , rows , financialTypeId);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.queryFTCount(financialTypeId));
		map.put("rows", list);
		return map;
	}
	
	//通过收费项目名模糊查询
	@GetMapping("/query_financialName_where")
	@ResponseBody
	public Map<String , Object> queryFinancialNameWhere(int page,int rows,String financialName){
		List<FinacialVo> list = outPatientService.queryFinancialNameWhere(page, rows, financialName);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.queryFinanNameCount(financialName));
		map.put("rows", list);
		return map;
	}
	
	//添加收费类型名称
	@PostMapping("/add_financialTypeName")
	@ResponseBody
	public Errors addFinancialTypeName(FinancialType ft){
		return outPatientService.addFinancialTypeName(ft);
	}
	
	//修改收费类型名称
	@GetMapping("/update_financialTypeName")
	@ResponseBody
	public Errors updataFinancialTypeName(String financialTypeId,String financialTypeName){
		return outPatientService.updataFinancialTypeName(financialTypeId, financialTypeName);
	}
	
	//验证分类名是否唯一
	@PostMapping("/regex_fianTypeName")
	@ResponseBody
	public Errors regexFinancialTypeName(String finanTypeName){
		return outPatientService.regexFinanTypeName(finanTypeName);
	}
	
	//查询选项卡收费项目
	@GetMapping("/query_financialxm")
	@ResponseBody
	public  Map<String,Object> queryFinancialXM(int page, int rows){
		 List<FinacialVo> list = financialVMService.queryFinancialXM(page, rows);
		 Map<String,Object> map = new HashMap<>();
		 map.put("total", financialVMService.queryFinancialXMCount());
		 map.put("rows", list);
		 return map;
	}
	
	//新增收费记录
	@GetMapping("/addfinancial_code")
	@ResponseBody
	public Errors addFinancialCode(FinancialHistoryVo historyVo){
		return  historyService.addFinancialCode(historyVo);
	}
	
	//删除收费记录
	@GetMapping("/deletes_code")
	@ResponseBody
	public Errors deletesCode(String ids){
		return  historyService.deletesCode(CommentOrder.dealString(ids));
	}
	
	//查询收费记录
	@GetMapping("/query_FinancialHistory")
	@ResponseBody
	public List<FinancialHistoryVo> queryFinancialHistoryVo(){
		return historyService.queryFinancialHistory();
	}
	
	@GetMapping("/clear_history")
	@ResponseBody
	public void clearHistory(){
		historyService.clearHistory();
	}
	
	/** 
	 * 获取系统当前时间
	 */
	@GetMapping("/current_Time")
	@ResponseBody
	public String  currentTime(){
		return new SimpleDateFormat("hh:mm:ss").format(new Date());
	}
	
	/**
	 * 新增挂号
	 */
	@PostMapping("/add_registInfo")
	@ResponseBody
	public Errors addRegistinfo(Long empId, Long dclassId, String medicalCardCardId, OutpaitentRegist regist , String state){
		Errors error =  outPatientService.addRegistinfo(empId, dclassId,medicalCardCardId, regist , state);
		historyService.saveSFJL(regist , state);
		return error;
	}
	@GetMapping("/query_regist_time")
	@ResponseBody
	public List<OutRegistVo>  queryOutRgistAndTime(String registSearcher,String registType,Date registStartTime,Date registEndTime){
		List<OutRegistVo> list = outPatientService.queryOutRgistAndTime(registSearcher,registType,registStartTime,registEndTime);
		return list;
	}

	//历史门诊为空查询所有
	@GetMapping("/query_history_registall")
	@ResponseBody
	public  List<OutRegistVo>  queryOutRegistAll(String medicalCardCardId){
		 List<OutRegistVo> list = outPatientService.queryOutRegist(medicalCardCardId);
		 return list;
	}
	
	/**
	 * 通过门诊id模糊查询
	 * @param page
	 * @param rows
	 * @param outpaitentRegistId
	 * @return
	 */
	@GetMapping("/query_regist_like")
	@ResponseBody
	public List<OutRegistVo>  queryRegistLike(String outpaitentRegistId,String medicalCardId){
		List<OutRegistVo> list = outPatientService.queryRegistLike(outpaitentRegistId,medicalCardId);
		return list;
	}
	
	@GetMapping("/query_registdata_like")
	@ResponseBody
	public List<OutRegistVo> SelectRegistDataLikes(String outpaitentRegistId){
		List<OutRegistVo> list = outPatientService.SelectRegistDataLikesID(outpaitentRegistId);
		return list;
	}
	

	/**
	 * 通过收费项目编号查询收费名称 按下鼠标点击
	 */
	@GetMapping("/query_financialName_whereId")
	@ResponseBody
	public FinacialVo queryFinancialNameWhere(String financialId){
		return outPatientService.queryFinancialNameWhere(financialId);
	}
	
	/**
	 * 查询所有的挂号信息
	 */
	@GetMapping("/select_outRegist_all")
	@ResponseBody
	public Map<String,Object> selectOutRegistAll(int page, int rows){
		List<OutRegistVo> list = outPatientService.selectOutRegistAll(page, rows);
		Map<String,Object> map =new HashMap<>();
		map.put("total", outPatientService.selectOutRegistAllCount());
		map.put("rows", list);
		return map;
	} 
	
	/**
	 * 查询收费记录下拉框所有编号
	 */
	@GetMapping("/queryFinan")
	@ResponseBody
	public List<FinacialVo> queryFinan(){
		return outPatientService.queryFinancialIds();
	}
	
	/**
	 * 点击选择挂号的时候查询收费记录
	 */
	@GetMapping("/query_financial_code_tbs")
	@ResponseBody
	public List<FinancialHistoryVo> queryFinancialHistory(String outpaitentRegistId){
		return historyService.queryFinancialCode(outpaitentRegistId);
		
	}
	
	/**
	 * 点击搜素高级查询选择挂号页面的信息
	 */
	@GetMapping("/query_gaojiregistration")
	@ResponseBody
	public Map<String , Object> queryRegistDataGrid(int page,int rows,Date registdataStartTime,Date registdataEndTime,String registdataSearcher){
		List<OutRegistVo> list = outPatientService.queryRegistDataGrid(page,rows,registdataStartTime,registdataEndTime,registdataSearcher);
		Map<String,Object> map = new HashMap<>();
		map.put("total", outPatientService.queryRegistCodeCount());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询门诊记录表 
	 * 高级查询
	 */
	@GetMapping("/query_outregist_sumcode")
	@ResponseBody
	public Map<String,Object> queryRegistCode(int page,int rows,String outregistqkSearchbox ,Date outregistqkStartTime,Date outregistqkEndTime,String outregistqkztCombobox){
		List<OutRegistVo> list = outPatientService.queryOutRegistCodeAll(page,rows,outregistqkSearchbox,outregistqkStartTime,outregistqkEndTime,outregistqkztCombobox); 
		Map<String , Object> map = new HashMap<>();
		map.put("total", outPatientService.queryRegistCodeCount());
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 查询门诊记录详情表
	 * @return
	 */
	@GetMapping("/query_outregistcodexq")
	@ResponseBody
	public List<OutRegistChargesVo> queryOutRegistSumCodeXQ(String outRegistId,String eletronicId){
		return outPatientService.queryOutRegistCodeXQ(outRegistId,eletronicId);
	}
	
	@GetMapping("/query_dayCount")
	@ResponseBody
	public List<OutRegistDayCountVo> queryDayCount(String month){
		return outPatientService.queryDayCount(month);
	}
}
