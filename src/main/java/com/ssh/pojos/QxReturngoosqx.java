package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QX_RETURNGOOSQX database table.
 * 
 */
@Entity
@Table(name="QX_RETURNGOOSQX")
@NamedQuery(name="QxReturngoosqx.findAll", query="SELECT q FROM QxReturngoosqx q")
public class QxReturngoosqx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_RETURNGOOSQX_ID")
	private long qxReturngoosqxId;

	@Column(name="QX_RETURNGOOSQX_BEIZU")
	private String qxReturngoosqxBeizu;

	@Column(name="QX_RETURNGOOSQX_MONEY")
	private BigDecimal qxReturngoosqxMoney;

	@Column(name="QX_RETURNGOOSQX_NUMBER")
	private BigDecimal qxReturngoosqxNumber;

	@Column(name="QX_RETURNGOOSQX_PRICE")
	private BigDecimal qxReturngoosqxPrice;

	@Column(name="QX_RETURNGOOSQX_XQPIHAO")
	private String qxReturngoosqxXqpihao;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to QxReturngoo
	@ManyToOne
	@JoinColumn(name="QX_RETURNGOOS_ID")
	private QxReturngoo qxReturngoo;

	public QxReturngoosqx() {
	}

	public long getQxReturngoosqxId() {
		return this.qxReturngoosqxId;
	}

	public void setQxReturngoosqxId(long qxReturngoosqxId) {
		this.qxReturngoosqxId = qxReturngoosqxId;
	}

	public String getQxReturngoosqxBeizu() {
		return this.qxReturngoosqxBeizu;
	}

	public void setQxReturngoosqxBeizu(String qxReturngoosqxBeizu) {
		this.qxReturngoosqxBeizu = qxReturngoosqxBeizu;
	}

	public BigDecimal getQxReturngoosqxMoney() {
		return this.qxReturngoosqxMoney;
	}

	public void setQxReturngoosqxMoney(BigDecimal qxReturngoosqxMoney) {
		this.qxReturngoosqxMoney = qxReturngoosqxMoney;
	}

	public BigDecimal getQxReturngoosqxNumber() {
		return this.qxReturngoosqxNumber;
	}

	public void setQxReturngoosqxNumber(BigDecimal qxReturngoosqxNumber) {
		this.qxReturngoosqxNumber = qxReturngoosqxNumber;
	}

	public BigDecimal getQxReturngoosqxPrice() {
		return this.qxReturngoosqxPrice;
	}

	public void setQxReturngoosqxPrice(BigDecimal qxReturngoosqxPrice) {
		this.qxReturngoosqxPrice = qxReturngoosqxPrice;
	}

	public String getQxReturngoosqxXqpihao() {
		return this.qxReturngoosqxXqpihao;
	}

	public void setQxReturngoosqxXqpihao(String qxReturngoosqxXqpihao) {
		this.qxReturngoosqxXqpihao = qxReturngoosqxXqpihao;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public QxReturngoo getQxReturngoo() {
		return this.qxReturngoo;
	}

	public void setQxReturngoo(QxReturngoo qxReturngoo) {
		this.qxReturngoo = qxReturngoo;
	}

}