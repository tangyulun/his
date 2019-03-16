package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

import com.ssh.pojos.DrugType;
import com.ssh.pojos.Supplier;
import com.ssh.pojos.Unit;

public class DrugVo {
	private String drugId;

	private String drugBname;

	private String drugBz;

	private String drugBzdate;

	private String drugCf;

	private String drugGg;

	private String drugJx;

	private BigDecimal drugLsprice;

	private String drugLx;

	private String drugName;

	private BigDecimal drugPfprice;

	private String drugSccj;

	private String drugShr;

	private String drugYf;

	private String drugZt;
	
	private DrugTypeVo drugType;
	
	private SupplierVo supplier;
	
	private UnitVo unit;
	
	private YaokuKucunVo yaokuKucun;
	

	public YaokuKucunVo getYaokuKucun() {
		return yaokuKucun;
	}

	public void setYaokuKucun(YaokuKucunVo yaokuKucun) {
		this.yaokuKucun = yaokuKucun;
	}

	public SupplierVo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}

	public UnitVo getUnit() {
		return unit;
	}

	public void setUnit(UnitVo unit) {
		this.unit = unit;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugType(DrugTypeVo drugType) {
		this.drugType = drugType;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	
	public DrugTypeVo getDrugType() {
		return drugType;
	}

	public String getDrugBname() {
		return drugBname;
	}

	public void setDrugBname(String drugBname) {
		this.drugBname = drugBname;
	}

	public String getDrugBz() {
		return drugBz;
	}

	public void setDrugBz(String drugBz) {
		this.drugBz = drugBz;
	}

	public String getDrugBzdate() {
		return drugBzdate;
	}

	public void setDrugBzdate(String drugBzdate) {
		this.drugBzdate = drugBzdate;
	}

	public String getDrugCf() {
		return drugCf;
	}

	public void setDrugCf(String drugCf) {
		this.drugCf = drugCf;
	}

	public String getDrugGg() {
		return drugGg;
	}

	public void setDrugGg(String drugGg) {
		this.drugGg = drugGg;
	}

	public String getDrugJx() {
		return drugJx;
	}

	public void setDrugJx(String drugJx) {
		this.drugJx = drugJx;
	}

	public BigDecimal getDrugLsprice() {
		return drugLsprice;
	}

	public void setDrugLsprice(BigDecimal drugLsprice) {
		this.drugLsprice = drugLsprice;
	}

	public String getDrugLx() {
		return drugLx;
	}

	public void setDrugLx(String drugLx) {
		this.drugLx = drugLx;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public BigDecimal getDrugPfprice() {
		return drugPfprice;
	}

	public void setDrugPfprice(BigDecimal drugPfprice) {
		this.drugPfprice = drugPfprice;
	}

	public String getDrugSccj() {
		return drugSccj;
	}

	public void setDrugSccj(String drugSccj) {
		this.drugSccj = drugSccj;
	}

	public String getDrugShr() {
		return drugShr;
	}

	public void setDrugShr(String drugShr) {
		this.drugShr = drugShr;
	}

	public String getDrugYf() {
		return drugYf;
	}

	public void setDrugYf(String drugYf) {
		this.drugYf = drugYf;
	}

	public String getDrugZt() {
		return drugZt;
	}

	public void setDrugZt(String drugZt) {
		this.drugZt = drugZt;
	}


	public DrugVo(String drugId, String drugBname, String drugBz, String drugBzdate, String drugCf, String drugGg,
			String drugJx, BigDecimal drugLsprice, String drugLx, String drugName, BigDecimal drugPfprice,
			String drugSccj, String drugShr, String drugYf, String drugZt) {
		super();
		this.drugId = drugId;
		this.drugBname = drugBname;
		this.drugBz = drugBz;
		this.drugBzdate = drugBzdate;
		this.drugCf = drugCf;
		this.drugGg = drugGg;
		this.drugJx = drugJx;
		this.drugLsprice = drugLsprice;
		this.drugLx = drugLx;
		this.drugName = drugName;
		this.drugPfprice = drugPfprice;
		this.drugSccj = drugSccj;
		this.drugShr = drugShr;
		this.drugYf = drugYf;
		this.drugZt = drugZt;
	}

	public DrugVo(String drugId, String drugName) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
	}

	public DrugVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DrugVo [drugId=" + drugId + ", drugBname=" + drugBname + ", drugBz=" + drugBz + ", drugBzdate="
				+ drugBzdate + ", drugCf=" + drugCf + ", drugGg=" + drugGg + ", drugJx=" + drugJx + ", drugLsprice="
				+ drugLsprice + ", drugLx=" + drugLx + ", drugName=" + drugName + ", drugPfprice=" + drugPfprice
				+ ", drugSccj=" + drugSccj + ", drugShr=" + drugShr + ", drugYf=" + drugYf + ", drugZt=" + drugZt
				+ ", drugType=" + drugType + ", supplier=" + supplier + ", unit=" + unit + ", yaokuKucun=" + yaokuKucun
				+ "]";
	}

}
