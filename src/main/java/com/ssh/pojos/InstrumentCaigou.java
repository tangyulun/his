package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT_CAIGOU database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_CAIGOU")
@NamedQuery(name="InstrumentCaigou.findAll", query="SELECT i FROM InstrumentCaigou i")
public class InstrumentCaigou implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_CAIGOU_ID")
	private String instrumentCaigouId;

	@Column(name="INSTRUMENT_CAIGOU_ADDRESS")
	private String instrumentCaigouAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_CAIGOU_DH_DATE")
	private Date instrumentCaigouDhDate;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_CAIGOU_GH_DATE")
	private Date instrumentCaigouGhDate;

	@Column(name="INSTRUMENT_CAIGOU_MONEY")
	private BigDecimal instrumentCaigouMoney;

	@Column(name="INSTRUMENT_CAIGOU_STATE")
	private String instrumentCaigouState;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier supplier;

	//bi-directional many-to-one association to InstrumentCaigouXq
	@OneToMany(mappedBy="instrumentCaigou")
	private List<InstrumentCaigouXq> instrumentCaigouXqs;

	//bi-directional many-to-one association to InstrumentY
	@OneToMany(mappedBy="instrumentCaigou")
	private List<InstrumentY> instrumentYs;

	public InstrumentCaigou() {
	}

	public String getInstrumentCaigouId() {
		return this.instrumentCaigouId;
	}

	public void setInstrumentCaigouId(String instrumentCaigouId) {
		this.instrumentCaigouId = instrumentCaigouId;
	}

	public String getInstrumentCaigouAddress() {
		return this.instrumentCaigouAddress;
	}

	public void setInstrumentCaigouAddress(String instrumentCaigouAddress) {
		this.instrumentCaigouAddress = instrumentCaigouAddress;
	}

	public Date getInstrumentCaigouDhDate() {
		return this.instrumentCaigouDhDate;
	}

	public void setInstrumentCaigouDhDate(Date instrumentCaigouDhDate) {
		this.instrumentCaigouDhDate = instrumentCaigouDhDate;
	}

	public Date getInstrumentCaigouGhDate() {
		return this.instrumentCaigouGhDate;
	}

	public void setInstrumentCaigouGhDate(Date instrumentCaigouGhDate) {
		this.instrumentCaigouGhDate = instrumentCaigouGhDate;
	}

	public BigDecimal getInstrumentCaigouMoney() {
		return this.instrumentCaigouMoney;
	}

	public void setInstrumentCaigouMoney(BigDecimal instrumentCaigouMoney) {
		this.instrumentCaigouMoney = instrumentCaigouMoney;
	}

	public String getInstrumentCaigouState() {
		return this.instrumentCaigouState;
	}

	public void setInstrumentCaigouState(String instrumentCaigouState) {
		this.instrumentCaigouState = instrumentCaigouState;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<InstrumentCaigouXq> getInstrumentCaigouXqs() {
		return this.instrumentCaigouXqs;
	}

	public void setInstrumentCaigouXqs(List<InstrumentCaigouXq> instrumentCaigouXqs) {
		this.instrumentCaigouXqs = instrumentCaigouXqs;
	}

	public InstrumentCaigouXq addInstrumentCaigouXq(InstrumentCaigouXq instrumentCaigouXq) {
		getInstrumentCaigouXqs().add(instrumentCaigouXq);
		instrumentCaigouXq.setInstrumentCaigou(this);

		return instrumentCaigouXq;
	}

	public InstrumentCaigouXq removeInstrumentCaigouXq(InstrumentCaigouXq instrumentCaigouXq) {
		getInstrumentCaigouXqs().remove(instrumentCaigouXq);
		instrumentCaigouXq.setInstrumentCaigou(null);

		return instrumentCaigouXq;
	}

	public List<InstrumentY> getInstrumentYs() {
		return this.instrumentYs;
	}

	public void setInstrumentYs(List<InstrumentY> instrumentYs) {
		this.instrumentYs = instrumentYs;
	}

	public InstrumentY addInstrumentY(InstrumentY instrumentY) {
		getInstrumentYs().add(instrumentY);
		instrumentY.setInstrumentCaigou(this);

		return instrumentY;
	}

	public InstrumentY removeInstrumentY(InstrumentY instrumentY) {
		getInstrumentYs().remove(instrumentY);
		instrumentY.setInstrumentCaigou(null);

		return instrumentY;
	}

}