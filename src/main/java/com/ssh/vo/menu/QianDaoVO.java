package com.ssh.vo.menu;

import java.util.List;

public class QianDaoVO {
	private Integer qdId; // 签到编号
	private List<String> qdAllDate;//本月天数
	private List<Boolean> isFlag ; //是否签到
	private Integer maxDay;//本月最大的签到数
	private Integer qdDay; //签到天数
	private Integer NoDay;//缺勤天数
	private Integer moneyDay;
	
	
	public Integer getMoneyDay() {
		return moneyDay;
	}
	public void setMoneyDay(Integer moneyDay) {
		this.moneyDay = moneyDay;
	}
	public Integer getQdId() {
		return qdId;
	}
	public void setQdId(Integer qdId) {
		this.qdId = qdId;
	}
	public List<String> getQdAllDate() {
		return qdAllDate;
	}
	public void setQdAllDate(List<String> qdAllDate) {
		this.qdAllDate = qdAllDate;
	}
	public List<Boolean> getIsFlag() {
		return isFlag;
	}
	public void setIsFlag(List<Boolean> isFlag) {
		this.isFlag = isFlag;
	}
	public Integer getMaxDay() {
		return maxDay;
	}
	public void setMaxDay(Integer maxDay) {
		this.maxDay = maxDay;
	}
	public Integer getQdDay() {
		return qdDay;
	}
	public void setQdDay(Integer qdDay) {
		this.qdDay = qdDay;
	}
	public Integer getNoDay() {
		return NoDay;
	}
	public void setNoDay(Integer noDay) {
		NoDay = noDay;
	}
	public QianDaoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
