package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INSTRUMENT_LOGIN database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_LOGIN")
@NamedQuery(name="InstrumentLogin.findAll", query="SELECT i FROM InstrumentLogin i")
public class InstrumentLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_LOGIN_ID")
	private String instrumentLoginId;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_LOGIN_BAOFEI_DATE")
	private Date instrumentLoginBaofeiDate;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_LOGIN_CAIGOU_DATE")
	private Date instrumentLoginCaigouDate;

	@Column(name="INSTRUMENT_LOGIN_NUM")
	private BigDecimal instrumentLoginNum;

	@Column(name="INSTRUMENT_LOGIN_PIHAO")
	private String instrumentLoginPihao;

	@Column(name="INSTRUMENT_LOGIN_REMARK")
	private String instrumentLoginRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_LOGIN_SC_DATE")
	private Date instrumentLoginScDate;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	public InstrumentLogin() {
	}

	public String getInstrumentLoginId() {
		return this.instrumentLoginId;
	}

	public void setInstrumentLoginId(String instrumentLoginId) {
		this.instrumentLoginId = instrumentLoginId;
	}

	public Date getInstrumentLoginBaofeiDate() {
		return this.instrumentLoginBaofeiDate;
	}

	public void setInstrumentLoginBaofeiDate(Date instrumentLoginBaofeiDate) {
		this.instrumentLoginBaofeiDate = instrumentLoginBaofeiDate;
	}

	public Date getInstrumentLoginCaigouDate() {
		return this.instrumentLoginCaigouDate;
	}

	public void setInstrumentLoginCaigouDate(Date instrumentLoginCaigouDate) {
		this.instrumentLoginCaigouDate = instrumentLoginCaigouDate;
	}

	public BigDecimal getInstrumentLoginNum() {
		return this.instrumentLoginNum;
	}

	public void setInstrumentLoginNum(BigDecimal instrumentLoginNum) {
		this.instrumentLoginNum = instrumentLoginNum;
	}

	public String getInstrumentLoginPihao() {
		return this.instrumentLoginPihao;
	}

	public void setInstrumentLoginPihao(String instrumentLoginPihao) {
		this.instrumentLoginPihao = instrumentLoginPihao;
	}

	public String getInstrumentLoginRemark() {
		return this.instrumentLoginRemark;
	}

	public void setInstrumentLoginRemark(String instrumentLoginRemark) {
		this.instrumentLoginRemark = instrumentLoginRemark;
	}

	public Date getInstrumentLoginScDate() {
		return this.instrumentLoginScDate;
	}

	public void setInstrumentLoginScDate(Date instrumentLoginScDate) {
		this.instrumentLoginScDate = instrumentLoginScDate;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}