package com.ssh.vo.outpatient;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.vo.dclass.DClassVO;
import com.ssh.vo.login.EmpVo;

public class OutRegistVo {
	@JSONField(name="idField")
	private String id;
	@JSONField(name="treeField")
	private String outpaitentRegistId;
	
	private String outpaitentRegistType;
	
	private Date outpaitentRegistGuahaodate;
	
	private String outpaitentRegistGuahaoTime;
	
	private String outpaitentRegistZhuangtai;
	
	private EmpVo emp; 
	
	private DClassVO dclass;
	
	private MedicalVo medical;
	
	private String eletronicId;
	
	@JSONField(name="children")
	private List<FinancialHistoryVo2> fv;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<FinancialHistoryVo2>  getFv() {
		return fv;
	}
	public void setFv(List<FinancialHistoryVo2>  fv) {
		this.fv = fv;
	}
	public String getOutpaitentRegistGuahaoTime() {
		return outpaitentRegistGuahaoTime;
	}
	public void setOutpaitentRegistGuahaoTime(String outpaitentRegistGuahaoTime) {
		this.outpaitentRegistGuahaoTime = outpaitentRegistGuahaoTime;
	}
	public DClassVO getDclass() {
		return dclass;
	}
	public void setDclass(DClassVO dclass) {
		this.dclass = dclass;
	}
	public String getOutpaitentRegistId() {
		return outpaitentRegistId;
	}
	public void setOutpaitentRegistId(String outpaitentRegistId) {
		this.outpaitentRegistId = outpaitentRegistId;
	}
	public String getOutpaitentRegistType() {
		return outpaitentRegistType;
	}
	public void setOutpaitentRegistType(String outpaitentRegistType) {
		this.outpaitentRegistType = outpaitentRegistType;
	}
	public Date getOutpaitentRegistGuahaodate() {
		return outpaitentRegistGuahaodate;
	}
	public void setOutpaitentRegistGuahaodate(Date outpaitentRegistGuahaodate) {
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
	}
	
	public String getOutpaitentRegistZhuangtai() {
		return outpaitentRegistZhuangtai;
	}
	public void setOutpaitentRegistZhuangtai(String outpaitentRegistZhuangtai) {
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}
	public EmpVo getEmp() {
		return emp;
	}
	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}
	
	public MedicalVo getMedical() {
		return medical;
	}
	public void setMedical(MedicalVo medical) {
		this.medical = medical;
	}
	
	public String getEletronicId() {
		return eletronicId;
	}
	public void setEletronicId(String eletronicId) {
		this.eletronicId = eletronicId;
	}
	public OutRegistVo(String id, String outpaitentRegistId, String outpaitentRegistType,
			Date outpaitentRegistGuahaodate, String outpaitentRegistGuahaoTime) {
		super();
		this.id = id;
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaoTime = outpaitentRegistGuahaoTime;
	}
	
	public OutRegistVo(String outpaitentRegistId, String outpaitentRegistType, Date outpaitentRegistGuahaodate,
			String outpaitentRegistGuahaoTime, String outpaitentRegistZhuangtai) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaoTime = outpaitentRegistGuahaoTime;
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}
	
	
	public OutRegistVo(String outpaitentRegistId, String outpaitentRegistType, Date outpaitentRegistGuahaodate,
			String outpaitentRegistGuahaoTime) {
		super();
		this.outpaitentRegistId = outpaitentRegistId;
		this.outpaitentRegistType = outpaitentRegistType;
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
		this.outpaitentRegistGuahaoTime = outpaitentRegistGuahaoTime;
	}
	public OutRegistVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
