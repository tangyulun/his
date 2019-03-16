package com.ssh.vo.doctor;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

/**
 * 医疗项目vo
 * @author Administrator
 *
 */
public class HospitalProjectVo {
	private String id;
	private String financialId;
	private String financialName;
	private BigDecimal financialPrice;
	private BigDecimal financialMoney;
	private String financialTypeName;
	private BigDecimal financialNum;
	private String financialzt;
	private Date date;
	private String time;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFinancialId() {
		return financialId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFinancialId(String financialId) {
		this.financialId = financialId;
	}
	public String getFinancialName() {
		return financialName;
	}
	public void setFinancialName(String financialName) {
		this.financialName = financialName;
	}
	public BigDecimal getFinancialPrice() {
		return financialPrice;
	}
	public void setFinancialPrice(BigDecimal financialPrice) {
		this.financialPrice = financialPrice;
	}
	public BigDecimal getFinancialMoney() {
		return financialMoney;
	}
	public void setFinancialMoney(BigDecimal financialMoney) {
		this.financialMoney = financialMoney;
	}
	public String getFinancialTypeName() {
		return financialTypeName;
	}
	public void setFinancialTypeName(String financialTypeName) {
		this.financialTypeName = financialTypeName;
	}
	public BigDecimal getFinancialNum() {
		return financialNum;
	}
	public void setFinancialNum(BigDecimal financialNum) {
		this.financialNum = financialNum;
	}
	public String getFinancialzt() {
		return financialzt;
	}
	public void setFinancialzt(String financialzt) {
		this.financialzt = financialzt;
	}
	public HospitalProjectVo(String financialId, String financialName, BigDecimal financialPrice,
			BigDecimal financialMoney, String financialTypeName, BigDecimal financialNum, String financialzt) {
		super();
		this.financialId = financialId;
		this.financialName = financialName;
		this.financialPrice = financialPrice;
		this.financialMoney = financialMoney;
		this.financialTypeName = financialTypeName;
		this.financialNum = financialNum;
		this.financialzt = financialzt;
	}
	
	
	public HospitalProjectVo(String financialId, BigDecimal financialNum, BigDecimal financialPrice,
			 String financialzt) {
		super();
		this.financialId = financialId;
		this.financialNum = financialNum;
		this.financialPrice = financialPrice;
		this.financialzt = financialzt;
	}

	
	public HospitalProjectVo(String financialId) {
		super();
		this.financialId = financialId;
	}

	public HospitalProjectVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HospitalProjectVo [id=" + id + ", financialId=" + financialId + ", financialName=" + financialName
				+ ", financialPrice=" + financialPrice + ", financialMoney=" + financialMoney + ", financialTypeName="
				+ financialTypeName + ", financialNum=" + financialNum + ", financialzt=" + financialzt + "]";
	}
	
	
}
