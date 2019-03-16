package com.ssh.vo.drugstorage;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.vo.staff.EmpVO;

public class DrugPurchaseVo {
	private String drugPurchaseId;

	private Date drugPurchaseDhdate;

	private Date drugPurchaseGhdate;

	private String drugPurchaseJhdz;

	private BigDecimal drugPurchaseMoney;

	private String drugPurchaseZt;
	
	private EmpVO emp;
	
	private SupplierVo supplier;

	public String getDrugPurchaseId() {
		return drugPurchaseId;
	}

	public void setDrugPurchaseId(String drugPurchaseId) {
		this.drugPurchaseId = drugPurchaseId;
	}

	public Date getDrugPurchaseDhdate() {
		return drugPurchaseDhdate;
	}

	public void setDrugPurchaseDhdate(Date drugPurchaseDhdate) {
		this.drugPurchaseDhdate = drugPurchaseDhdate;
	}

	public Date getDrugPurchaseGhdate() {
		return drugPurchaseGhdate;
	}

	public void setDrugPurchaseGhdate(Date drugPurchaseGhdate) {
		this.drugPurchaseGhdate = drugPurchaseGhdate;
	}

	public String getDrugPurchaseJhdz() {
		return drugPurchaseJhdz;
	}

	public void setDrugPurchaseJhdz(String drugPurchaseJhdz) {
		this.drugPurchaseJhdz = drugPurchaseJhdz;
	}

	public BigDecimal getDrugPurchaseMoney() {
		return drugPurchaseMoney;
	}

	public void setDrugPurchaseMoney(BigDecimal drugPurchaseMoney) {
		this.drugPurchaseMoney = drugPurchaseMoney;
	}

	public String getDrugPurchaseZt() {
		return drugPurchaseZt;
	}

	public void setDrugPurchaseZt(String drugPurchaseZt) {
		this.drugPurchaseZt = drugPurchaseZt;
	}

	public EmpVO getEmp() {
		return emp;
	}

	public void setEmp(EmpVO emp) {
		this.emp = emp;
	}

	public SupplierVo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}

	public DrugPurchaseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrugPurchaseVo(String drugPurchaseId, Date drugPurchaseDhdate, Date drugPurchaseGhdate,
			String drugPurchaseJhdz, BigDecimal drugPurchaseMoney, String drugPurchaseZt, EmpVO emp,
			SupplierVo supplier) {
		super();
		this.drugPurchaseId = drugPurchaseId;
		this.drugPurchaseDhdate = drugPurchaseDhdate;
		this.drugPurchaseGhdate = drugPurchaseGhdate;
		this.drugPurchaseJhdz = drugPurchaseJhdz;
		this.drugPurchaseMoney = drugPurchaseMoney;
		this.drugPurchaseZt = drugPurchaseZt;
		this.emp = emp;
		this.supplier = supplier;
	}
	

	public DrugPurchaseVo(BigDecimal drugPurchaseMoney) {
		super();
		this.drugPurchaseMoney = drugPurchaseMoney;
	}

	public DrugPurchaseVo(String drugPurchaseId, SupplierVo supplier) {
		super();
		this.drugPurchaseId = drugPurchaseId;
		this.supplier = supplier;
	}

	public DrugPurchaseVo(String drugPurchaseId, Date drugPurchaseDhdate, Date drugPurchaseGhdate,
			String drugPurchaseJhdz, BigDecimal drugPurchaseMoney, String drugPurchaseZt) {
		super();
		this.drugPurchaseId = drugPurchaseId;
		this.drugPurchaseDhdate = drugPurchaseDhdate;
		this.drugPurchaseGhdate = drugPurchaseGhdate;
		this.drugPurchaseJhdz = drugPurchaseJhdz;
		this.drugPurchaseMoney = drugPurchaseMoney;
		this.drugPurchaseZt = drugPurchaseZt;
	}

	@Override
	public String toString() {
		return "DrugPurchaseVo [drugPurchaseId=" + drugPurchaseId + ", drugPurchaseDhdate=" + drugPurchaseDhdate
				+ ", drugPurchaseGhdate=" + drugPurchaseGhdate + ", drugPurchaseJhdz=" + drugPurchaseJhdz
				+ ", drugPurchaseMoney=" + drugPurchaseMoney + ", drugPurchaseZt=" + drugPurchaseZt + ", emp=" + emp
				+ ", supplier=" + supplier + "]";
	}
	
	
}
