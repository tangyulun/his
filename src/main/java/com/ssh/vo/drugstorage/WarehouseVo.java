package com.ssh.vo.drugstorage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssh.pojos.DrugAcceptance;

public class WarehouseVo {
	private String drugWarehouseId;

	private String drugWarehouseCgy;

	private String drugWarehouseName;

	private String drugWarehousePzdh;

	private Date drugWarehouseRkdate;

	private String drugWarehouseRklx;

	private String drugWarehouseZt;
	
	private DrugAcceptance drugAcceptance;

	public String getDrugWarehouseId() {
		return drugWarehouseId;
	}

	public void setDrugWarehouseId(String drugWarehouseId) {
		this.drugWarehouseId = drugWarehouseId;
	}

	public String getDrugWarehouseCgy() {
		return drugWarehouseCgy;
	}

	public void setDrugWarehouseCgy(String drugWarehouseCgy) {
		this.drugWarehouseCgy = drugWarehouseCgy;
	}

	public String getDrugWarehouseName() {
		return drugWarehouseName;
	}

	public void setDrugWarehouseName(String drugWarehouseName) {
		this.drugWarehouseName = drugWarehouseName;
	}

	public String getDrugWarehousePzdh() {
		return drugWarehousePzdh;
	}

	public void setDrugWarehousePzdh(String drugWarehousePzdh) {
		this.drugWarehousePzdh = drugWarehousePzdh;
	}

	public Date getDrugWarehouseRkdate() {
		return drugWarehouseRkdate;
	}

	public void setDrugWarehouseRkdate(Date drugWarehouseRkdate) {
		this.drugWarehouseRkdate = drugWarehouseRkdate;
	}

	public String getDrugWarehouseRklx() {
		return drugWarehouseRklx;
	}

	public void setDrugWarehouseRklx(String drugWarehouseRklx) {
		this.drugWarehouseRklx = drugWarehouseRklx;
	}

	public String getDrugWarehouseZt() {
		return drugWarehouseZt;
	}

	public void setDrugWarehouseZt(String drugWarehouseZt) {
		this.drugWarehouseZt = drugWarehouseZt;
	}

	public DrugAcceptance getDrugAcceptance() {
		return drugAcceptance;
	}

	public void setDrugAcceptance(DrugAcceptance drugAcceptance) {
		this.drugAcceptance = drugAcceptance;
	}

	public WarehouseVo(String drugWarehouseId, String drugWarehouseCgy, String drugWarehouseName,
			String drugWarehousePzdh, Date drugWarehouseRkdate, String drugWarehouseRklx, String drugWarehouseZt) {
		super();
		this.drugWarehouseId = drugWarehouseId;
		this.drugWarehouseCgy = drugWarehouseCgy;
		this.drugWarehouseName = drugWarehouseName;
		this.drugWarehousePzdh = drugWarehousePzdh;
		this.drugWarehouseRkdate = drugWarehouseRkdate;
		this.drugWarehouseRklx = drugWarehouseRklx;
		this.drugWarehouseZt = drugWarehouseZt;
	}

	public WarehouseVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
