package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CAOZUO_LOGGER database table.
 * 
 */
@Entity
@Table(name="CAOZUO_LOGGER")
@NamedQuery(name="CaozuoLogger.findAll", query="SELECT c FROM CaozuoLogger c")
public class CaozuoLogger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAOZUO_LOGGER")
	private long caozuoLogger;

	@Column(name="CAOZUO_DATE")
	private Timestamp caozuoDate;

	@Column(name="CAOZUO_MESSAGE")
	private String caozuoMessage;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public CaozuoLogger() {
	}

	public long getCaozuoLogger() {
		return this.caozuoLogger;
	}

	public void setCaozuoLogger(long caozuoLogger) {
		this.caozuoLogger = caozuoLogger;
	}

	public Timestamp getCaozuoDate() {
		return this.caozuoDate;
	}

	public void setCaozuoDate(Timestamp caozuoDate) {
		this.caozuoDate = caozuoDate;
	}

	public String getCaozuoMessage() {
		return this.caozuoMessage;
	}

	public void setCaozuoMessage(String caozuoMessage) {
		this.caozuoMessage = caozuoMessage;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}