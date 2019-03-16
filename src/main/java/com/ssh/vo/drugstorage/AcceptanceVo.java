package com.ssh.vo.drugstorage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssh.pojos.DrugPurchase;

public class AcceptanceVo {
	private String drugAcceptanceId;

	private String drugAcceptancePzdh;

	private Date drugAcceptanceShdate;

	private String drugAcceptanceZt;
	
	private SupplierVo supplier;

	private DrugPurchaseVo drugPurchase;

	public SupplierVo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}

	public void setDrugPurchase(DrugPurchaseVo drugPurchase) {
		this.drugPurchase = drugPurchase;
	}

	public String getDrugAcceptanceId() {
		return drugAcceptanceId;
	}

	public void setDrugAcceptanceId(String drugAcceptanceId) {
		this.drugAcceptanceId = drugAcceptanceId;
	}

	public String getDrugAcceptancePzdh() {
		return drugAcceptancePzdh;
	}

	public void setDrugAcceptancePzdh(String drugAcceptancePzdh) {
		this.drugAcceptancePzdh = drugAcceptancePzdh;
	}

	public Date getDrugAcceptanceShdate() {
		return drugAcceptanceShdate;
	}

	public void setDrugAcceptanceShdate(Date drugAcceptanceShdate) {
		this.drugAcceptanceShdate = drugAcceptanceShdate;
	}

	public String getDrugAcceptanceZt() {
		return drugAcceptanceZt;
	}

	public void setDrugAcceptanceZt(String drugAcceptanceZt) {
		this.drugAcceptanceZt = drugAcceptanceZt;
	}

	public DrugPurchaseVo getDrugPurchase() {
		return drugPurchase;
	}

	public AcceptanceVo(String drugAcceptanceId, String drugAcceptancePzdh, Date drugAcceptanceShdate,
			String drugAcceptanceZt) {
		super();
		this.drugAcceptanceId = drugAcceptanceId;
		this.drugAcceptancePzdh = drugAcceptancePzdh;
		this.drugAcceptanceShdate = drugAcceptanceShdate;
		this.drugAcceptanceZt = drugAcceptanceZt;
	}

	public AcceptanceVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
