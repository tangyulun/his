package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BED_TYPE database table.
 * 
 */
@Entity
@Table(name="BED_TYPE")
@NamedQuery(name="BedType.findAll", query="SELECT b FROM BedType b")
public class BedType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BED_TYPE_ID")
	private long bedTypeId;

	@Column(name="BED_TYPE_NAME")
	private String bedTypeName;

	//bi-directional many-to-one association to Bed
	@OneToMany(mappedBy="bedType")
	private List<Bed> beds;

	//bi-directional many-to-one association to BedTypeType
	@ManyToOne
	@JoinColumn(name="BED_TYPE_TYPE_ID")
	private BedTypeType bedTypeType;

	public BedType() {
	}

	public long getBedTypeId() {
		return this.bedTypeId;
	}

	public void setBedTypeId(long bedTypeId) {
		this.bedTypeId = bedTypeId;
	}

	public String getBedTypeName() {
		return this.bedTypeName;
	}

	public void setBedTypeName(String bedTypeName) {
		this.bedTypeName = bedTypeName;
	}

	public List<Bed> getBeds() {
		return this.beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public Bed addBed(Bed bed) {
		getBeds().add(bed);
		bed.setBedType(this);

		return bed;
	}

	public Bed removeBed(Bed bed) {
		getBeds().remove(bed);
		bed.setBedType(null);

		return bed;
	}

	public BedTypeType getBedTypeType() {
		return this.bedTypeType;
	}

	public void setBedTypeType(BedTypeType bedTypeType) {
		this.bedTypeType = bedTypeType;
	}

}