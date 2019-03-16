package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QX_USEQX database table.
 * 
 */
@Entity
@Table(name="QX_USEQX")
@NamedQuery(name="QxUseqx.findAll", query="SELECT q FROM QxUseqx q")
public class QxUseqx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_USEQX_ID")
	private long qxUseqxId;

	@Column(name="QX_USEQX_BEIZU")
	private String qxUseqxBeizu;

	@Column(name="QX_USEQX_JCSHUL")
	private BigDecimal qxUseqxJcshul;

	@Column(name="QX_USEQX_LYSHUL")
	private BigDecimal qxUseqxLyshul;

	@Column(name="QX_USEQX_PIHAO")
	private BigDecimal qxUseqxPihao;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to QxUse
	@ManyToOne
	@JoinColumn(name="QX_USE_ID")
	private QxUse qxUse;

	public QxUseqx() {
	}

	public long getQxUseqxId() {
		return this.qxUseqxId;
	}

	public void setQxUseqxId(long qxUseqxId) {
		this.qxUseqxId = qxUseqxId;
	}

	public String getQxUseqxBeizu() {
		return this.qxUseqxBeizu;
	}

	public void setQxUseqxBeizu(String qxUseqxBeizu) {
		this.qxUseqxBeizu = qxUseqxBeizu;
	}

	public BigDecimal getQxUseqxJcshul() {
		return this.qxUseqxJcshul;
	}

	public void setQxUseqxJcshul(BigDecimal qxUseqxJcshul) {
		this.qxUseqxJcshul = qxUseqxJcshul;
	}

	public BigDecimal getQxUseqxLyshul() {
		return this.qxUseqxLyshul;
	}

	public void setQxUseqxLyshul(BigDecimal qxUseqxLyshul) {
		this.qxUseqxLyshul = qxUseqxLyshul;
	}

	public BigDecimal getQxUseqxPihao() {
		return this.qxUseqxPihao;
	}

	public void setQxUseqxPihao(BigDecimal qxUseqxPihao) {
		this.qxUseqxPihao = qxUseqxPihao;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public QxUse getQxUse() {
		return this.qxUse;
	}

	public void setQxUse(QxUse qxUse) {
		this.qxUse = qxUse;
	}

}