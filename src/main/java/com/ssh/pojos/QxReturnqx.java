package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QX_RETURNQX database table.
 * 
 */
@Entity
@Table(name="QX_RETURNQX")
@NamedQuery(name="QxReturnqx.findAll", query="SELECT q FROM QxReturnqx q")
public class QxReturnqx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_RETURNQX_ID")
	private long qxReturnqxId;

	@Column(name="QX_RETURNQX_BEIZU")
	private String qxReturnqxBeizu;

	@Column(name="QX_RETURNQX_NUMBER")
	private BigDecimal qxReturnqxNumber;

	@Column(name="QX_RETURNQX_PIHAO")
	private BigDecimal qxReturnqxPihao;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to QxReturn
	@ManyToOne
	@JoinColumn(name="QX_RETURN_ID")
	private QxReturn qxReturn;

	public QxReturnqx() {
	}

	public long getQxReturnqxId() {
		return this.qxReturnqxId;
	}

	public void setQxReturnqxId(long qxReturnqxId) {
		this.qxReturnqxId = qxReturnqxId;
	}

	public String getQxReturnqxBeizu() {
		return this.qxReturnqxBeizu;
	}

	public void setQxReturnqxBeizu(String qxReturnqxBeizu) {
		this.qxReturnqxBeizu = qxReturnqxBeizu;
	}

	public BigDecimal getQxReturnqxNumber() {
		return this.qxReturnqxNumber;
	}

	public void setQxReturnqxNumber(BigDecimal qxReturnqxNumber) {
		this.qxReturnqxNumber = qxReturnqxNumber;
	}

	public BigDecimal getQxReturnqxPihao() {
		return this.qxReturnqxPihao;
	}

	public void setQxReturnqxPihao(BigDecimal qxReturnqxPihao) {
		this.qxReturnqxPihao = qxReturnqxPihao;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public QxReturn getQxReturn() {
		return this.qxReturn;
	}

	public void setQxReturn(QxReturn qxReturn) {
		this.qxReturn = qxReturn;
	}

}