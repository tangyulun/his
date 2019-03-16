package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SHOUSHU_MESS_XQ database table.
 * 
 */
@Entity
@Table(name="SHOUSHU_MESS_XQ")
@NamedQuery(name="ShoushuMessXq.findAll", query="SELECT s FROM ShoushuMessXq s")
public class ShoushuMessXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHOUSHU_MESS_XQ_ID")
	private long shoushuMessXqId;

	@Column(name="SHOUSHU_MESS_XQ_MONEY")
	private BigDecimal shoushuMessXqMoney;

	@Column(name="SHOUSHU_MESS_XQ_NAME")
	private String shoushuMessXqName;

	@Column(name="SHOUSHU_MESS_XQ_NUM")
	private BigDecimal shoushuMessXqNum;

	@Column(name="SHOUSHU_MESS_XQ_PRICE")
	private BigDecimal shoushuMessXqPrice;

	@Column(name="SHOUSHU_MESS_XQ_RESULT")
	private String shoushuMessXqResult;

	@Column(name="SHOUSHU_MESS_XQ_TYPE")
	private String shoushuMessXqType;

	//bi-directional many-to-one association to ShoushuMess
	@ManyToOne
	@JoinColumn(name="SHOUSHU_MESS")
	private ShoushuMess shoushuMessBean;

	public ShoushuMessXq() {
	}

	public long getShoushuMessXqId() {
		return this.shoushuMessXqId;
	}

	public void setShoushuMessXqId(long shoushuMessXqId) {
		this.shoushuMessXqId = shoushuMessXqId;
	}

	public BigDecimal getShoushuMessXqMoney() {
		return this.shoushuMessXqMoney;
	}

	public void setShoushuMessXqMoney(BigDecimal shoushuMessXqMoney) {
		this.shoushuMessXqMoney = shoushuMessXqMoney;
	}

	public String getShoushuMessXqName() {
		return this.shoushuMessXqName;
	}

	public void setShoushuMessXqName(String shoushuMessXqName) {
		this.shoushuMessXqName = shoushuMessXqName;
	}

	public BigDecimal getShoushuMessXqNum() {
		return this.shoushuMessXqNum;
	}

	public void setShoushuMessXqNum(BigDecimal shoushuMessXqNum) {
		this.shoushuMessXqNum = shoushuMessXqNum;
	}

	public BigDecimal getShoushuMessXqPrice() {
		return this.shoushuMessXqPrice;
	}

	public void setShoushuMessXqPrice(BigDecimal shoushuMessXqPrice) {
		this.shoushuMessXqPrice = shoushuMessXqPrice;
	}

	public String getShoushuMessXqResult() {
		return this.shoushuMessXqResult;
	}

	public void setShoushuMessXqResult(String shoushuMessXqResult) {
		this.shoushuMessXqResult = shoushuMessXqResult;
	}

	public String getShoushuMessXqType() {
		return this.shoushuMessXqType;
	}

	public void setShoushuMessXqType(String shoushuMessXqType) {
		this.shoushuMessXqType = shoushuMessXqType;
	}

	public ShoushuMess getShoushuMessBean() {
		return this.shoushuMessBean;
	}

	public void setShoushuMessBean(ShoushuMess shoushuMessBean) {
		this.shoushuMessBean = shoushuMessBean;
	}

}