package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FUKUAN database table.
 * 
 */
@Entity
@NamedQuery(name="Fukuan.findAll", query="SELECT f FROM Fukuan f")
public class Fukuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FUKUAN_ID")
	private long fukuanId;

	@Column(name="FUKUAN_NAME")
	private String fukuanName;

	//bi-directional many-to-one association to FukuanRecord
	@OneToMany(mappedBy="fukuan")
	private List<FukuanRecord> fukuanRecords;

	public Fukuan() {
	}

	public long getFukuanId() {
		return this.fukuanId;
	}

	public void setFukuanId(long fukuanId) {
		this.fukuanId = fukuanId;
	}

	public String getFukuanName() {
		return this.fukuanName;
	}

	public void setFukuanName(String fukuanName) {
		this.fukuanName = fukuanName;
	}

	public List<FukuanRecord> getFukuanRecords() {
		return this.fukuanRecords;
	}

	public void setFukuanRecords(List<FukuanRecord> fukuanRecords) {
		this.fukuanRecords = fukuanRecords;
	}

	public FukuanRecord addFukuanRecord(FukuanRecord fukuanRecord) {
		getFukuanRecords().add(fukuanRecord);
		fukuanRecord.setFukuan(this);

		return fukuanRecord;
	}

	public FukuanRecord removeFukuanRecord(FukuanRecord fukuanRecord) {
		getFukuanRecords().remove(fukuanRecord);
		fukuanRecord.setFukuan(null);

		return fukuanRecord;
	}

}