package com.ssh.vo.nurse;

import java.math.BigDecimal;
import java.util.Date;

public class ZhuyuanZhiliaojizhangVo {
	private int id;
	
	private String financialId;
	private String financialName;
	private BigDecimal number;
	private BigDecimal money;
	private String state;
	private String chufanhao;
	private String shoufeileixing;
	private Date shoufeiDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFinancialId() {
		return financialId;
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
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChufanhao() {
		return chufanhao;
	}
	public void setChufanhao(String chufanhao) {
		this.chufanhao = chufanhao;
	}
	
	public String getShoufeileixing() {
		return shoufeileixing;
	}
	public void setShoufeileixing(String shoufeileixing) {
		this.shoufeileixing = shoufeileixing;
	}
	public Date getShoufeiDate() {
		return shoufeiDate;
	}
	public void setShoufeiDate(Date shoufeiDate) {
		this.shoufeiDate = shoufeiDate;
	}
	public ZhuyuanZhiliaojizhangVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZhuyuanZhiliaojizhangVo(int id, String financialId, String financialName, BigDecimal number,
			BigDecimal money, String state, String chufanhao) {
		super();
		this.id = id;
		this.financialId = financialId;
		this.financialName = financialName;
		this.number = number;
		this.money = money;
		this.state = state;
		this.chufanhao = chufanhao;
	}
	
	public ZhuyuanZhiliaojizhangVo(int id, String financialId, String financialName, BigDecimal number,
			BigDecimal money, String state, String chufanhao, String shoufeileixing) {
		super();
		this.id = id;
		this.financialId = financialId;
		this.financialName = financialName;
		this.number = number;
		this.money = money;
		this.state = state;
		this.chufanhao = chufanhao;
		this.shoufeileixing = shoufeileixing;
	}
	public ZhuyuanZhiliaojizhangVo(int id, String financialId, String financialName, BigDecimal number,
			BigDecimal money, String state, String chufanhao, String shoufeileixing, Date shoufeiDate) {
		super();
		this.id = id;
		this.financialId = financialId;
		this.financialName = financialName;
		this.number = number;
		this.money = money;
		this.state = state;
		this.chufanhao = chufanhao;
		this.shoufeileixing = shoufeileixing;
		this.shoufeiDate = shoufeiDate;
	}
	
	
}
