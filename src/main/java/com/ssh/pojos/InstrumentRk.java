package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT_RK database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_RK")
@NamedQuery(name="InstrumentRk.findAll", query="SELECT i FROM InstrumentRk i")
public class InstrumentRk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_RK_ID")
	private String instrumentRkId;

	@Column(name="INSTRUMENT_RK__NAME")
	private String instrumentRkName;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_RK_DATE")
	private Date instrumentRkDate;

	@Column(name="INSTRUMENT_RK_RKLX")
	private String instrumentRkRklx;

	@Column(name="QX_RETURNGOOS_PZDH")
	private String qxReturngoosPzdh;

	@Column(name="QX_RETURNGOOS_SATAE")
	private String qxReturngoosSatae;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to InstrumentY
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_YS_ID")
	private InstrumentY instrumentY;

	//bi-directional many-to-one association to InstrumentRkXq
	@OneToMany(mappedBy="instrumentRk")
	private List<InstrumentRkXq> instrumentRkXqs;

	public InstrumentRk() {
	}

	public String getInstrumentRkId() {
		return this.instrumentRkId;
	}

	public void setInstrumentRkId(String instrumentRkId) {
		this.instrumentRkId = instrumentRkId;
	}

	public String getInstrumentRkName() {
		return this.instrumentRkName;
	}

	public void setInstrumentRkName(String instrumentRkName) {
		this.instrumentRkName = instrumentRkName;
	}

	public Date getInstrumentRkDate() {
		return this.instrumentRkDate;
	}

	public void setInstrumentRkDate(Date instrumentRkDate) {
		this.instrumentRkDate = instrumentRkDate;
	}

	public String getInstrumentRkRklx() {
		return this.instrumentRkRklx;
	}

	public void setInstrumentRkRklx(String instrumentRkRklx) {
		this.instrumentRkRklx = instrumentRkRklx;
	}

	public String getQxReturngoosPzdh() {
		return this.qxReturngoosPzdh;
	}

	public void setQxReturngoosPzdh(String qxReturngoosPzdh) {
		this.qxReturngoosPzdh = qxReturngoosPzdh;
	}

	public String getQxReturngoosSatae() {
		return this.qxReturngoosSatae;
	}

	public void setQxReturngoosSatae(String qxReturngoosSatae) {
		this.qxReturngoosSatae = qxReturngoosSatae;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public InstrumentY getInstrumentY() {
		return this.instrumentY;
	}

	public void setInstrumentY(InstrumentY instrumentY) {
		this.instrumentY = instrumentY;
	}

	public List<InstrumentRkXq> getInstrumentRkXqs() {
		return this.instrumentRkXqs;
	}

	public void setInstrumentRkXqs(List<InstrumentRkXq> instrumentRkXqs) {
		this.instrumentRkXqs = instrumentRkXqs;
	}

	public InstrumentRkXq addInstrumentRkXq(InstrumentRkXq instrumentRkXq) {
		getInstrumentRkXqs().add(instrumentRkXq);
		instrumentRkXq.setInstrumentRk(this);

		return instrumentRkXq;
	}

	public InstrumentRkXq removeInstrumentRkXq(InstrumentRkXq instrumentRkXq) {
		getInstrumentRkXqs().remove(instrumentRkXq);
		instrumentRkXq.setInstrumentRk(null);

		return instrumentRkXq;
	}

}