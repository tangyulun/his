package com.ssh.vo.dean;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.vo.behospitalized.HospitalRegistrationVo;
import com.ssh.vo.nurse.PrescriptionVo;
import com.ssh.vo.outpatient.OutpatientVo;
import com.ssh.vo.outpatient.PrescriptionTypesVo;
import com.ssh.vo.staff.EmpVO;

/**
 * 药房发药
 * @author AnnPin
 *
 */
public class DrugHairVo {
	private String drugYaofangIId;//编号

	private Date drugYaofangDate;//发药日期

	private String drugYaofangState;//状态

	private String zhuyuanFayaoHouse;//药房

	private BigDecimal zhuyuanFayaoZmoney;//金额
	
	private String zhuyuanFayaoType;
	
	private EmpVO emp;//采购员
	
	private PrescriptionVo prescription;//处方号
	
	private HospitalRegistrationVo hospitalRegistration;//住院登记
	
	private OutpatientVo outpatien;//门诊

	public String getZhuyuanFayaoType() {
		return zhuyuanFayaoType;
	}

	public void setZhuyuanFayaoType(String zhuyuanFayaoType) {
		this.zhuyuanFayaoType = zhuyuanFayaoType;
	}

	public String getDrugYaofangIId() {
		return drugYaofangIId;
	}

	public void setDrugYaofangIId(String drugYaofangIId) {
		this.drugYaofangIId = drugYaofangIId;
	}

	public Date getDrugYaofangDate() {
		return drugYaofangDate;
	}

	public void setDrugYaofangDate(Date drugYaofangDate) {
		this.drugYaofangDate = drugYaofangDate;
	}

	public String getDrugYaofangState() {
		return drugYaofangState;
	}

	public void setDrugYaofangState(String drugYaofangState) {
		this.drugYaofangState = drugYaofangState;
	}

	public String getZhuyuanFayaoHouse() {
		return zhuyuanFayaoHouse;
	}

	public void setZhuyuanFayaoHouse(String zhuyuanFayaoHouse) {
		this.zhuyuanFayaoHouse = zhuyuanFayaoHouse;
	}

	public BigDecimal getZhuyuanFayaoZmoney() {
		return zhuyuanFayaoZmoney;
	}

	public void setZhuyuanFayaoZmoney(BigDecimal zhuyuanFayaoZmoney) {
		this.zhuyuanFayaoZmoney = zhuyuanFayaoZmoney;
	}

	public EmpVO getEmp() {
		return emp;
	}

	public void setEmp(EmpVO emp) {
		this.emp = emp;
	}

	public PrescriptionVo getPrescription() {
		return prescription;
	}

	public void setPrescription(PrescriptionVo prescription) {
		this.prescription = prescription;
	}

	public HospitalRegistrationVo getHospitalRegistration() {
		return hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistrationVo hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public OutpatientVo getOutpatien() {
		return outpatien;
	}

	public void setOutpatien(OutpatientVo outpatien) {
		this.outpatien = outpatien;
	}

	public DrugHairVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DrugHairVo(String drugYaofangIId, Date drugYaofangDate, String drugYaofangState, String zhuyuanFayaoHouse,
			BigDecimal zhuyuanFayaoZmoney, String zhuyuanFayaoType, EmpVO emp, PrescriptionVo prescription,
			HospitalRegistrationVo hospitalRegistration, OutpatientVo outpatien) {
		super();
		this.drugYaofangIId = drugYaofangIId;
		this.drugYaofangDate = drugYaofangDate;
		this.drugYaofangState = drugYaofangState;
		this.zhuyuanFayaoHouse = zhuyuanFayaoHouse;
		this.zhuyuanFayaoZmoney = zhuyuanFayaoZmoney;
		this.zhuyuanFayaoType = zhuyuanFayaoType;
		this.emp = emp;
		this.prescription = prescription;
		this.hospitalRegistration = hospitalRegistration;
		this.outpatien = outpatien;
	}

	public DrugHairVo(String drugYaofangIId, Date drugYaofangDate, String drugYaofangState, String zhuyuanFayaoHouse,
			BigDecimal zhuyuanFayaoZmoney, String zhuyuanFayaoType) {
		super();
		this.drugYaofangIId = drugYaofangIId;
		this.drugYaofangDate = drugYaofangDate;
		this.drugYaofangState = drugYaofangState;
		this.zhuyuanFayaoHouse = zhuyuanFayaoHouse;
		this.zhuyuanFayaoZmoney = zhuyuanFayaoZmoney;
		this.zhuyuanFayaoType = zhuyuanFayaoType;
	}

	public DrugHairVo(String drugYaofangIId) {
		super();
		this.drugYaofangIId = drugYaofangIId;
	}

	@Override
	public String toString() {
		return "DrugHairVo [drugYaofangIId=" + drugYaofangIId + ", drugYaofangDate=" + drugYaofangDate
				+ ", drugYaofangState=" + drugYaofangState + ", zhuyuanFayaoHouse=" + zhuyuanFayaoHouse
				+ ", zhuyuanFayaoZmoney=" + zhuyuanFayaoZmoney + ", zhuyuanFayaoType=" + zhuyuanFayaoType + ", emp="
				+ emp + ", prescription=" + prescription + ", hospitalRegistration=" + hospitalRegistration
				+ ", outpatien=" + outpatien + "]";
	}

	
}
