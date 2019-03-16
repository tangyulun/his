package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QX_THELIBRARYQX database table.
 * 
 */
@Entity
@Table(name="QX_THELIBRARYQX")
@NamedQuery(name="QxThelibraryqx.findAll", query="SELECT q FROM QxThelibraryqx q")
public class QxThelibraryqx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_THELIBRARYQX_ID")
	private long qxThelibraryqxId;

	@Column(name="QX_THELIBRARYQX_BEIZU")
	private String qxThelibraryqxBeizu;

	@Column(name="QX_THELIBRARYQX_MONEY")
	private BigDecimal qxThelibraryqxMoney;

	@Column(name="QX_THELIBRARYQX_NUMBER")
	private BigDecimal qxThelibraryqxNumber;

	@Column(name="QX_THELIBRARYQX_PIHAO")
	private String qxThelibraryqxPihao;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to QxThelibrary
	@ManyToOne
	@JoinColumn(name="QX_THELIBRARY_ID")
	private QxThelibrary qxThelibrary;

	public QxThelibraryqx() {
	}

	public long getQxThelibraryqxId() {
		return this.qxThelibraryqxId;
	}

	public void setQxThelibraryqxId(long qxThelibraryqxId) {
		this.qxThelibraryqxId = qxThelibraryqxId;
	}

	public String getQxThelibraryqxBeizu() {
		return this.qxThelibraryqxBeizu;
	}

	public void setQxThelibraryqxBeizu(String qxThelibraryqxBeizu) {
		this.qxThelibraryqxBeizu = qxThelibraryqxBeizu;
	}

	public BigDecimal getQxThelibraryqxMoney() {
		return this.qxThelibraryqxMoney;
	}

	public void setQxThelibraryqxMoney(BigDecimal qxThelibraryqxMoney) {
		this.qxThelibraryqxMoney = qxThelibraryqxMoney;
	}

	public BigDecimal getQxThelibraryqxNumber() {
		return this.qxThelibraryqxNumber;
	}

	public void setQxThelibraryqxNumber(BigDecimal qxThelibraryqxNumber) {
		this.qxThelibraryqxNumber = qxThelibraryqxNumber;
	}

	public String getQxThelibraryqxPihao() {
		return this.qxThelibraryqxPihao;
	}

	public void setQxThelibraryqxPihao(String qxThelibraryqxPihao) {
		this.qxThelibraryqxPihao = qxThelibraryqxPihao;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public QxThelibrary getQxThelibrary() {
		return this.qxThelibrary;
	}

	public void setQxThelibrary(QxThelibrary qxThelibrary) {
		this.qxThelibrary = qxThelibrary;
	}

}