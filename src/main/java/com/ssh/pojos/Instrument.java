package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INSTRUMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Instrument.findAll", query="SELECT i FROM Instrument i")
public class Instrument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_ID")
	private String instrumentId;

	@Column(name="INSTRUEMNT_TOP")
	private BigDecimal instruemntTop;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_BAOFEI_DATE")
	private Date instrumentBaofeiDate;

	@Column(name="INSTRUMENT_BUTTOM")
	private BigDecimal instrumentButtom;

	@Column(name="INSTRUMENT_CHICUN")
	private BigDecimal instrumentChicun;

	@Column(name="INSTRUMENT_NAME")
	private String instrumentName;

	@Column(name="INSTRUMENT_PRICE")
	private BigDecimal instrumentPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="INSTRUMENT_QIYONG_DATE")
	private Date instrumentQiyongDate;

	@Column(name="INSTRUMENT_REMARK")
	private String instrumentRemark;

	@Column(name="INSTRUMENT_SHENG_NUM")
	private BigDecimal instrumentShengNum;

	@Column(name="INSTRUMENT_WAIJIE_NUM")
	private BigDecimal instrumentWaijieNum;

	@Column(name="INSTRUMENT_ZONG_NUM")
	private BigDecimal instrumentZongNum;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to InstrumentType
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_TYPE_ID")
	private InstrumentType instrumentType;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="UNITS_ID")
	private Unit unit;

	//bi-directional many-to-one association to InstrumentCaigouXq
	@OneToMany(mappedBy="instrument")
	private List<InstrumentCaigouXq> instrumentCaigouXqs;

	//bi-directional many-to-one association to InstrumentLogin
	@OneToMany(mappedBy="instrument")
	private List<InstrumentLogin> instrumentLogins;

	//bi-directional many-to-one association to InstrumentRkXq
	@OneToMany(mappedBy="instrument")
	private List<InstrumentRkXq> instrumentRkXqs;

	//bi-directional many-to-one association to QxLnventoryqx
	@OneToMany(mappedBy="instrument")
	private List<QxLnventoryqx> qxLnventoryqxs;

	//bi-directional many-to-one association to QxReturngoosqx
	@OneToMany(mappedBy="instrument")
	private List<QxReturngoosqx> qxReturngoosqxs;

	//bi-directional many-to-one association to QxReturnqx
	@OneToMany(mappedBy="instrument")
	private List<QxReturnqx> qxReturnqxs;

	//bi-directional many-to-one association to QxThelibraryqx
	@OneToMany(mappedBy="instrument")
	private List<QxThelibraryqx> qxThelibraryqxs;

	//bi-directional many-to-one association to QxUseqx
	@OneToMany(mappedBy="instrument")
	private List<QxUseqx> qxUseqxs;

	public Instrument() {
	}

	public String getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public BigDecimal getInstruemntTop() {
		return this.instruemntTop;
	}

	public void setInstruemntTop(BigDecimal instruemntTop) {
		this.instruemntTop = instruemntTop;
	}

	public Date getInstrumentBaofeiDate() {
		return this.instrumentBaofeiDate;
	}

	public void setInstrumentBaofeiDate(Date instrumentBaofeiDate) {
		this.instrumentBaofeiDate = instrumentBaofeiDate;
	}

	public BigDecimal getInstrumentButtom() {
		return this.instrumentButtom;
	}

	public void setInstrumentButtom(BigDecimal instrumentButtom) {
		this.instrumentButtom = instrumentButtom;
	}

	public BigDecimal getInstrumentChicun() {
		return this.instrumentChicun;
	}

	public void setInstrumentChicun(BigDecimal instrumentChicun) {
		this.instrumentChicun = instrumentChicun;
	}

	public String getInstrumentName() {
		return this.instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public BigDecimal getInstrumentPrice() {
		return this.instrumentPrice;
	}

	public void setInstrumentPrice(BigDecimal instrumentPrice) {
		this.instrumentPrice = instrumentPrice;
	}

	public Date getInstrumentQiyongDate() {
		return this.instrumentQiyongDate;
	}

	public void setInstrumentQiyongDate(Date instrumentQiyongDate) {
		this.instrumentQiyongDate = instrumentQiyongDate;
	}

	public String getInstrumentRemark() {
		return this.instrumentRemark;
	}

	public void setInstrumentRemark(String instrumentRemark) {
		this.instrumentRemark = instrumentRemark;
	}

	public BigDecimal getInstrumentShengNum() {
		return this.instrumentShengNum;
	}

	public void setInstrumentShengNum(BigDecimal instrumentShengNum) {
		this.instrumentShengNum = instrumentShengNum;
	}

	public BigDecimal getInstrumentWaijieNum() {
		return this.instrumentWaijieNum;
	}

	public void setInstrumentWaijieNum(BigDecimal instrumentWaijieNum) {
		this.instrumentWaijieNum = instrumentWaijieNum;
	}

	public BigDecimal getInstrumentZongNum() {
		return this.instrumentZongNum;
	}

	public void setInstrumentZongNum(BigDecimal instrumentZongNum) {
		this.instrumentZongNum = instrumentZongNum;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public InstrumentType getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<InstrumentCaigouXq> getInstrumentCaigouXqs() {
		return this.instrumentCaigouXqs;
	}

	public void setInstrumentCaigouXqs(List<InstrumentCaigouXq> instrumentCaigouXqs) {
		this.instrumentCaigouXqs = instrumentCaigouXqs;
	}

	public InstrumentCaigouXq addInstrumentCaigouXq(InstrumentCaigouXq instrumentCaigouXq) {
		getInstrumentCaigouXqs().add(instrumentCaigouXq);
		instrumentCaigouXq.setInstrument(this);

		return instrumentCaigouXq;
	}

	public InstrumentCaigouXq removeInstrumentCaigouXq(InstrumentCaigouXq instrumentCaigouXq) {
		getInstrumentCaigouXqs().remove(instrumentCaigouXq);
		instrumentCaigouXq.setInstrument(null);

		return instrumentCaigouXq;
	}

	public List<InstrumentLogin> getInstrumentLogins() {
		return this.instrumentLogins;
	}

	public void setInstrumentLogins(List<InstrumentLogin> instrumentLogins) {
		this.instrumentLogins = instrumentLogins;
	}

	public InstrumentLogin addInstrumentLogin(InstrumentLogin instrumentLogin) {
		getInstrumentLogins().add(instrumentLogin);
		instrumentLogin.setInstrument(this);

		return instrumentLogin;
	}

	public InstrumentLogin removeInstrumentLogin(InstrumentLogin instrumentLogin) {
		getInstrumentLogins().remove(instrumentLogin);
		instrumentLogin.setInstrument(null);

		return instrumentLogin;
	}

	public List<InstrumentRkXq> getInstrumentRkXqs() {
		return this.instrumentRkXqs;
	}

	public void setInstrumentRkXqs(List<InstrumentRkXq> instrumentRkXqs) {
		this.instrumentRkXqs = instrumentRkXqs;
	}

	public InstrumentRkXq addInstrumentRkXq(InstrumentRkXq instrumentRkXq) {
		getInstrumentRkXqs().add(instrumentRkXq);
		instrumentRkXq.setInstrument(this);

		return instrumentRkXq;
	}

	public InstrumentRkXq removeInstrumentRkXq(InstrumentRkXq instrumentRkXq) {
		getInstrumentRkXqs().remove(instrumentRkXq);
		instrumentRkXq.setInstrument(null);

		return instrumentRkXq;
	}

	public List<QxLnventoryqx> getQxLnventoryqxs() {
		return this.qxLnventoryqxs;
	}

	public void setQxLnventoryqxs(List<QxLnventoryqx> qxLnventoryqxs) {
		this.qxLnventoryqxs = qxLnventoryqxs;
	}

	public QxLnventoryqx addQxLnventoryqx(QxLnventoryqx qxLnventoryqx) {
		getQxLnventoryqxs().add(qxLnventoryqx);
		qxLnventoryqx.setInstrument(this);

		return qxLnventoryqx;
	}

	public QxLnventoryqx removeQxLnventoryqx(QxLnventoryqx qxLnventoryqx) {
		getQxLnventoryqxs().remove(qxLnventoryqx);
		qxLnventoryqx.setInstrument(null);

		return qxLnventoryqx;
	}

	public List<QxReturngoosqx> getQxReturngoosqxs() {
		return this.qxReturngoosqxs;
	}

	public void setQxReturngoosqxs(List<QxReturngoosqx> qxReturngoosqxs) {
		this.qxReturngoosqxs = qxReturngoosqxs;
	}

	public QxReturngoosqx addQxReturngoosqx(QxReturngoosqx qxReturngoosqx) {
		getQxReturngoosqxs().add(qxReturngoosqx);
		qxReturngoosqx.setInstrument(this);

		return qxReturngoosqx;
	}

	public QxReturngoosqx removeQxReturngoosqx(QxReturngoosqx qxReturngoosqx) {
		getQxReturngoosqxs().remove(qxReturngoosqx);
		qxReturngoosqx.setInstrument(null);

		return qxReturngoosqx;
	}

	public List<QxReturnqx> getQxReturnqxs() {
		return this.qxReturnqxs;
	}

	public void setQxReturnqxs(List<QxReturnqx> qxReturnqxs) {
		this.qxReturnqxs = qxReturnqxs;
	}

	public QxReturnqx addQxReturnqx(QxReturnqx qxReturnqx) {
		getQxReturnqxs().add(qxReturnqx);
		qxReturnqx.setInstrument(this);

		return qxReturnqx;
	}

	public QxReturnqx removeQxReturnqx(QxReturnqx qxReturnqx) {
		getQxReturnqxs().remove(qxReturnqx);
		qxReturnqx.setInstrument(null);

		return qxReturnqx;
	}

	public List<QxThelibraryqx> getQxThelibraryqxs() {
		return this.qxThelibraryqxs;
	}

	public void setQxThelibraryqxs(List<QxThelibraryqx> qxThelibraryqxs) {
		this.qxThelibraryqxs = qxThelibraryqxs;
	}

	public QxThelibraryqx addQxThelibraryqx(QxThelibraryqx qxThelibraryqx) {
		getQxThelibraryqxs().add(qxThelibraryqx);
		qxThelibraryqx.setInstrument(this);

		return qxThelibraryqx;
	}

	public QxThelibraryqx removeQxThelibraryqx(QxThelibraryqx qxThelibraryqx) {
		getQxThelibraryqxs().remove(qxThelibraryqx);
		qxThelibraryqx.setInstrument(null);

		return qxThelibraryqx;
	}

	public List<QxUseqx> getQxUseqxs() {
		return this.qxUseqxs;
	}

	public void setQxUseqxs(List<QxUseqx> qxUseqxs) {
		this.qxUseqxs = qxUseqxs;
	}

	public QxUseqx addQxUseqx(QxUseqx qxUseqx) {
		getQxUseqxs().add(qxUseqx);
		qxUseqx.setInstrument(this);

		return qxUseqx;
	}

	public QxUseqx removeQxUseqx(QxUseqx qxUseqx) {
		getQxUseqxs().remove(qxUseqx);
		qxUseqx.setInstrument(null);

		return qxUseqx;
	}

}