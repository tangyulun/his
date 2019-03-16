package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;

public class RushShouquVo {

	private String rushShouquId;
	private Date rushShouquDate;

	private String rushShouquState;

	private BigDecimal rushShouquYingshouMoney;

	private BigDecimal rushShouquYushouMoney;

	public String getRushShouquId() {
		return rushShouquId;
	}

	public void setRushShouquId(String rushShouquId) {
		this.rushShouquId = rushShouquId;
	}

	public Date getRushShouquDate() {
		return rushShouquDate;
	}

	public void setRushShouquDate(Date rushShouquDate) {
		this.rushShouquDate = rushShouquDate;
	}

	public String getRushShouquState() {
		return rushShouquState;
	}

	public void setRushShouquState(String rushShouquState) {
		this.rushShouquState = rushShouquState;
	}

	public BigDecimal getRushShouquYingshouMoney() {
		return rushShouquYingshouMoney;
	}

	public void setRushShouquYingshouMoney(BigDecimal rushShouquYingshouMoney) {
		this.rushShouquYingshouMoney = rushShouquYingshouMoney;
	}

	public BigDecimal getRushShouquYushouMoney() {
		return rushShouquYushouMoney;
	}

	public void setRushShouquYushouMoney(BigDecimal rushShouquYushouMoney) {
		this.rushShouquYushouMoney = rushShouquYushouMoney;
	}

	public RushShouquVo(String rushShouquId, Date rushShouquDate, String rushShouquState,
			BigDecimal rushShouquYingshouMoney, BigDecimal rushShouquYushouMoney) {
		super();
		this.rushShouquId = rushShouquId;
		this.rushShouquDate = rushShouquDate;
		this.rushShouquState = rushShouquState;
		this.rushShouquYingshouMoney = rushShouquYingshouMoney;
		this.rushShouquYushouMoney = rushShouquYushouMoney;
	}

	public RushShouquVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RushShouquVo(BigDecimal rushShouquYushouMoney) {
		super();
		this.rushShouquYushouMoney = rushShouquYushouMoney;
	}
	
}
