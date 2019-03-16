package com.ssh.vo.staff;

import java.util.Date;

public class RoleVO {
	private long rolesId;
	private Date rolesDate;
	private String rolesEffect;
	private String rolesName;
	
	private boolean isFrag;
	
	public boolean isFrag() {
		return isFrag;
	}
	public void setFrag(boolean isFrag) {
		this.isFrag = isFrag;
	}
	public long getRolesId() {
		return rolesId;
	}
	public Date getRolesDate() {
		return rolesDate;
	}
	public String getRolesEffect() {
		return rolesEffect;
	}
	public String getRolesName() {
		return rolesName;
	}
	public void setRolesId(long rolesId) {
		this.rolesId = rolesId;
	}
	public void setRolesDate(Date rolesDate) {
		this.rolesDate = rolesDate;
	}
	public void setRolesEffect(String rolesEffect) {
		this.rolesEffect = rolesEffect;
	}
	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	public RoleVO(long rolesId, Date rolesDate, String rolesEffect, String rolesName) {
		super();
		this.rolesId = rolesId;
		this.rolesDate = rolesDate;
		this.rolesEffect = rolesEffect;
		this.rolesName = rolesName;
	}
	public RoleVO() {
		super();
	}
	
	
	
	/*
	 * 字段 +值
	 */
	private String attr;
	private Object values;

	public String getAttr() {
		return attr;
	}
	public Object getValues() {
		return values;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public void setValues(Object values) {
		this.values = values;
	}
	public RoleVO(String attr, Object values) {
		super();
		this.attr = attr;
		this.values = values;
	}
	public RoleVO(long rolesId, Date rolesDate, String rolesName) {
		super();
		this.rolesId = rolesId;
		this.rolesDate = rolesDate;
		this.rolesName = rolesName;
	}
	
	
	
}
