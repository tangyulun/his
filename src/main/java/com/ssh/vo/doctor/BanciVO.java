package com.ssh.vo.doctor;

import javax.persistence.Column;
import javax.persistence.Id;

public class BanciVO {

	private long bclassesId;

	private String bclassesBetTime;

	private String bclassesColor;

	private String bclassesName;

	private String bclassesType;

	public long getBclassesId() {
		return bclassesId;
	}

	public void setBclassesId(long bclassesId) {
		this.bclassesId = bclassesId;
	}

	public String getBclassesBetTime() {
		return bclassesBetTime;
	}

	public void setBclassesBetTime(String bclassesBetTime) {
		this.bclassesBetTime = bclassesBetTime;
	}

	public String getBclassesColor() {
		return bclassesColor;
	}

	public void setBclassesColor(String bclassesColor) {
		this.bclassesColor = bclassesColor;
	}

	public String getBclassesName() {
		return bclassesName;
	}

	public void setBclassesName(String bclassesName) {
		this.bclassesName = bclassesName;
	}

	public String getBclassesType() {
		return bclassesType;
	}

	public void setBclassesType(String bclassesType) {
		this.bclassesType = bclassesType;
	}

	public BanciVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BanciVO(long bclassesId, String bclassesBetTime, String bclassesColor, String bclassesName,
			String bclassesType) {
		super();
		this.bclassesId = bclassesId;
		this.bclassesBetTime = bclassesBetTime;
		this.bclassesColor = bclassesColor;
		this.bclassesName = bclassesName;
		this.bclassesType = bclassesType;
	}
	
	

}
