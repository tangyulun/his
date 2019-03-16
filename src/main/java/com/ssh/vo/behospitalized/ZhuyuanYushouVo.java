package com.ssh.vo.behospitalized;

import java.math.BigDecimal;
import java.util.Date;
import com.ssh.pojos.RushShouqu;

public class ZhuyuanYushouVo {
	
	private long zhuyuanYushouId;
	
	private Date zhuyuanYushouDate;
	
	private BigDecimal zhuyuanYushouMoney;
	
	private String zhuyuanYushouState;

	private RushShouqu rushShouqu;

	public long getZhuyuanYushouId() {
		return zhuyuanYushouId;
	}

	public void setZhuyuanYushouId(long zhuyuanYushouId) {
		this.zhuyuanYushouId = zhuyuanYushouId;
	}

	public Date getZhuyuanYushouDate() {
		return zhuyuanYushouDate;
	}

	public void setZhuyuanYushouDate(Date zhuyuanYushouDate) {
		this.zhuyuanYushouDate = zhuyuanYushouDate;
	}

	public BigDecimal getZhuyuanYushouMoney() {
		return zhuyuanYushouMoney;
	}

	public void setZhuyuanYushouMoney(BigDecimal zhuyuanYushouMoney) {
		this.zhuyuanYushouMoney = zhuyuanYushouMoney;
	}

	public String getZhuyuanYushouState() {
		return zhuyuanYushouState;
	}

	public void setZhuyuanYushouState(String zhuyuanYushouState) {
		this.zhuyuanYushouState = zhuyuanYushouState;
	}

	public RushShouqu getRushShouqu() {
		return rushShouqu;
	}

	public void setRushShouqu(RushShouqu rushShouqu) {
		this.rushShouqu = rushShouqu;
	}

	public ZhuyuanYushouVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZhuyuanYushouVo(long zhuyuanYushouId, Date zhuyuanYushouDate, BigDecimal zhuyuanYushouMoney,
			String zhuyuanYushouState, RushShouqu rushShouqu) {
		super();
		this.zhuyuanYushouId = zhuyuanYushouId;
		this.zhuyuanYushouDate = zhuyuanYushouDate;
		this.zhuyuanYushouMoney = zhuyuanYushouMoney;
		this.zhuyuanYushouState = zhuyuanYushouState;
		this.rushShouqu = rushShouqu;
	}

	@Override
	public String toString() {
		return "ZhuyuanYushouVo [zhuyuanYushouId=" + zhuyuanYushouId + ", zhuyuanYushouDate=" + zhuyuanYushouDate
				+ ", zhuyuanYushouMoney=" + zhuyuanYushouMoney + ", zhuyuanYushouState=" + zhuyuanYushouState
				+ ", rushShouqu=" + rushShouqu + "]";
	}
	
	
}
