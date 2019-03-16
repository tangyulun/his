package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ZHUYUAN_FAYAO_XQ database table.
 * 
 */
@Entity
@Table(name="ZHUYUAN_FAYAO_XQ")
@NamedQuery(name="ZhuyuanFayaoXq.findAll", query="SELECT z FROM ZhuyuanFayaoXq z")
public class ZhuyuanFayaoXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_FAYAO_XQ_ID")
	private long zhuyuanFayaoXqId;

	@Column(name="ZHUYUAN_FAYAO_XQ_MONEY")
	private BigDecimal zhuyuanFayaoXqMoney;

	@Column(name="ZHUYUAN_FAYAO_XQ_NUMBER")
	private BigDecimal zhuyuanFayaoXqNumber;

	@Column(name="ZHUYUAN_FAYAO_XQ_PH")
	private String zhuyuanFayaoXqPh;

	@Column(name="ZHUYUAN_FAYAO_XQ_PRICE")
	private BigDecimal zhuyuanFayaoXqPrice;

	@Column(name="ZHUYUAN_FAYAO_XQ_REMARK")
	private String zhuyuanFayaoXqRemark;

	@Column(name="ZHUYUAN_FAYAO_XQ_STATE")
	private String zhuyuanFayaoXqState;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to ZhuyuanFayao
	@ManyToOne
	@JoinColumn(name="ZHUYUAN_FAYAO_ID")
	private ZhuyuanFayao zhuyuanFayao;

	public ZhuyuanFayaoXq() {
	}

	public long getZhuyuanFayaoXqId() {
		return this.zhuyuanFayaoXqId;
	}

	public void setZhuyuanFayaoXqId(long zhuyuanFayaoXqId) {
		this.zhuyuanFayaoXqId = zhuyuanFayaoXqId;
	}

	public BigDecimal getZhuyuanFayaoXqMoney() {
		return this.zhuyuanFayaoXqMoney;
	}

	public void setZhuyuanFayaoXqMoney(BigDecimal zhuyuanFayaoXqMoney) {
		this.zhuyuanFayaoXqMoney = zhuyuanFayaoXqMoney;
	}

	public BigDecimal getZhuyuanFayaoXqNumber() {
		return this.zhuyuanFayaoXqNumber;
	}

	public void setZhuyuanFayaoXqNumber(BigDecimal zhuyuanFayaoXqNumber) {
		this.zhuyuanFayaoXqNumber = zhuyuanFayaoXqNumber;
	}

	public String getZhuyuanFayaoXqPh() {
		return this.zhuyuanFayaoXqPh;
	}

	public void setZhuyuanFayaoXqPh(String zhuyuanFayaoXqPh) {
		this.zhuyuanFayaoXqPh = zhuyuanFayaoXqPh;
	}

	public BigDecimal getZhuyuanFayaoXqPrice() {
		return this.zhuyuanFayaoXqPrice;
	}

	public void setZhuyuanFayaoXqPrice(BigDecimal zhuyuanFayaoXqPrice) {
		this.zhuyuanFayaoXqPrice = zhuyuanFayaoXqPrice;
	}

	public String getZhuyuanFayaoXqRemark() {
		return this.zhuyuanFayaoXqRemark;
	}

	public void setZhuyuanFayaoXqRemark(String zhuyuanFayaoXqRemark) {
		this.zhuyuanFayaoXqRemark = zhuyuanFayaoXqRemark;
	}

	public String getZhuyuanFayaoXqState() {
		return this.zhuyuanFayaoXqState;
	}

	public void setZhuyuanFayaoXqState(String zhuyuanFayaoXqState) {
		this.zhuyuanFayaoXqState = zhuyuanFayaoXqState;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public ZhuyuanFayao getZhuyuanFayao() {
		return this.zhuyuanFayao;
	}

	public void setZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		this.zhuyuanFayao = zhuyuanFayao;
	}

}