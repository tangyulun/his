package com.ssh.vo.behospitalized;

import java.util.Date;

public class HHQixeVo {
	private int id;
	private String qixebianhao;
	private String qixename;
	private String hhdanhao;
	private Date hhdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQixebianhao() {
		return qixebianhao;
	}
	public void setQixebianhao(String qixebianhao) {
		this.qixebianhao = qixebianhao;
	}
	public String getQixename() {
		return qixename;
	}
	public void setQixename(String qixename) {
		this.qixename = qixename;
	}
	public String getHhdanhao() {
		return hhdanhao;
	}
	public void setHhdanhao(String hhdanhao) {
		this.hhdanhao = hhdanhao;
	}
	public Date getHhdate() {
		return hhdate;
	}
	public void setHhdate(Date hhdate) {
		this.hhdate = hhdate;
	}
	public HHQixeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HHQixeVo(int id, String qixebianhao, String qixename, String hhdanhao, Date hhdate) {
		super();
		this.id = id;
		this.qixebianhao = qixebianhao;
		this.qixename = qixename;
		this.hhdanhao = hhdanhao;
		this.hhdate = hhdate;
	}
	
	
}
