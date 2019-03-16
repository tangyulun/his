package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QX_LNVENTORYQX database table.
 * 
 */
@Entity
@Table(name="QX_LNVENTORYQX")
@NamedQuery(name="QxLnventoryqx.findAll", query="SELECT q FROM QxLnventoryqx q")
public class QxLnventoryqx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_LNVENTORYQX_ID")
	private long qxLnventoryqxId;

	@Column(name="QX_LNVENTORYQX_BEIZU")
	private String qxLnventoryqxBeizu;

	@Column(name="QX_LNVENTORYQX_NUM")
	private BigDecimal qxLnventoryqxNum;

	@Column(name="QX_LNVENTORYQX_PIHAO")
	private BigDecimal qxLnventoryqxPihao;

	@Column(name="QX_LNVENTORYQX_YK_NUM")
	private BigDecimal qxLnventoryqxYkNum;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to QxLnventory
	@ManyToOne
	@JoinColumn(name="QX_LNVENTORY_ID")
	private QxLnventory qxLnventory;

	public QxLnventoryqx() {
	}

	public long getQxLnventoryqxId() {
		return this.qxLnventoryqxId;
	}

	public void setQxLnventoryqxId(long qxLnventoryqxId) {
		this.qxLnventoryqxId = qxLnventoryqxId;
	}

	public String getQxLnventoryqxBeizu() {
		return this.qxLnventoryqxBeizu;
	}

	public void setQxLnventoryqxBeizu(String qxLnventoryqxBeizu) {
		this.qxLnventoryqxBeizu = qxLnventoryqxBeizu;
	}

	public BigDecimal getQxLnventoryqxNum() {
		return this.qxLnventoryqxNum;
	}

	public void setQxLnventoryqxNum(BigDecimal qxLnventoryqxNum) {
		this.qxLnventoryqxNum = qxLnventoryqxNum;
	}

	public BigDecimal getQxLnventoryqxPihao() {
		return this.qxLnventoryqxPihao;
	}

	public void setQxLnventoryqxPihao(BigDecimal qxLnventoryqxPihao) {
		this.qxLnventoryqxPihao = qxLnventoryqxPihao;
	}

	public BigDecimal getQxLnventoryqxYkNum() {
		return this.qxLnventoryqxYkNum;
	}

	public void setQxLnventoryqxYkNum(BigDecimal qxLnventoryqxYkNum) {
		this.qxLnventoryqxYkNum = qxLnventoryqxYkNum;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public QxLnventory getQxLnventory() {
		return this.qxLnventory;
	}

	public void setQxLnventory(QxLnventory qxLnventory) {
		this.qxLnventory = qxLnventory;
	}

}