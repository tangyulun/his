package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HOUSE_TYPE database table.
 * 
 */
@Entity
@Table(name="HOUSE_TYPE")
@NamedQuery(name="HouseType.findAll", query="SELECT h FROM HouseType h")
public class HouseType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HOUSE_TYPE_ID")
	private long houseTypeId;

	@Column(name="HOUSE_TYPE_NAME")
	private String houseTypeName;

	//bi-directional many-to-one association to Bed
	@OneToMany(mappedBy="houseType")
	private List<Bed> beds;

	public HouseType() {
	}

	public long getHouseTypeId() {
		return this.houseTypeId;
	}

	public void setHouseTypeId(long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getHouseTypeName() {
		return this.houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public List<Bed> getBeds() {
		return this.beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public Bed addBed(Bed bed) {
		getBeds().add(bed);
		bed.setHouseType(this);

		return bed;
	}

	public Bed removeBed(Bed bed) {
		getBeds().remove(bed);
		bed.setHouseType(null);

		return bed;
	}

}