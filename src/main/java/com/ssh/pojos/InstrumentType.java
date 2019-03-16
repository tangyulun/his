package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT_TYPE database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_TYPE")
@NamedQuery(name="InstrumentType.findAll", query="SELECT i FROM InstrumentType i")
public class InstrumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_TYPE_ID")
	private long instrumentTypeId;

	@Column(name="INSTRUMENT_TYPE_NAME")
	private String instrumentTypeName;

	//bi-directional many-to-one association to Instrument
	@OneToMany(mappedBy="instrumentType")
	private List<Instrument> instruments;

	public InstrumentType() {
	}

	public long getInstrumentTypeId() {
		return this.instrumentTypeId;
	}

	public void setInstrumentTypeId(long instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

	public String getInstrumentTypeName() {
		return this.instrumentTypeName;
	}

	public void setInstrumentTypeName(String instrumentTypeName) {
		this.instrumentTypeName = instrumentTypeName;
	}

	public List<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Instrument addInstrument(Instrument instrument) {
		getInstruments().add(instrument);
		instrument.setInstrumentType(this);

		return instrument;
	}

	public Instrument removeInstrument(Instrument instrument) {
		getInstruments().remove(instrument);
		instrument.setInstrumentType(null);

		return instrument;
	}

}