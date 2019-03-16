package com.ssh.vo.doctor;

import java.util.Date;

public class ChuQinVO {
	private Long empId;
	private String empLoginName;
	private String deptName;
	private String dclassName;
	private Integer benYueDays;
	private Integer yiGuoDays;
	private Integer chuqinDays;
	private Integer queQinDays;
	private Double chuqinLv;
	
	
	private Date chuqinDate;
	
	public Date getChuqinDate() {
		return chuqinDate;
	}

	public void setChuqinDate(Date chuqinDate) {
		this.chuqinDate = chuqinDate;
	}

	public Long getEmpId() {
		return empId;
	}
	
	public Integer getYiGuoDays() {
		return yiGuoDays;
	}

	public void setYiGuoDays(Integer yiGuoDays) {
		this.yiGuoDays = yiGuoDays;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpLoginName() {
		return empLoginName;
	}
	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDclassName() {
		return dclassName;
	}
	public void setDclassName(String dclassName) {
		this.dclassName = dclassName;
	}
	public Integer getBenYueDays() {
		return benYueDays;
	}
	public void setBenYueDays(Integer benYueDays) {
		this.benYueDays = benYueDays;
	}
	public Integer getChuqinDays() {
		return chuqinDays;
	}
	public void setChuqinDays(Integer chuqinDays) {
		this.chuqinDays = chuqinDays;
	}
	public Integer getQueQinDays() {
		return queQinDays;
	}
	public void setQueQinDays(Integer queQinDays) {
		this.queQinDays = queQinDays;
	}
	public Double getChuqinLv() {
		return chuqinLv;
	}
	public void setChuqinLv(Double chuqinLv) {
		this.chuqinLv = chuqinLv;
	}
	public ChuQinVO(Long empId, String empLoginName, String deptName, String dclassName, Integer benYueDays,
			Integer chuqinDays, Integer queQinDays, Double chuqinLv) {
		super();
		this.empId = empId;
		this.empLoginName = empLoginName;
		this.deptName = deptName;
		this.dclassName = dclassName;
		this.benYueDays = benYueDays;
		this.chuqinDays = chuqinDays;
		this.queQinDays = queQinDays;
		this.chuqinLv = chuqinLv;
	}
	public ChuQinVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
