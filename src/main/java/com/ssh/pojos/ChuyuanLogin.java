package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "chuyuan_login" database table.
 * 
 */
@Entity
@Table(name="\"chuyuan_login\"")
@NamedQuery(name="ChuyuanLogin.findAll", query="SELECT c FROM ChuyuanLogin c")
public class ChuyuanLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHUYUAN_LOGIN_ID")
	private String chuyuanLoginId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHUYUAN_LOGIN_DATE")
	private Date chuyuanLoginDate;

	@Column(name="CHUYUAN_LOGIN_STATE")
	private String chuyuanLoginState;

	//bi-directional many-to-one association to ChuyuanInform
	@ManyToOne
	@JoinColumn(name="CHUYUAN_INFORM_ID")
	private ChuyuanInform chuyuanInform;

	public ChuyuanLogin() {
	}

	public String getChuyuanLoginId() {
		return this.chuyuanLoginId;
	}

	public void setChuyuanLoginId(String chuyuanLoginId) {
		this.chuyuanLoginId = chuyuanLoginId;
	}

	public Date getChuyuanLoginDate() {
		return this.chuyuanLoginDate;
	}

	public void setChuyuanLoginDate(Date chuyuanLoginDate) {
		this.chuyuanLoginDate = chuyuanLoginDate;
	}

	public String getChuyuanLoginState() {
		return this.chuyuanLoginState;
	}

	public void setChuyuanLoginState(String chuyuanLoginState) {
		this.chuyuanLoginState = chuyuanLoginState;
	}

	public ChuyuanInform getChuyuanInform() {
		return this.chuyuanInform;
	}

	public void setChuyuanInform(ChuyuanInform chuyuanInform) {
		this.chuyuanInform = chuyuanInform;
	}

}