package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the YAJIN_TUIFEI database table.
 * 
 */
@Entity
@Table(name="YAJIN_TUIFEI")
@NamedQuery(name="YajinTuifei.findAll", query="SELECT y FROM YajinTuifei y")
public class YajinTuifei implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="YAJIN_TUIFEI_ID")
	private String yajinTuifeiId;

	@Column(name="YAJIN_TUIFEI_REMARK")
	private String yajinTuifeiRemark;

	@Column(name="YAJIN_TUIFEI_ST_JINE")
	private BigDecimal yajinTuifeiStJine;

	@Column(name="YAJIN_TUIFEI_STATE")
	private String yajinTuifeiState;

	@Column(name="YAJIN_TUIFEI_YT_JINE")
	private BigDecimal yajinTuifeiYtJine;

	@Column(name="YAJIN_TUIFEI_YUE")
	private BigDecimal yajinTuifeiYue;

	//bi-directional many-to-one association to ChuyuanInform
	@ManyToOne
	@JoinColumn(name="CHUYUAN_INFORM_ID")
	private ChuyuanInform chuyuanInform;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public YajinTuifei() {
	}

	public String getYajinTuifeiId() {
		return this.yajinTuifeiId;
	}

	public void setYajinTuifeiId(String yajinTuifeiId) {
		this.yajinTuifeiId = yajinTuifeiId;
	}

	public String getYajinTuifeiRemark() {
		return this.yajinTuifeiRemark;
	}

	public void setYajinTuifeiRemark(String yajinTuifeiRemark) {
		this.yajinTuifeiRemark = yajinTuifeiRemark;
	}

	public BigDecimal getYajinTuifeiStJine() {
		return this.yajinTuifeiStJine;
	}

	public void setYajinTuifeiStJine(BigDecimal yajinTuifeiStJine) {
		this.yajinTuifeiStJine = yajinTuifeiStJine;
	}

	public String getYajinTuifeiState() {
		return this.yajinTuifeiState;
	}

	public void setYajinTuifeiState(String yajinTuifeiState) {
		this.yajinTuifeiState = yajinTuifeiState;
	}

	public BigDecimal getYajinTuifeiYtJine() {
		return this.yajinTuifeiYtJine;
	}

	public void setYajinTuifeiYtJine(BigDecimal yajinTuifeiYtJine) {
		this.yajinTuifeiYtJine = yajinTuifeiYtJine;
	}

	public BigDecimal getYajinTuifeiYue() {
		return this.yajinTuifeiYue;
	}

	public void setYajinTuifeiYue(BigDecimal yajinTuifeiYue) {
		this.yajinTuifeiYue = yajinTuifeiYue;
	}

	public ChuyuanInform getChuyuanInform() {
		return this.chuyuanInform;
	}

	public void setChuyuanInform(ChuyuanInform chuyuanInform) {
		this.chuyuanInform = chuyuanInform;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}