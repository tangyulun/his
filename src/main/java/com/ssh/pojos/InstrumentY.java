package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT_YS database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_YS")
@NamedQuery(name="InstrumentY.findAll", query="SELECT i FROM InstrumentY i")
public class InstrumentY implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_YS_ID")
	private String instrumentYsId;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_YS_DATE")
	private Date instrumentYsDate;

	@Column(name="INSTRUMENT_YS_PZDH")
	private String instrumentYsPzdh;

	@Column(name="INSTRUMENT_YS_STATE")
	private String instrumentYsState;

	//bi-directional many-to-one association to InstrumentRk
	@OneToMany(mappedBy="instrumentY")
	private List<InstrumentRk> instrumentRks;

	//bi-directional many-to-one association to InstrumentCaigou
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_CAIGOU_ID")
	private InstrumentCaigou instrumentCaigou;

	//bi-directional many-to-one association to QxReturngoo
	@OneToMany(mappedBy="instrumentY")
	private List<QxReturngoo> qxReturngoos;

	public InstrumentY() {
	}

	public String getInstrumentYsId() {
		return this.instrumentYsId;
	}

	public void setInstrumentYsId(String instrumentYsId) {
		this.instrumentYsId = instrumentYsId;
	}

	public Date getInstrumentYsDate() {
		return this.instrumentYsDate;
	}

	public void setInstrumentYsDate(Date instrumentYsDate) {
		this.instrumentYsDate = instrumentYsDate;
	}

	public String getInstrumentYsPzdh() {
		return this.instrumentYsPzdh;
	}

	public void setInstrumentYsPzdh(String instrumentYsPzdh) {
		this.instrumentYsPzdh = instrumentYsPzdh;
	}

	public String getInstrumentYsState() {
		return this.instrumentYsState;
	}

	public void setInstrumentYsState(String instrumentYsState) {
		this.instrumentYsState = instrumentYsState;
	}

	public List<InstrumentRk> getInstrumentRks() {
		return this.instrumentRks;
	}

	public void setInstrumentRks(List<InstrumentRk> instrumentRks) {
		this.instrumentRks = instrumentRks;
	}

	public InstrumentRk addInstrumentRk(InstrumentRk instrumentRk) {
		getInstrumentRks().add(instrumentRk);
		instrumentRk.setInstrumentY(this);

		return instrumentRk;
	}

	public InstrumentRk removeInstrumentRk(InstrumentRk instrumentRk) {
		getInstrumentRks().remove(instrumentRk);
		instrumentRk.setInstrumentY(null);

		return instrumentRk;
	}

	public InstrumentCaigou getInstrumentCaigou() {
		return this.instrumentCaigou;
	}

	public void setInstrumentCaigou(InstrumentCaigou instrumentCaigou) {
		this.instrumentCaigou = instrumentCaigou;
	}

	public List<QxReturngoo> getQxReturngoos() {
		return this.qxReturngoos;
	}

	public void setQxReturngoos(List<QxReturngoo> qxReturngoos) {
		this.qxReturngoos = qxReturngoos;
	}

	public QxReturngoo addQxReturngoo(QxReturngoo qxReturngoo) {
		getQxReturngoos().add(qxReturngoo);
		qxReturngoo.setInstrumentY(this);

		return qxReturngoo;
	}

	public QxReturngoo removeQxReturngoo(QxReturngoo qxReturngoo) {
		getQxReturngoos().remove(qxReturngoo);
		qxReturngoo.setInstrumentY(null);

		return qxReturngoo;
	}

}