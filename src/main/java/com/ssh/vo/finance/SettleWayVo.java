package com.ssh.vo.finance;

public class SettleWayVo {
	private String settleWayId;

	private String settleWayName;

	public String getSettleWayId() {
		return settleWayId;
	}

	public void setSettleWayId(String settleWayId) {
		this.settleWayId = settleWayId;
	}

	public String getSettleWayName() {
		return settleWayName;
	}

	public void setSettleWayName(String settleWayName) {
		this.settleWayName = settleWayName;
	}

	public SettleWayVo(String settleWayId, String settleWayName) {
		super();
		this.settleWayId = settleWayId;
		this.settleWayName = settleWayName;
	}

	public SettleWayVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
