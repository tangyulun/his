package com.ssh.vo.dean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BingChuangVO {
	
	private String bedId;

	private Date bedCreateDate;

	private String bedName;

	private String bedRemark;

	private String bingchaungType;

	private String houseState;
	
	private String BingRenName;
	
	private String BongRenSex;
	
	private String bingchuangWeizhi;

	private  Date ruYaundate;
	
	
	public Date getRuYaundate() {
		return ruYaundate;
	}

	public void setRuYaundate(Date ruYaundate) {
		this.ruYaundate = ruYaundate;
	}

	public BingChuangVO(String bedId, Date bedCreateDate, String bedName, String bedRemark, String bingchaungType,
			String houseState, String bingRenName, String bongRenSex, String bingchuangWeizhi) {
		super();
		this.bedId = bedId;
		this.bedCreateDate = bedCreateDate;
		this.bedName = bedName;
		this.bedRemark = bedRemark;
		this.bingchaungType = bingchaungType;
		this.houseState = houseState;
		BingRenName = bingRenName;
		BongRenSex = bongRenSex;
		this.bingchuangWeizhi = bingchuangWeizhi;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public Date getBedCreateDate() {
		return bedCreateDate;
	}

	public void setBedCreateDate(Date bedCreateDate) {
		this.bedCreateDate = bedCreateDate;
	}

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public String getBedRemark() {
		return bedRemark;
	}

	public void setBedRemark(String bedRemark) {
		this.bedRemark = bedRemark;
	}

	public String getBingchaungType() {
		return bingchaungType;
	}

	public void setBingchaungType(String bingchaungType) {
		this.bingchaungType = bingchaungType;
	}

	
	public String getHouseState() {
		return houseState;
	}

	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}

	public String getBingRenName() {
		return BingRenName;
	}

	public void setBingRenName(String bingRenName) {
		BingRenName = bingRenName;
	}

	public String getBongRenSex() {
		return BongRenSex;
	}

	public void setBongRenSex(String bongRenSex) {
		BongRenSex = bongRenSex;
	}

	public String getBingchuangWeizhi() {
		return bingchuangWeizhi;
	}

	public void setBingchuangWeizhi(String bingchuangWeizhi) {
		this.bingchuangWeizhi = bingchuangWeizhi;
	}

	public BingChuangVO(String bedId, Date bedCreateDate, String bedName, String bedRemark, String houseState) {
		super();
		this.bedId = bedId;
		this.bedCreateDate = bedCreateDate;
		this.bedName = bedName;
		this.bedRemark = bedRemark;
		this.houseState = houseState;
	}

	public BingChuangVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BingChuangVO [bedId=" + bedId + ", bedCreateDate=" + bedCreateDate + ", bedName=" + bedName
				+ ", bedRemark=" + bedRemark + ", houseState=" + houseState + "]";
	}
	
	
	
}
