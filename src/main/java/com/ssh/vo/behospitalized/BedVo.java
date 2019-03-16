package com.ssh.vo.behospitalized;

import java.util.Date;

public class BedVo {
	
	private String bedId;
	
	private Date bedCreateDate;
	
	private String bedName;
	
	private String bedRemark;

	private String houseBingqu;

	private String houseState;

	private BedTypeVo bedType;
	
	private EmpVo emp;
	
	private HouseTypeVo houseType;

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

	public String getHouseBingqu() {
		return houseBingqu;
	}

	public void setHouseBingqu(String houseBingqu) {
		this.houseBingqu = houseBingqu;
	}

	public String getHouseState() {
		return houseState;
	}

	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}

	public BedTypeVo getBedType() {
		return bedType;
	}

	public void setBedType(BedTypeVo bedType) {
		this.bedType = bedType;
	}

	public EmpVo getEmp() {
		return emp;
	}

	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}

	public HouseTypeVo getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseTypeVo houseType) {
		this.houseType = houseType;
	}

	public BedVo(String bedId, Date bedCreateDate, String bedName, String bedRemark, String houseBingqu,
			String houseState, BedTypeVo bedType, com.ssh.vo.behospitalized.EmpVo emp, HouseTypeVo houseType) {
		super();
		this.bedId = bedId;
		this.bedCreateDate = bedCreateDate;
		this.bedName = bedName;
		this.bedRemark = bedRemark;
		this.houseBingqu = houseBingqu;
		this.houseState = houseState;
		this.bedType = bedType;
		this.emp = emp;
		this.houseType = houseType;
	}

	public BedVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BedVo(String bedId, Date bedCreateDate, String bedName, String bedRemark, String houseBingqu,
			String houseState) {
		super();
		this.bedId = bedId;
		this.bedCreateDate = bedCreateDate;
		this.bedName = bedName;
		this.bedRemark = bedRemark;
		this.houseBingqu = houseBingqu;
		this.houseState = houseState;
	}

	public BedVo(String bedId, String bedName) {
		super();
		this.bedId = bedId;
		this.bedName = bedName;
	}

	public BedVo(String bedName) {
		super();
		this.bedName = bedName;
	}

	
	
}
