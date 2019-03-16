package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UNITS database table.
 * 
 */
@Entity
@Table(name="UNITS")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UNITS_ID")
	private long unitsId;

	@Column(name="UNITS_NAME")
	private String unitsName;

	//bi-directional many-to-one association to Drug
	@OneToMany(mappedBy="unit")
	private List<Drug> drugs;

	//bi-directional many-to-one association to Instrument
	@OneToMany(mappedBy="unit")
	private List<Instrument> instruments;

	//bi-directional many-to-one association to Jianyan
	@OneToMany(mappedBy="unit")
	private List<Jianyan> jianyans;

	public Unit() {
	}

	public long getUnitsId() {
		return this.unitsId;
	}

	public void setUnitsId(long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return this.unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public List<Drug> getDrugs() {
		return this.drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public Drug addDrug(Drug drug) {
		getDrugs().add(drug);
		drug.setUnit(this);

		return drug;
	}

	public Drug removeDrug(Drug drug) {
		getDrugs().remove(drug);
		drug.setUnit(null);

		return drug;
	}

	public List<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Instrument addInstrument(Instrument instrument) {
		getInstruments().add(instrument);
		instrument.setUnit(this);

		return instrument;
	}

	public Instrument removeInstrument(Instrument instrument) {
		getInstruments().remove(instrument);
		instrument.setUnit(null);

		return instrument;
	}

	public List<Jianyan> getJianyans() {
		return this.jianyans;
	}

	public void setJianyans(List<Jianyan> jianyans) {
		this.jianyans = jianyans;
	}

	public Jianyan addJianyan(Jianyan jianyan) {
		getJianyans().add(jianyan);
		jianyan.setUnit(this);

		return jianyan;
	}

	public Jianyan removeJianyan(Jianyan jianyan) {
		getJianyans().remove(jianyan);
		jianyan.setUnit(null);

		return jianyan;
	}

}