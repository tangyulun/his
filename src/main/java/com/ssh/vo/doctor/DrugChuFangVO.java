package com.ssh.vo.doctor;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

import com.ssh.vo.drugstorage.DrugTypeVo;
import com.ssh.vo.drugstorage.UnitVo;

public class DrugChuFangVO {
	private String drugId;
	
	private String drugBname;
	
	private BigDecimal drugLsprice;
	
	private BigDecimal drugPfprice;
	 
	private KuCunVO kukun;
	
	private DrugTypeVo type;
	
	private UnitVo unit;

	public DrugChuFangVO(String drugId, String drugBname, BigDecimal drugLsprice) {
		super();
		this.drugId = drugId;
		this.drugBname = drugBname;
		this.drugLsprice = drugLsprice;
	}

	public DrugChuFangVO(String drugId, String drugBname, BigDecimal drugLsprice, BigDecimal drugPfprice) {
		super();
		this.drugId = drugId;
		this.drugBname = drugBname;
		this.drugLsprice = drugLsprice;
		this.drugPfprice = drugPfprice;
	}

	public BigDecimal getDrugPfprice() {
		return drugPfprice;
	}

	public void setDrugPfprice(BigDecimal drugPfprice) {
		this.drugPfprice = drugPfprice;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugBname() {
		return drugBname;
	}

	public void setDrugBname(String drugBname) {
		this.drugBname = drugBname;
	}

	public BigDecimal getDrugLsprice() {
		return drugLsprice;
	}

	public void setDrugLsprice(BigDecimal drugLsprice) {
		this.drugLsprice = drugLsprice;
	}

	public KuCunVO getKukun() {
		return kukun;
	}

	public void setKukun(KuCunVO kukun) {
		this.kukun = kukun;
	}

	public DrugTypeVo getType() {
		return type;
	}

	public void setType(DrugTypeVo type) {
		this.type = type;
	}

	public UnitVo getUnit() {
		return unit;
	}

	public void setUnit(UnitVo unit) {
		this.unit = unit;
	}
	
	
}
