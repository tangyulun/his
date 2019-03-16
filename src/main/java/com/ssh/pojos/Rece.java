package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RECE database table.
 * 
 */
@Entity
@NamedQuery(name="Rece.findAll", query="SELECT r FROM Rece r")
public class Rece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECE_ID")
	private long receId;

	@Column(name="RECE_NAME")
	private String receName;

	//bi-directional many-to-one association to ReceRecord
	@OneToMany(mappedBy="rece")
	private List<ReceRecord> receRecords;

	public Rece() {
	}

	public long getReceId() {
		return this.receId;
	}

	public void setReceId(long receId) {
		this.receId = receId;
	}

	public String getReceName() {
		return this.receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public List<ReceRecord> getReceRecords() {
		return this.receRecords;
	}

	public void setReceRecords(List<ReceRecord> receRecords) {
		this.receRecords = receRecords;
	}

	public ReceRecord addReceRecord(ReceRecord receRecord) {
		getReceRecords().add(receRecord);
		receRecord.setRece(this);

		return receRecord;
	}

	public ReceRecord removeReceRecord(ReceRecord receRecord) {
		getReceRecords().remove(receRecord);
		receRecord.setRece(null);

		return receRecord;
	}

}