package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class ChufangVo {
	private int id;
	private String chufangHao;
	private String chufangState;
	private Date chufangDate;
	private String chufangYisheng;
	private BigDecimal chufangMoney;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChufangHao() {
		return chufangHao;
	}
	public void setChufangHao(String chufangHao) {
		this.chufangHao = chufangHao;
	}
	public String getChufangState() {
		return chufangState;
	}
	public void setChufangState(String chufangState) {
		this.chufangState = chufangState;
	}
	public Date getChufangDate() {
		return chufangDate;
	}
	public void setChufangDate(Date chufangDate) {
		this.chufangDate = chufangDate;
	}
	public String getChufangYisheng() {
		return chufangYisheng;
	}
	public void setChufangYisheng(String chufangYisheng) {
		this.chufangYisheng = chufangYisheng;
	}
	public BigDecimal getChufangMoney() {
		return chufangMoney;
	}
	public void setChufangMoney(BigDecimal chufangMoney) {
		this.chufangMoney = chufangMoney;
	}
	public ChufangVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChufangVo(int id, String chufangHao, String chufangState, Date chufangDate, String chufangYisheng,
			BigDecimal chufangMoney) {
		super();
		this.id = id;
		this.chufangHao = chufangHao;
		this.chufangState = chufangState;
		this.chufangDate = chufangDate;
		this.chufangYisheng = chufangYisheng;
		this.chufangMoney = chufangMoney;
	}
	public ChufangVo(int id, String chufangHao, String chufangState, Date chufangDate, String chufangYisheng) {
		super();
		this.id = id;
		this.chufangHao = chufangHao;
		this.chufangState = chufangState;
		this.chufangDate = chufangDate;
		this.chufangYisheng = chufangYisheng;
	}

	
}
