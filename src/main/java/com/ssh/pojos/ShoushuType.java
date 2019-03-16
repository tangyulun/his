package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOUSHU_TYPE database table.
 * 
 */
@Entity
@Table(name="SHOUSHU_TYPE")
@NamedQuery(name="ShoushuType.findAll", query="SELECT s FROM ShoushuType s")
public class ShoushuType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHOUSHU_TYPE_ID")
	private long shoushuTypeId;

	@Column(name="SHOUSHU_TYPE_NAME")
	private String shoushuTypeName;

	//bi-directional many-to-one association to Shoushu
	@OneToMany(mappedBy="shoushuTypeBean")
	private List<Shoushu> shoushus;

	public ShoushuType() {
	}

	public long getShoushuTypeId() {
		return this.shoushuTypeId;
	}

	public void setShoushuTypeId(long shoushuTypeId) {
		this.shoushuTypeId = shoushuTypeId;
	}

	public String getShoushuTypeName() {
		return this.shoushuTypeName;
	}

	public void setShoushuTypeName(String shoushuTypeName) {
		this.shoushuTypeName = shoushuTypeName;
	}

	public List<Shoushu> getShoushus() {
		return this.shoushus;
	}

	public void setShoushus(List<Shoushu> shoushus) {
		this.shoushus = shoushus;
	}

	public Shoushu addShoushus(Shoushu shoushus) {
		getShoushus().add(shoushus);
		shoushus.setShoushuTypeBean(this);

		return shoushus;
	}

	public Shoushu removeShoushus(Shoushu shoushus) {
		getShoushus().remove(shoushus);
		shoushus.setShoushuTypeBean(null);

		return shoushus;
	}

}