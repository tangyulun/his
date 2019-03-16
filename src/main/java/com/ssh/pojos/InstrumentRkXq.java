package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INSTRUMENT_RK_XQ database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_RK_XQ")
@NamedQuery(name="InstrumentRkXq.findAll", query="SELECT i FROM InstrumentRkXq i")
public class InstrumentRkXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_RK_XQID")
	private long instrumentRkXqid;

	@Column(name="INSTRUMENT_RK_XQBEIZU")
	private String instrumentRkXqbeizu;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_RK_XQBFDATE")
	private Date instrumentRkXqbfdate;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_RK_XQCGDATE")
	private Date instrumentRkXqcgdate;

	@Column(name="INSTRUMENT_RK_XQNUMBER")
	private BigDecimal instrumentRkXqnumber;

	@Column(name="INSTRUMENT_RK_XQPIHAO")
	private String instrumentRkXqpihao;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_RK_XQSCDATE")
	private Date instrumentRkXqscdate;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to InstrumentRk
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_RK_ID")
	private InstrumentRk instrumentRk;

	public InstrumentRkXq() {
	}

	public long getInstrumentRkXqid() {
		return this.instrumentRkXqid;
	}

	public void setInstrumentRkXqid(long instrumentRkXqid) {
		this.instrumentRkXqid = instrumentRkXqid;
	}

	public String getInstrumentRkXqbeizu() {
		return this.instrumentRkXqbeizu;
	}

	public void setInstrumentRkXqbeizu(String instrumentRkXqbeizu) {
		this.instrumentRkXqbeizu = instrumentRkXqbeizu;
	}

	public Date getInstrumentRkXqbfdate() {
		return this.instrumentRkXqbfdate;
	}

	public void setInstrumentRkXqbfdate(Date instrumentRkXqbfdate) {
		this.instrumentRkXqbfdate = instrumentRkXqbfdate;
	}

	public Date getInstrumentRkXqcgdate() {
		return this.instrumentRkXqcgdate;
	}

	public void setInstrumentRkXqcgdate(Date instrumentRkXqcgdate) {
		this.instrumentRkXqcgdate = instrumentRkXqcgdate;
	}

	public BigDecimal getInstrumentRkXqnumber() {
		return this.instrumentRkXqnumber;
	}

	public void setInstrumentRkXqnumber(BigDecimal instrumentRkXqnumber) {
		this.instrumentRkXqnumber = instrumentRkXqnumber;
	}

	public String getInstrumentRkXqpihao() {
		return this.instrumentRkXqpihao;
	}

	public void setInstrumentRkXqpihao(String instrumentRkXqpihao) {
		this.instrumentRkXqpihao = instrumentRkXqpihao;
	}

	public Date getInstrumentRkXqscdate() {
		return this.instrumentRkXqscdate;
	}

	public void setInstrumentRkXqscdate(Date instrumentRkXqscdate) {
		this.instrumentRkXqscdate = instrumentRkXqscdate;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public InstrumentRk getInstrumentRk() {
		return this.instrumentRk;
	}

	public void setInstrumentRk(InstrumentRk instrumentRk) {
		this.instrumentRk = instrumentRk;
	}

}