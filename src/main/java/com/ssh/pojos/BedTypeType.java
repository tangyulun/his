package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BED_TYPE_TYPE database table.
 * 
 */
@Entity
@Table(name="BED_TYPE_TYPE")
@NamedQuery(name="BedTypeType.findAll", query="SELECT b FROM BedTypeType b")
public class BedTypeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BED_TYPE_TYPE_ID")
	private long bedTypeTypeId;

	@Column(name="BED_TYPE_TYPE_NAME")
	private String bedTypeTypeName;

	//bi-directional many-to-one association to BedType
	@OneToMany(mappedBy="bedTypeType")
	private List<BedType> bedTypes;

	public BedTypeType() {
	}

	public long getBedTypeTypeId() {
		return this.bedTypeTypeId;
	}

	public void setBedTypeTypeId(long bedTypeTypeId) {
		this.bedTypeTypeId = bedTypeTypeId;
	}

	public String getBedTypeTypeName() {
		return this.bedTypeTypeName;
	}

	public void setBedTypeTypeName(String bedTypeTypeName) {
		this.bedTypeTypeName = bedTypeTypeName;
	}

	public List<BedType> getBedTypes() {
		return this.bedTypes;
	}

	public void setBedTypes(List<BedType> bedTypes) {
		this.bedTypes = bedTypes;
	}

	public BedType addBedType(BedType bedType) {
		getBedTypes().add(bedType);
		bedType.setBedTypeType(this);

		return bedType;
	}

	public BedType removeBedType(BedType bedType) {
		getBedTypes().remove(bedType);
		bedType.setBedTypeType(null);

		return bedType;
	}

}